package com.example.halla;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Picture extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.picture);
	    // TODO Auto-generated method stub
	    
	    /**뒤로가기*/
	    Button helpback = (Button)findViewById(R.id.backBtn);
        helpback.setOnClickListener(new OnClickListener() {
        	public void onClick(View v ) {
        		finish();
        	}
        });
	}

}
