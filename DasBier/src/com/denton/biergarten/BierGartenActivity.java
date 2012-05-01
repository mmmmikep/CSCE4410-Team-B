package com.denton.biergarten;

import android.app.TabActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

public class BierGartenActivity extends TabActivity {
    /** Called when the activity is first created. */
	
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        /*
        ////////Shared P
        SharedPreferences sp=getSharedPreferences("Login", 0);
        SharedPreferences.Editor Ed=sp.edit();
        Ed.putString("Unm",ValueU );              
        Ed.putString("Psw",ValueP);   
        Ed.commit();
        
        ///retrieve info
        SharedPreferences sp1=this.getSharedPreferences("Login",null);
		String unm=sp1.getString("Unm", null);       
		String pass = sp1.getString("Psw", null);
        
        /////end of shared P
      */
        Resources res = getResources(); // Resource object to get Drawables
        TabHost tabHost = getTabHost();  // The activity TabHost
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
        
     /*   intent = new Intent().setClass(this, ResetUP.class);
        spec = tabHost.newTabSpec("buddies").setIndicator("Das Buddies",
                res.getDrawable(R.drawable.beerbuddylong))
                      .setContent(intent);
        tabHost.addTab(spec);*/
        
        intent = new Intent().setClass(this, DasBuddyActivity.class);
        spec = tabHost.newTabSpec("buddies").setIndicator("Das Buddies",
                          res.getDrawable(R.drawable.beerbuddylong))
                      .setContent(intent);
        tabHost.addTab(spec);
        
      /*  intent = new Intent().setClass(this, ResetUP.class);
        spec = tabHost.newTabSpec("testA").setIndicator("test1",
                          res.getDrawable(R.drawable.beerbuddylong))
                      .setContent(intent);
        tabHost.addTab(spec);*/

        tabHost.setCurrentTab(0);
    }
}