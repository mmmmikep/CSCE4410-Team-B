package com.denton.biergarten;

//import android.app.Activity;
import android.os.Bundle;
import com.phonegap.*;


public class DasBierActivity extends DroidGap {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.loadUrl("file:///android_asset/www/bier.html");
    }
}