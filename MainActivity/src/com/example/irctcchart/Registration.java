package com.example.irctcchart;

import android.os.Bundle;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
//import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
//import android.widget.Toast;
import android.widget.Toast;

public class Registration extends Activity {

	EditText et_name,et_address,et_contact,et_emailid,et_password,et_retypepass;
	RadioGroup rg1;
	RadioButton rd_male,rd_female;
	String name,address,emailid,password,retypepass,gender,male,female;
	String contact;
	Button submit,reset;
	Context ctx = this;
	SQLiteDatabase pf;

	/*public void onGenderButtonClicked(View view) {
        boolean radioPressed;
		if(rd_female.isPressed()){
           rd_male.setEnabled(false);
            radioPressed = true;
        } else if (rd_male.isPressed()){
            rd_female.setEnabled(false);
            radioPressed = true;
        } else {
            radioPressed = false;
        }

    }*/
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registration);
				
		 et_name=(EditText)findViewById(R.id.editText1);
		 et_address=(EditText)findViewById(R.id.editText6);
		 et_contact=(EditText)findViewById(R.id.editText2);
		 et_emailid=(EditText)findViewById(R.id.editText3);
		 et_password=(EditText)findViewById(R.id.editText4);
		 et_retypepass=(EditText)findViewById(R.id.editText5);
		 rd_male=(RadioButton)findViewById(R.id.radio0);
		 rd_female=(RadioButton)findViewById(R.id.radio2);
		 submit=(Button)findViewById(R.id.button1);  
		 reset=(Button)findViewById(R.id.button2);
		 
		 Button b=(Button)findViewById(R.id.button1);
		
		 submit.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// check if any of the fields are vaccant
					if(et_name.equals("")||et_address.equals("")||et_contact.equals("")||et_emailid.equals("")||et_password.equals("")||et_retypepass.equals(""))
					{
							Toast.makeText(getApplicationContext(), "Field Vaccant", Toast.LENGTH_LONG).show();
							return;
					}
					
					name=et_name.getText().toString();
					address=et_address.getText().toString();
					contact=et_contact.getText().toString();
					emailid=et_emailid.getText().toString();
					password=et_password.getText().toString();
					retypepass=et_retypepass.getText().toString();
					//male=rd_male.getText().toString();
				//	female=rd_female.getText().toString();
					
					// check if any of the fields are vaccant
					if(name.equals("")||address.equals("")||contact.equals("")||emailid.equals("")||password.equals("")||retypepass.equals(""))
					{
							Toast.makeText(getApplicationContext(), "Field Vaccant", Toast.LENGTH_LONG).show();
							return;
					}
					
				
					// check if both password matches
					 if(!(password.equals(retypepass)))
					 {
						 
						 Toast.makeText(getBaseContext(), "Password not matched", Toast.LENGTH_LONG).show();
						 et_password.setText("");
						 et_retypepass.setText("");
					 }
					 
					 else
					 {
						 DatabaseOperations DB=new DatabaseOperations(ctx);
						 DB.putInformation(DB, name, address, contact,gender, emailid, password);
						 Toast.makeText(getBaseContext(), "Registration Success", Toast.LENGTH_LONG).show();
						 Intent intent = new Intent(Registration.this, MainActivity.class);
							startActivity(intent); 
					 }
					
					
						   
					//finish();
				}
					
			});
		
		reset.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			
				et_name.setText("");
				et_address.setText("");
				et_contact.setText("");
				et_emailid.setText("");
				et_password.setText("");
				et_retypepass.setText("");
				
			}
		});
		
		
		
	
		

		
	}
	
	public void RadioButtonClicked(View view) {

		//This variable will store whether the user was male or female
		//String userGender=""; 
		// Check that the button is  now checked?
		boolean checked = ((RadioButton) view).isChecked();

		// Check which radio button was clicked
		switch(view.getId()) {
		 case R.id.radio0:
		        if (checked)
		           gender = "male";
		        break;
		    case R.id.radio2:
		        if (checked)
		            gender = "female";
		        break;
		   
		}

		
		}

	
}
