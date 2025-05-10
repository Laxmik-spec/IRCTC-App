package com.example.irctcchart;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Chart extends Activity {

	Spinner coach_spin;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chart);
		
		coach_spin=(Spinner)findViewById(R.id.coach2_spin);
		
		ArrayAdapter<CharSequence> cadap=ArrayAdapter.createFromResource(getApplicationContext(), R.array.bogi_no, android.R.layout.simple_spinner_item);
		
		cadap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		coach_spin.setAdapter(cadap);
	}

}
