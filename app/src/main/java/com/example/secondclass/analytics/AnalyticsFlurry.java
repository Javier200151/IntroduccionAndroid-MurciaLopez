package com.example.secondclass.analytics;

import android.util.Log;
import java.util.Map;
public class AnalyticsFlurry implements AnalyticsAdapter
{
    @Override
    public void report( String name, Map<String, String> data )
    {
        Log.d( "Developer", "report FlurryAnalytics: " + name );
    }
}
