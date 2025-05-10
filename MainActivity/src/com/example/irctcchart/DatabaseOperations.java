package com.example.irctcchart;

import com.example.irctcchart.TableData.TableInfo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DatabaseOperations extends SQLiteOpenHelper {

	Context con;
	public static final int database_version = 1;
	public String CREATE_QUERY = "CREATE TABLE "+TableInfo.TABLE_NAME+"("+TableInfo.NAME+" TEXT,"+TableInfo.ADDRESS+" text,"+TableInfo.CONTACT+" TEXT,"+TableInfo.GENDER+" TEXT,"+TableInfo.EMAIL_ID+" TEXT,"+TableInfo.PASSWORD+" TEXT);";
	
	public DatabaseOperations(Context context) {
		
	  super(context, TableInfo.DATABASE_NAME, null, database_version);
	  con=context;
	  Log.d("Database operations","Database Created");
	}

	@Override
	public void onCreate(SQLiteDatabase sdb) {
	
		//sdb.execSQL(CREATE_QUERY);
		//Log.d("Database operations","Table Created");
		
		//sdb.delete(TableInfo.TABLE_NAME, null, null);
		//Log.d("Database operations","Table Deleted");
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
	
	public Cursor getChart(String tr_name,String co_name)
	{
		SQLiteDatabase db=this.getWritableDatabase();
		String[] cols={"Seat_No","Name","Age","Gender","Frm","Too","PNR_No","Ticket_No"};
		String sarg="Coach='"+co_name+"' and Train_Name='"+tr_name+"'";
		
		Cursor cursor=db.query("passenger", cols,sarg,null,null,null,null);
		
		return cursor;
	}
	
	public void putInformation(DatabaseOperations dop,String name,String address,String contact,String gender,String emailid,String password)
	{
		
		SQLiteDatabase SQ=dop.getWritableDatabase();
		ContentValues cv=new ContentValues();
		cv.put(TableInfo.NAME,name );
		cv.put(TableInfo.ADDRESS,address);
		cv.put(TableInfo.CONTACT,contact);
		cv.put(TableInfo.GENDER,gender);
		cv.put(TableInfo.EMAIL_ID, emailid);
		cv.put(TableInfo.PASSWORD,password);
		
		long k=SQ.insert(TableInfo.TABLE_NAME, null, cv);
		Log.d("Database operations","One row inserted");
	}
	
	public void insquery(String query)
	{
		SQLiteDatabase db=this.getWritableDatabase();
		db.execSQL(query);
		//Toast.makeText(con, "QRY:"+query, Toast.LENGTH_LONG).show();
		Log.d("Query:", query);
	}

	public Cursor getInformation(DatabaseOperations dop)
	{
		
		SQLiteDatabase SQ=dop.getReadableDatabase();
		String[] columns={TableInfo.EMAIL_ID,TableInfo.PASSWORD};
		Cursor CR=SQ.query(TableInfo.TABLE_NAME, columns, null, null, null, null, null);
		
		 if (CR != null) {
			   CR.moveToFirst();
			  }
		return CR;
		
	}
	public Cursor getWaiting(String tr_name,int limit)
	{
		SQLiteDatabase db=this.getWritableDatabase();
		String[] cols={"Seat_No","Name","Age","Gender","Frm","Too","PNR_No","Ticket_No"};
		String sarg="Train_Name='"+tr_name+"'";
		
		Cursor cursor=db.query(false, "waiting_list", cols, sarg, null, null, null, null, limit+"", null);
		
		return cursor;
	}
	
	
	
}
