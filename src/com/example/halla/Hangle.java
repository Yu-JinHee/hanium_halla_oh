package com.example.halla;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Hangle extends Activity {
	int index = (int)(Math.random()*6);
	
	int res = array[index];
	 public static final int[] array= {
	  R.drawable.apple, R.drawable.pencil, R.drawable.turtle,
	  R.drawable.whale, R.drawable.ic_launcher,R.drawable.strawberry};
	 
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.hangle);
	    // TODO Auto-generated method stub
	    /**뒤로가기*/
	    ImageButton helpback = (ImageButton)findViewById(R.id.backBtn);
        helpback.setOnClickListener(new OnClickListener() {
        	public void onClick(View v ) {
        		finish();
        	}
        });
        
        /**DB연동하기*/
        MySQLiteOpenHelper DBHelper = new MySQLiteOpenHelper(this);
        SQLiteDatabase db = DBHelper.getWritableDatabase();
        db = SQLiteDatabase.openDatabase("data/data/com.example.halla/databases/halla.db", null, SQLiteDatabase.OPEN_READONLY);
 /*   
        Cursor cursor;
//디비연동이 잘 됬는지 확인하고 쿼리문 맞는지 체크(쿼리는아마 맞을듯?)
       cursor = db.rawQuery("SELECT Q_name FROM hangleT Order by random() limit 1" , null);
       cursor.getString(1);
//db에서 가져온 값 이미지뷰에 넣는 소스 추가하자
       // ImageView imageView2 = (ImageView)findViewById(R.id.imageView1);
 
  //      Drawable drawable1 = getResources().getAssets().open(cursor);//open()안에 파일명이 들어가야할텐데.. 
  //      imageView2.setImageDrawable(drawable1);
        cursor.close();
        
//db와 관련된 단어 버튼 뿌리기
  		ImageButton btn1 = (ImageButton)findViewById(R.id.ImageButton01);
  		ImageButton btn2 = (ImageButton)findViewById(R.id.ImageButton02);
  		ImageButton btn3 = (ImageButton)findViewById(R.id.ImageButton03);
  		ImageButton btn4 = (ImageButton)findViewById(R.id.ImageButton04);
  		ImageButton btn5 = (ImageButton)findViewById(R.id.ImageButton05);
  		ImageButton btn6 = (ImageButton)findViewById(R.id.ImageButton06);
  		ImageButton btn7 = (ImageButton)findViewById(R.id.ImageButton07);
  		ImageButton btn8 = (ImageButton)findViewById(R.id.ImageButton08);
  		ImageButton btn9 = (ImageButton)findViewById(R.id.ImageButton09);
   */   
        
//----------------------------------------------------------------------------------------
        /**문제 이미지 삽입(db와 관련X)*/
        // drawable 리소스에서 naverlogo 파일 호출 하여 Drawable에 등록
        Drawable drawable = getResources().getDrawable(R.drawable.pencil);
        // id : imageView01 <ImageView>를 가져온다.
        // imageView01 에 리소스에서 가져온 naverlogo 등록
        ImageView imageView1 = (ImageView)findViewById(R.id.imageView1);
        imageView1.setImageDrawable(drawable);
      
        /**다음 문제 및 정답확인 버튼기능 추가*/
        ImageButton btn1 = (ImageButton)findViewById(R.id.button1);
        btn1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				//다음 문제 랜덤으로 뿌려주기
				int index = (int)(Math.random()*6);
				int res = array[index];
				ImageView imageView = (ImageView)findViewById(R.id.imageView1);
		        imageView.setImageResource(res); 
			}
		});
      
	}

}
