package com.denton.biergarten;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.TabHost;

public class BierGartenActivity extends TabActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Resources res = getResources(); // Resource object to get Drawables
        TabHost tabHost = getTabHost();  // The activity TabHost
        tabHost.setBackgroundColor(Color.parseColor("#6A2C0C"));
        tabHost.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        
        tabHost.setVerticalScrollBarEnabled(false);
        TabHost.TabSpec spec;  // Reusable TabSpec for each tab
        Intent intent;  // Reusable Intent for each tab

        // Create an Intent to launch an Activity for the tab (to be reused)
        intent = new Intent().setClass(this, DasBierActivity.class);


        
        // Initialize a TabSpec for each tab and add it to the TabHost
        spec = tabHost.newTabSpec("bier").setIndicator("Das Bier",
                          res.getDrawable(R.drawable.beerlong))
                      .setContent(intent);
        tabHost.addTab(spec);

        intent = new Intent().setClass(this, DasPlacesActivity.class);
        spec = tabHost.newTabSpec("places").setIndicator("Das Places",
                          res.getDrawable(R.drawable.placeslong))
                      .setContent(intent);
        tabHost.addTab(spec);
        
        intent = new Intent().setClass(this, DasBuddyActivity.class);
        spec = tabHost.newTabSpec("buddy").setIndicator("Das Buddies",
                          res.getDrawable(R.drawable.beerbuddylong))
                      .setContent(intent);
        tabHost.addTab(spec);

        tabHost.setCurrentTab(0);
    }
}