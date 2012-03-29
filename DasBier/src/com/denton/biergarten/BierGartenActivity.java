package com.denton.biergarten;

import android.app.TabActivity;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TabHost;
import android.widget.TextView;

public class BierGartenActivity extends TabActivity {
    /** Called when the activity is first created. */
	
	///////3/29
    PopupWindow popUp;
    LinearLayout layout;
    TextView tv;
    LayoutParams params;
    LinearLayout mainLayout;
    Button but;
    boolean click = true;
    /////3/29
	
	
	
	
 /*   @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);*/
        
        ////////////////////////3/29
        

        @Override
        public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         popUp = new PopupWindow(this);
         layout = new LinearLayout(this);
         mainLayout = new LinearLayout(this);
         tv = new TextView(this);
         but = new Button(this);
         but.setText("Click Me");
         but.setOnClickListener(new View.OnClickListener() {

          public void onClick(View v) {
           if (click) {
            popUp.showAtLocation(layout, Gravity.BOTTOM, 10, 10);
            popUp.update(50, 50, 300, 80);
            click = false;
           } else {
            popUp.dismiss();
            click = true;
           }
          }

         });
         params = new LayoutParams(LayoutParams.WRAP_CONTENT,
           LayoutParams.WRAP_CONTENT);
         layout.setOrientation(LinearLayout.VERTICAL);
         tv.setText("Hi this is a sample text for popup window");
         layout.addView(tv, params);
         popUp.setContentView(layout);
         // popUp.showAtLocation(layout, Gravity.BOTTOM, 10, 10);
         mainLayout.addView(but, params);
         setContentView(mainLayout);
        }
}
        
        
        
        
        
        
        
        
        
        /////////////////////////////////////3/29 end
/*
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
        
        intent = new Intent().setClass(this, DasBuddyActivity.class);
        spec = tabHost.newTabSpec("buddies").setIndicator("Das Buddies",
                          res.getDrawable(R.drawable.beerbuddylong))
                      .setContent(intent);
        tabHost.addTab(spec);

        tabHost.setCurrentTab(0);
    }
}*/