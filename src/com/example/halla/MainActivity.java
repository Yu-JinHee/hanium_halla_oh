package com.example.halla;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	   /**종료**/
		@Override
		public boolean  onKeyDown(int keyCode, KeyEvent event)
		  {
		   if(keyCode == KeyEvent.KEYCODE_BACK)
		   {
		    AlertDialog.Builder alertDlg = new AlertDialog.Builder(this);
		      
		    alertDlg.setMessage("종료하시겠습니까?");
		    alertDlg.setPositiveButton("종료", new DialogInterface.OnClickListener() { 
		     @Override
		    public void onClick(DialogInterface dialog, int whichButton) {
		     System.exit(0);
		     }
		      }) ;        
		      alertDlg.setNegativeButton("취소", new DialogInterface.OnClickListener() { 
		       @Override
		    public void onClick(DialogInterface dialog, int whichButton) {         
		        dialog.cancel();   
		       }
		      });
		      AlertDialog alert = alertDlg.create();
		      alert.setTitle("");
		    //  alert.setIcon(R.drawable.ic_launcher); // 이미지삽입
		      alert.show();
		   }
		   return false;
		  }
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		/**버튼 클릭시 페이지 이동*/
		/*로그아웃 버튼*/
	    Button logout = (Button)findViewById(R.id.logoutBtn);
        logout.setOnClickListener(new OnClickListener() {
        	public void onClick(View v ) {
        		Intent intent = new Intent(MainActivity.this, Login.class);
        		startActivity(intent);
        	}
        });
		/*메뉴*/
		Button btn1 = (Button)findViewById(R.id.startBtn);
		
        btn1.setOnClickListener(new OnClickListener() {
        	public void onClick(View v ) {
        		Intent intent = new Intent(MainActivity.this, Start.class);
        		startActivity(intent);
        	}
        });
        Button btn2 = (Button)findViewById(R.id.checkBtn);
        btn2.setOnClickListener(new OnClickListener() {
        	public void onClick(View v ) {
        		Intent intent = new Intent(MainActivity.this, Check.class);
        		startActivity(intent);
        	}
        });
        Button btn3 = (Button)findViewById(R.id.alarmBtn);
        btn3.setOnClickListener(new OnClickListener() {
        	public void onClick(View v ) {
        		Intent intent = new Intent(MainActivity.this, Alarm.class);
        		startActivity(intent);
        	}
        });
        
	}
}
