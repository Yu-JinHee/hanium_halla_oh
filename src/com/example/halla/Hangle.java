package com.example.halla;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

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
	    Button helpback = (Button)findViewById(R.id.backBtn);
        helpback.setOnClickListener(new OnClickListener() {
        	public void onClick(View v ) {
        		finish();
        	}
        });
        
        /**이미지 삽입*/
        // drawable 리소스에서 naverlogo 파일 호출 하여 Drawable에 등록
        Drawable drawable = getResources().getDrawable(R.drawable.pencil);
        // id : imageView01 <ImageView>를 가져온다.
        // imageView01 에 리소스에서 가져온 naverlogo 등록
        ImageView imageView = (ImageView)findViewById(R.id.imageView1);
        imageView.setImageDrawable(drawable);
      
        /**정답확인 버튼*/
        Button btn1 = (Button)findViewById(R.id.button1);
        btn1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				//다음그림 뿌려주기
				int index = (int)(Math.random()*6);
				int res = array[index];
				ImageView imageView = (ImageView)findViewById(R.id.imageView1);
		        imageView.setImageResource(res); 
			}
		});
      
	}

}

