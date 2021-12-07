package com.example.secondclass.analytics;

import android.util.Log;

import java.util.Map;

//No estamos integrados aun con Google Analytics, pero en este caso es para el lab
public class GoogleAnalytics implements AnalyticsAdapter
{
    @Override
    public void report( String name, Map<String, String> data )
    {
        Log.d( "Developer", "report GoogleAnalytics: " + name );
    }
}
