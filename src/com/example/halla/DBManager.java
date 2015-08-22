package com.example.halla;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBManager extends SQLiteOpenHelper {

	public DBManager(Context ct) {
		super(ct, "myDB", null, 1);
		// TODO Auto-generated constructor stub
	}


	/** Called when the activity is first created. */
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table customers (name TEXT NOT NULL, id INTEGER PRIMARY KEY, pw INTEGER NOT NULL, division TEXT NOT NULL);");
	}


	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
		
	}

}
