package com.denton.biergarten;

//import android.app.Activity;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.phonegap.DroidGap;

/*You could extend DroidGap with an override of onResume ( 
http://developer.android.com/reference/android/app/Activity.html#onRe...() 
) and have it call 
WebView.loadUrl("javascript:window.location.reload();"); inside that 
function. That should force the webview to refresh every time the 
Android Activity goes through the Resume phase. */

public class DasBierActivity extends DroidGap {
    /** Called when the activity is first created. */
    
  
	private SharedPreferences UandP;
	public static final String PREFERENCE_FILENAME = "UandPStuff";
	private final int IPC_ID = 1122;
	private String myReturnedString1;
	private String myReturnedString2;
	
	
    public void superUrl(String m_s)
    {

        super.loadUrl(m_s);
		    	
    }
    ///5/1/12 new code
    
    @Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		try {
			switch (requestCode) {
			case IPC_ID: {
				if (resultCode == Activity.RESULT_OK) {

					Bundle myReturnedData = data.getExtras();
					
					myReturnedString1 = myReturnedData
							.getString("UserN");

					myReturnedString2 = myReturnedData
							.getString("Pass");
					
					 super.loadUrl("file:///android_asset/www/bier.html?UN="+myReturnedString1+"&PW="+myReturnedString2+"&");

//					label1Returned.setText(myReturnedString1 + "\n"
	//						+ Double.toString(myReturnedDouble1) + "\n"
		//					+ myReturnedString2);
				} else {

			//		label1.setText("Selection CANCELLED!");
				}
				break;
			}
			}
		} catch (Exception e) {
			Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_LONG)
					.show();
		}
	}

    
    protected void onResume() {
        super.onResume();
        
        
        String unm=UandP.getString("username", null);       
		String pass = UandP.getString("password", null);
        
        
        super.loadUrl("file:///android_asset/www/bier.html?UN="+unm+"&PW="+pass+"&");
        
    

        //...Now update your objects with preference values         
    }
    
///end of new code 5/1/12
    
    
    
    
	
	public void onCreate(Bundle savedInstanceState) 
	{
	    super.onCreate(savedInstanceState);
	    UandP = this.getSharedPreferences("PREFERENCE_FILENAME", MODE_PRIVATE);
	    	    
	    
	    if(UandP.getString("username", null) != null) 
	    {
	        setContentView(R.layout.main);
	            // do rest of the code
	        /*
	        SharedPreferences sp1=this.getSharedPreferences("PREFERENCE_FILENAME", MODE_PRIVATE);
			String unm=sp1.getString("username", null);       
			String pass = sp1.getString("password", null);
*/
	        
	        String unm=UandP.getString("username", null);       
			String pass = UandP.getString("password", null);
	        
	        
	        super.loadUrl("file:///android_asset/www/bier.html?UN="+unm+"&PW="+pass+"&");
			
	    }
	    
	    else 
	    {
	    	
	    	Intent myIntentA1A2 = new Intent(DasBierActivity.this,
					ResetUP.class);

			Bundle myData = new Bundle();
			//myData.putString("myString1", "Hello Android");
		//	myData.putDouble("myDouble1", 3.141592);
		//	int[] myLittleArray = { 1, 2, 3 };
			//myData.putIntArray("myIntArray1", myLittleArray);

			myIntentA1A2.putExtras(myData);

			startActivityForResult(myIntentA1A2,IPC_ID);
			
	    	
	    	/*
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
	                    
	                    ///new code 4/19/12 to make it go to regular das beer.
	                    setContentView(R.layout.main);
	    	            // do rest of the code
	    	       		    			
		    	        String unm=UandP.getString("username", null);       
		    			String pass = UandP.getString("password", null);
			    	        		  
		    	        String m_UserPass="file:///android_asset/www/bier.html?UN="+unm+"&PW="+pass+"&";

		    			
		    			superUrl(m_UserPass);
		                    
	                }

	         }); 
	                    // do some other stuff..
	                     * .
	                     */
	    }
	}
	
	
}