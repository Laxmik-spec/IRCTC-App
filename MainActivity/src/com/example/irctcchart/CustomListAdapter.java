package com.example.irctcchart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class CustomListAdapter extends BaseAdapter {

	public static LayoutInflater inf;
	Context con;
	public static int sz=20;
	int[] a=new int[sz];
	static int[] chk=new int[sz];
	
	public static int getTotalEmpty()
	{
		int count=0;
		for(int i=0;i<sz;i++)
		{
			if(chk[i]==0)
				count++;
		}
		return count;
	}
	public static int free_seat(int count)
	{
		int n=0;
		
		for(int i=0;i<sz;i++)
		{
			if(chk[i]==0)
			{
				if(n++==count)
					return i;
			}
		}
		return -1;
	}
	public CustomListAdapter(Context c)
	{
		con=c;
		for(int i=0;i<sz;i++)
			chk[i]=1;
		inf=(LayoutInflater)con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return sz;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}
	
	public String settv(int pos)
	{
		for(int i=0;i<Main_Chart.sz && i<sz;i++)
		{
			if(Main_Chart.ps[i].seat_no==(pos+1))
			{
				a[pos]=i;
				return (pos+1)+" : "+Main_Chart.ps[i].Name;
				
			}
		}
		a[pos]=-1;
		return (pos+1)+" : No Name";
	}

	@Override
	public View getView(final int pos, View arg1, ViewGroup arg2) {
		
		
		TextView t1;
		CheckBox ch;
		View vw;
		vw=inf.inflate(R.layout.customlist, null);
		
		ch=(CheckBox)vw.findViewById(R.id.seat_radio);
		t1=(TextView)vw.findViewById(R.id.seatno_tv);
		t1.setText(settv(pos));
		
		ch.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				chk[pos]=(chk[pos]+1)%2;
			}
		});
		
		vw.setOnClickListener(new OnClickListener() {	
			@Override
			public void onClick(View arg0) {
				
				Main_Chart.index=a[pos];
				Main_Chart.flag=false;
				
			}
		});
		
		return vw;
	}

}
