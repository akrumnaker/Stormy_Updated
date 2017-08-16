package com.example.aaron.stormy.widget;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.location.Geocoder;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.RemoteViews;

import com.example.aaron.stormy.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class WidgetProvider extends AppWidgetProvider{

    private static final String CLOCK_WIDGET_UPDATE = "aaron.example.com.widget.8BITCLOCK_WIDGET";
    private static final String LOG_TAG = WidgetProvider.class.getSimpleName();
    private GoogleApiClient mGoogleApiClient;
    private Geocoder mGeocoder;

    private DateFormat mDateFormat = new SimpleDateFormat("h:mm");

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        Log.d(LOG_TAG, "Received intent " + intent);
        if(intent.getAction().equals(CLOCK_WIDGET_UPDATE)){
            Log.d(LOG_TAG, "Clock update");
            // Get the widget manager and ids for this widget provider, then call the shared clock update method
            ComponentName thisAppWidget = new ComponentName(context.getPackageName(), getClass().getName());
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            int ids[] = appWidgetManager.getAppWidgetIds(thisAppWidget);
            for(int id : ids){
                updateAppWidget(context, appWidgetManager, id);
            }
        }
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        int[] realAppWidgetIds = AppWidgetManager.getInstance(context)
                .getAppWidgetIds(new ComponentName(context, WidgetProvider.class));

        for(int id : realAppWidgetIds){
            // get the layout for the AppWidget
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget);

            Intent intent = new Intent(context, WidgetProvider.class);
            intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, realAppWidgetIds);

            PendingIntent pendingIntent = PendingIntent.getBroadcast(
                    context,
                    0,
                    intent,
                    0
            );

            // attach on-click listener to the button
            remoteViews.setOnClickPendingIntent(R.id.button, pendingIntent);
            // to update the label

            // tell the AppWidgetManager to perform an update on the current appWidget
            appWidgetManager.updateAppWidget(id, remoteViews);

            updateAppWidget(context, appWidgetManager, id);
        }
    }

    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);
        Log.d(LOG_TAG, "Widget Provider enable. Starting timer to update widget every second");
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(Calendar.SECOND, 60);
        alarmManager.setRepeating(AlarmManager.RTC, calendar.getTimeInMillis(), 60000, createClockTickIntent(context));
    }

    @Override
    public void onDisabled(Context context) {
        super.onDisabled(context);
        Log.d(LOG_TAG, "Widget Provider disabled. Turning off timer");
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(createClockTickIntent(context));
    }

    private PendingIntent createClockTickIntent(Context context){
        Intent intent = new Intent(CLOCK_WIDGET_UPDATE);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        return pendingIntent;
    }

    private void updateAppWidget(Context context, AppWidgetManager appWidgetManager, int id){
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget);
        remoteViews.setTextViewText(R.id.widgetLabel, mDateFormat.format(new Date()));
        appWidgetManager.updateAppWidget(id, remoteViews);
    }

//    private void setupWeatherAccess(Context context){
//        mGeocoder = new Geocoder(context);
//
//        mGoogleApiClient = new GoogleApiClient.Builder(context)
//                .addConnectionCallbacks(this)
//                .addOnConnectionFailedListener(this)
//                .addApi(LocationServices.API)
//                .build();
//
//        mGoogleApiClient.connect();
//    }
//
//    @Override
//    public void onConnected(@Nullable Bundle bundle) {
//
//    }
//
//    @Override
//    public void onConnectionSuspended(int i) {
//
//    }
//
//    @Override
//    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
//
//    }
//
//    /**
//     * This method will check if the network is connected
//     * @return isAvailable
//     */
//    private boolean isNetworkAvailable(Context context) {
//        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
//        boolean isAvailable = false;
//        if(networkInfo != null && networkInfo.isConnected()){
//            isAvailable = true;
//        }
//        return isAvailable;
//    }
}
