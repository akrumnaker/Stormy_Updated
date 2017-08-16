// Generated code from Butter Knife. Do not modify!
package com.example.aaron.stormy.ui;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.aaron.stormy.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DayForecast_ViewBinding implements Unbinder {
  private DayForecast target;

  @UiThread
  public DayForecast_ViewBinding(DayForecast target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public DayForecast_ViewBinding(DayForecast target, View source) {
    this.target = target;

    target.mReturnButton = Utils.findRequiredViewAsType(source, R.id.returnButton, "field 'mReturnButton'", ImageView.class);
    target.mDayForecastLayout = Utils.findRequiredViewAsType(source, R.id.dayForecast, "field 'mDayForecastLayout'", ConstraintLayout.class);
    target.mSummaryLabel = Utils.findRequiredViewAsType(source, R.id.summaryLabel, "field 'mSummaryLabel'", TextView.class);
    target.mTemperatureHighLabel = Utils.findRequiredViewAsType(source, R.id.temperatureHighLabel, "field 'mTemperatureHighLabel'", TextView.class);
    target.mTemperatureLowLabel = Utils.findRequiredViewAsType(source, R.id.temperatureLowLabel, "field 'mTemperatureLowLabel'", TextView.class);
    target.mHumidityValue = Utils.findRequiredViewAsType(source, R.id.humidityValue, "field 'mHumidityValue'", TextView.class);
    target.mWindDirectionValue = Utils.findRequiredViewAsType(source, R.id.windDirectionValue, "field 'mWindDirectionValue'", TextView.class);
    target.mWindValue = Utils.findRequiredViewAsType(source, R.id.windValue, "field 'mWindValue'", TextView.class);
    target.mPrecipValue = Utils.findRequiredViewAsType(source, R.id.precipValue, "field 'mPrecipValue'", TextView.class);
    target.mTimeLabel = Utils.findRequiredViewAsType(source, R.id.timeLabel, "field 'mTimeLabel'", TextView.class);
    target.mUVIndexValue = Utils.findRequiredViewAsType(source, R.id.uvIndexValue, "field 'mUVIndexValue'", TextView.class);
    target.mIconImageView = Utils.findRequiredViewAsType(source, R.id.iconImageView, "field 'mIconImageView'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DayForecast target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mReturnButton = null;
    target.mDayForecastLayout = null;
    target.mSummaryLabel = null;
    target.mTemperatureHighLabel = null;
    target.mTemperatureLowLabel = null;
    target.mHumidityValue = null;
    target.mWindDirectionValue = null;
    target.mWindValue = null;
    target.mPrecipValue = null;
    target.mTimeLabel = null;
    target.mUVIndexValue = null;
    target.mIconImageView = null;
  }
}
