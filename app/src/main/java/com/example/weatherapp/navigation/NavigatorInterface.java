package com.example.weatherapp.navigation;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public interface NavigatorInterface {


  void setNavigator(@Nullable final Navigator navigator);

  boolean go(@NonNull int link, @NonNull Object... args);

}
