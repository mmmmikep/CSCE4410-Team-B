package com.denton.biergarten;

//import android.app.Activity;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ResetUP extends Activity {
    /** Called when the activity is first created. */
	private SharedPreferences UandP;
	public static final String PREFERENCE_FILENAME = "UandPStuff";
	
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
    	///new code 5/1/12
    	
    	final Intent myLocalIntent = getIntent();
        final Bundle myBundle = myLocalIntent.getExtras();


     //   String str1 = myBundle.getString("myString1");
     //   double dob1 = myBundle.getDouble("myDouble1");
     //   int[]  arr1 = myBundle.getIntArray("myIntArray1");
        
        //end of new code 5/1/12
        
        
        
        UandP = this.getSharedPreferences("PREFERENCE_FILENAME", MODE_PRIVATE);
        
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
                
                myBundle.putString("UserN", editText1.getText().toString());
                myBundle.putString("Pass", editText2.getText().toString());
                
                UandPEditor.commit();
                
                myLocalIntent.putExtras(myBundle);

                setResult(Activity.RESULT_OK, myLocalIntent);
                
                finish();
            }
        
        });
    }
}