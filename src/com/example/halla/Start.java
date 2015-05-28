package com.example.halla;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Start extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.start);
	    // TODO Auto-generated method stub
	    
	    /**버튼 클릭시 페이지 이동*/
		Button btn1 = (Button)findViewById(R.id.hangleBtn);
		
        btn1.setOnClickListener(new OnClickListener() {
        	public void onClick(View v ) {
        		Intent intent = new Intent(Start.this, Hangle.class);
        		startActivity(intent);
        	}
        });
        Button btn2 = (Button)findViewById(R.id.numberBtn);
        btn2.setOnClickListener(new OnClickListener() {
        	public void onClick(View v ) {
        		Intent intent = new Intent(Start.this, Number.class);
        		startActivity(intent);
        	}
        });
        Button btn3 = (Button)findViewById(R.id.pictureBtn);
        btn3.setOnClickListener(new OnClickListener() {
        	public void onClick(View v ) {
        		Intent intent = new Intent(Start.this, Picture.class);
        		startActivity(intent);
        	}
        });
        /**뒤로가기*/
	    Button helpback = (Button)findViewById(R.id.backBtn);
        helpback.setOnClickListener(new OnClickListener() {
        	public void onClick(View v ) {
        		finish();
        	}
        });
	}

}
