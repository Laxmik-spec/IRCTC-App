
package com.example.irctcchart;

//import java.util.ArrayList;

//import java.util.List;

import android.os.Bundle;


import android.app.Activity;
import android.content.Intent;
//import android.content.Intent;
//import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils.TruncateAt;
//import android.util.Log;
//import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
//import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
//import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class IRCTCChart extends Activity implements OnItemSelectedListener {

	int arg,args;
	Spinner s1,s2;
	TextView textView1;
	String[] sp21I={"Select Coach","C1","D1","D2","D3","D4","D5","D6","D7","D8","D9","D10","D11","D12"};
	String[] sp22I={"Select Coach","C1","C2","D1","D2","D3","D4","D5","D6","D7","D8"};

	ArrayAdapter<String> sp21A;
	ArrayAdapter<String> sp22A;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_irctcchart);
		
		//getActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.material_blue_gray1))); 
		textView1=(TextView)findViewById(R.id.textView1);
		
		final Button submit=(Button)findViewById(R.id.button1);
		final Button reset=(Button)findViewById(R.id.button2);
		s1=(Spinner)findViewById(R.id.spinner1);
		s2=(Spinner)findViewById(R.id.spinner2);
		
		
		textView1.setSelected(true); 
		textView1.setEllipsize(TruncateAt.MARQUEE);
		textView1.setSingleLine(true);
		
		 final ArrayAdapter<String> sp21A = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sp21I);
	     final ArrayAdapter<String> sp22A = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sp22I);

	  	    s1.setOnItemSelectedListener(new OnItemSelectedListener() {
	   
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				arg=arg2;
				// TODO Auto-generated method stub
				if(arg2==1||arg2==2)
				{
					s2.setAdapter(sp21A);
				}
				else /*if(arg2==3||arg2==4)*/{
					s2.setAdapter(sp22A);
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
	    	
		
	    });
	    
	  	  s2.setOnItemSelectedListener(new OnItemSelectedListener() {

				@Override
				public void onItemSelected(AdapterView<?> arg0,
						View arg1, int arg2, long arg3) {
					// TODO Auto-generated method stub
					args=arg2;
				}

				@Override
				public void onNothingSelected(AdapterView<?> arg0) {
					// TODO Auto-generated method stub
					
				}
			});
	    
		
		
		reset.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				s1.clearAnimation();
				
			}
		});
		submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
						// TODO Auto-generated method stub
				
						if(arg==0)
						{
							Toast.makeText(getBaseContext(), "Please Select train no.", Toast.LENGTH_LONG).show();
							return;
						}
						
						 if(args==0)
							{
								Toast.makeText(getBaseContext(), "Please Select Coach no.", Toast.LENGTH_LONG).show();
								return;
							}
					
				Intent intent = new Intent(IRCTCChart.this,Chart.class);
				startActivity(intent); 
			}
		});
		reset.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1.setSelection(0);
				s2.setSelection(0);
			}
		});
	}	
	
	
	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}

	
		
	
}