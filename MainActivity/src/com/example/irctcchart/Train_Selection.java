package com.example.irctcchart;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Train_Selection extends Activity {

	Spinner train,coach;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_train__selection);
		
		train=(Spinner)findViewById(R.id.train_spin);
		coach=(Spinner)findViewById(R.id.coach1_spin);
		
		ArrayAdapter<CharSequence> tadap=ArrayAdapter.createFromResource(getApplicationContext(), R.array.train_array, android.R.layout.simple_spinner_item);
		ArrayAdapter<CharSequence> cadap=ArrayAdapter.createFromResource(getApplicationContext(), R.array.bogi_no, android.R.layout.simple_spinner_item);
		
		tadap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		cadap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		train.setAdapter(tadap);
		coach.setAdapter(cadap);
		
		
		
	}
	
	public void onGet(View v)
	{
		
		Intent i=new Intent(Train_Selection.this,Main_Chart.class);
		i.putExtra("Train", train.getSelectedItem().toString());
		i.putExtra("Coach", coach.getSelectedItemPosition());
		startActivity(i);
		
	}
}
