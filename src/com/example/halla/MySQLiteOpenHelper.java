package com.example.halla;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteOpenHelper {

	private static final String DATABASE_NAME = "halla.db";
	private static final int DATABASE_VERSION = 1;
	public static SQLiteDatabase mDB;
	private DatabaseHelper mDBHelper;
	private Context mCtx;

	private class DatabaseHelper extends SQLiteOpenHelper{

		// 생성자
		public DatabaseHelper(Context context, String name,
				CursorFactory factory, int version) {
			super(context, name, factory, version);
		}

		// 최초 DB를 만들때 한번만 호출된다.
		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(DataBases.CreateDB._CREATEListT);
//			db.execSQL(DataBases.CreateDB._CREATEHangleT);
//			db.execSQL(DataBases.CreateDB._CREATEColorT);
		}

		// 버전이 업데이트 되었을 경우 DB를 다시 만들어 준다.
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			db.execSQL("DROP TABLE IF EXISTS "+DataBases.CreateDB._CREATEListT);
//			db.execSQL("DROP TABLE IF EXISTS "+DataBases.CreateDB._CREATEHangleT);
//			db.execSQL("DROP TABLE IF EXISTS "+DataBases.CreateDB._CREATEColorT);
			onCreate(db);
		}
	}



	public void MySQLiteOpenHelper (Context context){
		this.mCtx = context;
	}

	public MySQLiteOpenHelper open() throws SQLException{
		mDBHelper = new DatabaseHelper(mCtx, DATABASE_NAME, null, DATABASE_VERSION);
		mDB = mDBHelper.getWritableDatabase();
		return this;
	}

	public void close(){
		mDB.close();
	}

	// Insert DB
	public long insertColumnListT(String name, int pw, String division){
		ContentValues values = new ContentValues();
		values.put(DataBases.CreateDB.NAME, name);
		values.put(DataBases.CreateDB.PW, pw);
		values.put(DataBases.CreateDB.DIVISION, division);
		return mDB.insert(DataBases.CreateDB._CREATEListT, null, values);
		
	}
/*	public long insertColumnHangleT(String Qname, String answer1, String answer2, String answer3){
		ContentValues values = new ContentValues();
		values.put(DataBases.CreateDB.QNAME, Qname);
		values.put(DataBases.CreateDB.ANSWER1, answer1);
		values.put(DataBases.CreateDB.ANSWER2, answer2);
		values.put(DataBases.CreateDB.ANSWER3, answer3);
		return mDB.insert(DataBases.CreateDB._CREATEHangleT, null, values);
	}*/
/*
	public long insertColumnColorT(String Qname, String answer1, String answer2, String answer3){
		ContentValues values = new ContentValues();
		values.put(DataBases.CreateDB.QNAME, Qname);
		values.put(DataBases.CreateDB.ANSWER1, answer1);
		values.put(DataBases.CreateDB.ANSWER2, answer2);
		values.put(DataBases.CreateDB.ANSWER3, answer3);
		return mDB.insert(DataBases.CreateDB._CREATEColorT, null, values);
	}
	
	// Update DB
	public boolean updateColumn(long id , String Qname, String answer1, String answer2, String answer3){
		ContentValues values = new ContentValues();
		values.put(DataBases.CreateDB.NAME, name);
		values.put(DataBases.CreateDB.ANSWER1, answer1);
		values.put(DataBases.CreateDB.ANSWER2, answer2);
		values.put(DataBases.CreateDB.ANSWER3, answer3);
		return mDB.update(DataBases.CreateDB._TABLENAME, values, "_id="+id, null) > 0;
	}

	// Delete ID
	public boolean deleteColumn(long id){
		return mDB.delete(DataBases.CreateDB._TABLENAME, "_id="+id, null) > 0;
	}
	
	// Delete Contact
	public boolean deleteColumn(String number){
		return mDB.delete(DataBases.CreateDB._TABLENAME, "contact="+number, null) > 0;
	}
*/	
	// Select All
	public Cursor getListALLColumns(){
		return mDB.query(DataBases.CreateDB._CREATEListT, null, null, null, null, null, null);
		
	}
