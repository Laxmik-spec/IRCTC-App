package com.example.irctcchart;

import android.provider.BaseColumns;

public class TableData {

	public TableData()
	{
		
	}
	
	public static abstract class TableInfo implements BaseColumns
	{
	
		public static final String NAME="name";
		public static final String ADDRESS="address";
		public static final String CONTACT="contact";
		public static final String GENDER="gender";
		public static final String EMAIL_ID="emailid";
		public static final String PASSWORD="password";		
		public static final String DATABASE_NAME="IRCTCChart.db";
		public static final String TABLE_NAME="register";
		
	}
	
	
}
