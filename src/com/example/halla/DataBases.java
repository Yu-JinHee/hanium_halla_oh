package com.example.halla;

import android.os.Bundle;
import android.provider.BaseColumns;

public class DataBases  {
	public static final class CreateDB implements BaseColumns{ 
		
		public static final String NAME="Name";
		public static final String PW = "Answer2";
		public static final String QNAME="Qname";
		public static final String DIVISION = "Answer2";
		public static final String ANSWER1 = "Answer1";
		public static final String ANSWER2 = "Answer2";
		public static final String ANSWER3 = "Answer3";
	
		public static final String _CREATEListT="create table "+"_ListT"+"("
				+_ID+" integer primarykey autoincrement, "
				+NAME+" text not null, "
				+PW+"integer not null"
				+DIVISION+"text not null";

/*		public static final String _CREATEHangleT="create table "+"_HangleT"+"("
											+_ID+" integer primarykey autoincrement, "
											+QNAME+" text not null, "
											+ANSWER1+"text"
											+ANSWER2+"text"
											+ANSWER3+"text);";
*/	
/*	public static final String _CREATEColorT="create table "+"ColorT"+"("
			+_ID+" integer primarykey autoincrement, "
			+QNAME+" text not null, "
			+ANSWER1+"text"
			+ANSWER2+"text"
			+ANSWER3+"text);";
	public static String _CREATE;
	public static String _TABLENAME;
*/}
}
