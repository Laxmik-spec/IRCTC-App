package com.example.irctcchart;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

class Passenger
{
	public int seat_no,Age;
	public String Name,Gender,from,to,pnr,ticket;
}

public class Main_Chart extends Activity {
	
	Spinner coach_spin;
	ListView l1;
	TextView train_name;
	TextView age,gender,from,to,ticket,pnr;
	String tr_name;
	public static Passenger[] ps;
	public static int sz=-1,index=0;
	public static boolean flag=true;
	Handler h;
	DatabaseOperations dop;
	String co_name;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main__chart);
		
		h=new Handler();
		
		l1=(ListView)findViewById(R.id.chart_list);
		train_name=(TextView)findViewById(R.id.train_tv);
		coach_spin=(Spinner)findViewById(R.id.coach2_spin);
		age=(TextView)findViewById(R.id.page_tv);
		gender=(TextView)findViewById(R.id.pgender_tv);
		from=(TextView)findViewById(R.id.pfrom_tv);
		to=(TextView)findViewById(R.id.pto_tv);
		pnr=(TextView)findViewById(R.id.ppnr_tv);
		ticket=(TextView)findViewById(R.id.ptktno_tv);
		
		train_name.setText(getIntent().getExtras().getString("Train"));
				
		ArrayAdapter<CharSequence> cadap=ArrayAdapter.createFromResource(getApplicationContext(), R.array.bogi_no, android.R.layout.simple_spinner_item);
		cadap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		coach_spin.setAdapter(cadap);
		coach_spin.setSelection(getIntent().getExtras().getInt("Coach"));
		
		tr_name=train_name.getText().toString();
		co_name=coach_spin.getSelectedItem().toString();
		
		//SQLiteDatabase db=SQLiteDatabase.openDatabase("IRCTCChart.db",null,0);
		makeList();
		MyTh th=new MyTh(getApplicationContext());
		th.start();
	}
	
	public void makeList()
	{
		dop=new DatabaseOperations(getApplicationContext());
		Cursor cursor=dop.getChart(tr_name,co_name);
		sz=cursor.getCount();
		//Toast.makeText(getApplicationContext(), "Cols:"+cursor.getColumnCount(), Toast.LENGTH_LONG).show();
		//Log.d("COLS:", cursor.getColumnCount()+"");
		ps=new Passenger[sz];
		int i=0;
		if(cursor.moveToFirst())
		{
			do
			{
				ps[i]=new Passenger();
				ps[i].seat_no=cursor.getInt(0);
				ps[i].Name=cursor.getString(1);
				ps[i].Age=cursor.getInt(2);
				ps[i].Gender=cursor.getString(3);
				ps[i].from=cursor.getString(4);
				ps[i].to=cursor.getString(5);
				ps[i].pnr=cursor.getString(6);
				ps[i].ticket=cursor.getString(7);
				i++;
			}while(cursor.moveToNext());
		}
		l1.setAdapter(new CustomListAdapter(getApplicationContext()));
	}
	
	public void onRefresh(View v)
	{
		int limit=CustomListAdapter.getTotalEmpty();
		Toast.makeText(getApplicationContext(), "Empty:"+limit, Toast.LENGTH_LONG).show();
		if(limit>0)
		{
			int i=0;
			Cursor cursor=dop.getWaiting(tr_name, limit);
			int cnt=cursor.getCount();
			if(cursor.moveToFirst())
			{
				do
				{
					int seat=CustomListAdapter.free_seat(i++)+1;
					String query="insert into passenger values("+seat+",'"+cursor.getString(1)+"','"+cursor.getString(2)+"','"+cursor.getString(3)+"','"+cursor.getString(4)+"','"+cursor.getString(5)+"','"+cursor.getString(6)+"',"+cursor.getString(7)+",'"+coach_spin.getSelectedItem()+"','"+tr_name+"')";
					dop.insquery(query);
					query="delete from waiting_list where Name='"+cursor.getString(1)+"' and PNR_No='"+cursor.getString(6)+"'";
					dop.insquery(query);
				}while(cursor.moveToNext());
			}
			makeList();
			/*for(int i=0;i<limit;i++)
			{
				int seat=CustomListAdapter.free_seat(i)+1;
				Toast.makeText(getApplicationContext(), "Seat: "+seat, Toast.LENGTH_LONG).show();
				
			}*/
		}
		/*
		
		*/
	}

	class MyTh extends Thread
	{
		Context con;
		public MyTh(Context c)
		{
			con=c;
		}
		public void run()
		{
			while(true)
			{
				while(flag);
				h.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						if(index==-1)
						{
							age.setText("AGE: -");
							gender.setText("Gender: -");
							from.setText("From: -");
							to.setText("To: -");
							pnr.setText("PNR: -");
							ticket.setText("Ticket Number: -");
						}
						else
						{
							age.setText("AGE: "+ps[index].Age);
							gender.setText("Gender: "+ps[index].Gender);
							from.setText("From: "+ps[index].from);
							to.setText("To: "+ps[index].to);
							pnr.setText("PNR: "+ps[index].pnr);
							ticket.setText("Ticket Number: "+ps[index].ticket);
						}
					}
				});
				
				flag=true;
			}
		}
	}
}
