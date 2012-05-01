package com.denton.biergarten;

//import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.phonegap.DroidGap;


public class DasBuddyActivity extends DroidGap {


	private SharedPreferences UandP;
	public static final String PREFERENCE_FILENAME = "UandPStuff";
	
    protected void onResume() {
        super.onResume();
        
        
        String unm=UandP.getString("username", null);       
		String pass = UandP.getString("password", null);
        
        
        super.loadUrl("file:///android_asset/www/buddy.html?UN="+unm+"&PW="+pass+"&");
        
    

        //...Now update your objects with preference values         
    }
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        

        
	    UandP = this.getSharedPreferences("PREFERENCE_FILENAME", MODE_PRIVATE);
        SharedPreferences sp1=this.getSharedPreferences("PREFERENCE_FILENAME", MODE_PRIVATE);
		String unm=sp1.getString("username", null);       
		String pass = sp1.getString("password", null);
        
        
        super.loadUrl("file:///android_asset/www/buddy.html?UN="+unm+"&PW="+pass+"&");
    }
}
/*
public class DasBuddyActivity extends Activity {
    
  
	private SharedPreferences UandP;
	public static final String PREFERENCE_FILENAME = "UandPStuff";
	
	public void onCreate(Bundle savedInstanceState) 
	{
	    super.onCreate(savedInstanceState);
	    UandP = this.getSharedPreferences("PREFERENCE_FILENAME", MODE_PRIVATE);
	    
	    
	    
	    if(UandP.getString("username", null) != null) 
	    {
	        setContentView(R.layout.main);
	            // do rest of the code
	        
	        SharedPreferences sp1=this.getSharedPreferences("PREFERENCE_FILENAME", MODE_PRIVATE);
			String unm=sp1.getString("username", null);       
			String pass = sp1.getString("password", null);
			
			TextView tv = new TextView(this);
		       tv.setText(unm+" Nuddy, Android " + pass);
		       setContentView(tv);
			
	    }
	    
	    else 
	    {
	            setContentView(R.layout.popupuserpass);
	            final EditText editText1 = (EditText) findViewById(R.id.editText1);
	            final EditText editText2 = (EditText) findViewById(R.id.editText2);
	            
	            Button buttonA = (Button) findViewById(R.id.button1);

	            buttonA.setOnClickListener(new View.OnClickListener() 
	            {
	            	
	                @Override
	                public void onClick(View v) 
	                {
	                    SharedPreferences.Editor UandPEditor = UandP.edit();
	                    UandPEditor.putString("username", editText1.getText().toString());
	                    UandPEditor.putString("password", editText2.getText().toString());
	                    UandPEditor.commit();
	                }

	            }); 
	                    // do some other stuff...
	    }
	}
	
	
}*/