package com.denton.biergarten;

//import android.app.Activity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;


public class DasBierActivity extends Activity {
    /** Called when the activity is first created. */
    
    WebView mWebView;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bier);

        mWebView = (WebView) findViewById(R.id.webview);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl("file:///android_asset/www/bier.html");
        mWebView.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);
    }
}