/*	public Cursor getHangleAllColumns(){
		return mDB.query(DataBases.CreateDB._CREATEHangleT, null, null, null, null, null, null);
	}*/
/*	public Cursor getColorAllColumns(){
		return mDB.query(DataBases.CreateDB._CREATEColorT, null, null, null, null, null, null);
	}
*/

	// ID 컬럼 얻어 오기
	public Cursor getListColumn(long id){
		Cursor c = mDB.query(DataBases.CreateDB._CREATEListT, null,
				"_id="+id, null, null, null, null);
		if(c != null && c.getCount() != 0)
			c.moveToFirst();
		return c;
	}
/*	public Cursor getHangleColumn(long id){
		Cursor c = mDB.query(DataBases.CreateDB._CREATEHangleT, null, 
				"_id="+id, null, null, null, null);
		if(c != null && c.getCount() != 0)
			c.moveToFirst();
		return c;
	}*/
/*
	public Cursor getColorColumn(long id){
		Cursor c = mDB.query(DataBases.CreateDB._CREATEColorT, null, 
				"_id="+id, null, null, null, null);
		if(c != null && c.getCount() != 0)
			c.moveToFirst();
		return c;
	}
*/
	// 이름 검색 하기 (rawQuery)
	public Cursor getMatchName(String name){
		Cursor c = mDB.rawQuery( "select * from address where name=" + "'" + name + "'" , null);
		return c;
	}


}









/**일단 빼*/
	/*
	 public class MySQLiteOpenHelper extends SQLiteOpenHelper{
	
	static String NAME = "halla.db";
	static CursorFactory FACTORY = null;
	static String PACKEGE = "com.example.halla";
	static String DB = "halla.db";
	static int VERSION  = 1;
	
	public MySQLiteOpenHelper(Context context) {
			super(context, NAME, FACTORY, VERSION);
		
	}
	*/
	// DB가 있나 체크하기
	/*public boolean isCheckDB(Context mContext){
		String filePath = "/data/data/" + PACKEGE + "/databases/" + DB;
		File file = new File(filePath);
	 
		if (file.exists()) {
			return true;
		}
		 
		return false;
		 
		}
	// DB를 복사하기
	// assets의 /db/xxxx.db 파일을 설치된 프로그램의 내부 DB공간으로 복사하기
	public void copyDB(Context mContext){
		
		AssetManager manager = mContext.getAssets(); //assets의 파일 통제
		String folderPath = "/data/data/" + PACKEGE + "/databases";
		String filePath = "/data/data/" + PACKEGE + "/databases/" +DB;
		File folder = new File(folderPath);
		File file = new File(filePath);
		 
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		try {
			InputStream is = manager.open("db/" + DB);
			BufferedInputStream bis = new BufferedInputStream(is);
		 
		if (folder.exists()) {
			}else{
				folder.mkdirs();
			}
		 
		 
		if (file.exists()) {
			file.delete();
			file.createNewFile();
		}
		 
		fos = new FileOutputStream(file);
		bos = new BufferedOutputStream(fos);
		int read = -1;
		byte[] buffer = new byte[1024];
		while ((read = bis.read(buffer, 0, 1024)) != -1) {
			bos.write(buffer, 0, read);
		}
		 
		bos.flush();
		 
		bos.close();
		fos.close();
		bis.close();
		is.close();
		 
		} catch (IOException e) {
			Log.e("ErrorMessage : ", e.getMessage());
			} 
	}
	/** Called when the activity is first created. */
	/*@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated constructor stub
				try {
					boolean bResult = isCheckDB(context);  // DB가 있는지?
					if(!bResult){   // DB가 없으면 복사
						copyDB(context);
					}else{
					}
				} catch (Exception e) {
					 
					}
	}
	 
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		 
		}
}
	*/