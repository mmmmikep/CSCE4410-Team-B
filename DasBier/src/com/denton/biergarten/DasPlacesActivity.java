package com.denton.biergarten;

//import android.app.Activity;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.phonegap.DroidGap;

public class DasPlacesActivity extends DroidGap {
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
					
					 super.loadUrl("file:///android_asset/www/PlaceMainMenu.html");

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

///end of new code 5/1/12
    
    

    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
	    UandP = this.getSharedPreferences("PREFERENCE_FILENAME", MODE_PRIVATE);
	    
        super.loadUrl("file:///android_asset/www/PlaceMainMenu.html");
    }
    
  //basic menu button support
    @Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
        super.onCreateOptionsMenu(menu);
        MenuItem item = menu.add("Change Username & Password");

   //     MenuItem item = menu.add("Change Username");
     //   item = menu.add("Change Password");
        return true;
    }
    
  /*  public void updateUsernameAndPassword(String Us, String Pa) 
    {
    //	  String m_UserPass="file:///android_asset/www/bier.html?UN="+Us+"&PW="+Pa+"&";
			
    	String m_UserPass= "file:///android_asset/www/PlaceMainMenu.html";
    	  
    	  //You can make use of onResume() function and add the
    	  //code to load the tab again here.
    			
			super.loadUrl(m_UserPass);

    }*/

    //handle menu item selection
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (item.hasSubMenu() == false)
        {
        	if("Change Username & Password"==item.getTitle()) 
                
            {
        		

            	Intent myIntentA1A2 = new Intent(DasPlacesActivity.this,
 	   					ResetUP.class);

 	   			Bundle myData = new Bundle();

 	   			myIntentA1A2.putExtras(myData);

 	   			startActivityForResult(myIntentA1A2,IPC_ID);
        		
            }
        	
            if("Change Username"==item.getTitle()) 
            
            {
            	Intent myIntentA1A2 = new Intent(DasPlacesActivity.this,
 	   					ResetUP.class);

 	   			Bundle myData = new Bundle();

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
 			    	        		  
 		    			updateUsernameAndPassword(unm, pass);

 		    	    	String m_UserPass="file:///android_asset/www/bier.html?UN="+unm+"&PW="+pass+"&";
 		    	    	  
		    			superUrl(m_UserPass);
 	                }
 	            });
            	
               // super.loadUrl("file:///android_asset/www/index.html");
               // finish();
                * 
                */
            }
            if("Change Password"==item.getTitle()) {
               super.loadUrl("file:///android_asset/www/index.html");
            }
        }
        return true;
    }
}