// Generated code from Butter Knife. Do not modify!
package com.example.aaron.stormy.ui;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.aaron.stormy.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HourlyForecast_ViewBinding implements Unbinder {
  private HourlyForecast target;

  @UiThread
  public HourlyForecast_ViewBinding(HourlyForecast target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public HourlyForecast_ViewBinding(HourlyForecast target, View source) {
    this.target = target;

    target.mReturnButton = Utils.findRequiredViewAsType(source, R.id.returnButton, "field 'mReturnButton'", ImageView.class);
    target.mRecyclerView = Utils.findRequiredViewAsType(source, R.id.recyclerView, "field 'mRecyclerView'", RecyclerView.class);
    target.mHourlyForecastLayout = Utils.findRequiredViewAsType(source, R.id.hourly_weather_layout, "field 'mHourlyForecastLayout'", ConstraintLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HourlyForecast target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mReturnButton = null;
    target.mRecyclerView = null;
    target.mHourlyForecastLayout = null;
  }
}
