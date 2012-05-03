package com.denton.biergarten;

//import android.app.Activity;
import android.os.Bundle;
import com.phonegap.*;
///I am Zach Test 321 GO

public class DasPlacesActivity extends DroidGap {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.loadUrl("file:///android_asset/www/places.html");
       
  }
}
