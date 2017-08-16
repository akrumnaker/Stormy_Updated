// Generated code from Butter Knife. Do not modify!
package com.example.aaron.stormy.ui;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.aaron.stormy.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DailyForecast_ViewBinding implements Unbinder {
  private DailyForecast target;

  @UiThread
  public DailyForecast_ViewBinding(DailyForecast target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public DailyForecast_ViewBinding(DailyForecast target, View source) {
    this.target = target;

    target.mReturnButton = Utils.findRequiredViewAsType(source, R.id.returnButton, "field 'mReturnButton'", ImageView.class);
    target.mDailyForecastLayout = Utils.findRequiredViewAsType(source, R.id.daily_weather_layout, "field 'mDailyForecastLayout'", ConstraintLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DailyForecast target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mReturnButton = null;
    target.mDailyForecastLayout = null;
  }
}
