package com.example.irctcchart;

//import android.location.GpsStatus.NmeaListener;

import android.os.Bundle;



import android.app.Activity;
//import android.content.Context;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;

import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText USERNAME,PASSWORD;
	String username,password;      
	Context CTX=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       
       
        Button login=(Button)findViewById(R.id.button1);
        USERNAME=(EditText)findViewById(R.id.editText1);
        PASSWORD=(EditText)findViewById(R.id.editText2);
        final TextView register=(TextView)findViewById(R.id.textView1);
        
   
        
        login.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
			Intent i=new Intent(MainActivity.this,Train_Selection.class);
			startActivity(i);
			
		/*
			username = USERNAME.getText().toString();
			password = PASSWORD.getText().toString();
			DatabaseOperations DOP=new DatabaseOperations(CTX);
			Cursor CR=DOP.getInformation(DOP);
			CR.moveToFirst();
			Boolean loginstatus = false;
			String NAME="";
			
			do
			{
				if(username.equals(CR.getString(0))  &&  (password.equals(CR.getString(1))))
			{
						loginstatus=true;
						NAME = CR.getString(0);
			}
			}while(CR.moveToNext());
			
			if(loginstatus)
			{
						Toast.makeText(getApplicationContext(), "Log In", Toast.LENGTH_LONG).show();
						try{
							Intent i = new Intent(MainActivity.this,IRCTCChart.class);
							startActivity(i);
						}
						catch (Exception e) {
							
						}
			}		
			
			else
			{
				Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_LONG).show();
				//finish();
			}
			*/
		}
	});

    
    register.setOnClickListener(new OnClickListener(){
    	
    	
    	public void onClick(View v){
    	
    	Intent i=new Intent(MainActivity.this,Registration.class);
    	startActivity(i);
    		
    	}
    });
    
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
