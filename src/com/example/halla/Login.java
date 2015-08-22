package com.example.halla;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends Activity {

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
	
	
	/**텍스트 받기위한 변수생성*/
	EditText et_id;
    EditText et_pw;
    TextView tv_msg;
    
    
   
    private static String id = "";
    private static String pw = "";
    private static String msgString = null;
    private static boolean isConnected = false;
    private MyAlertDialog alert = null;
    
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.login);
	    
	    /**텍스트 받아오기*/
	    et_id = (EditText) findViewById(R.id.id_et);
        et_pw = (EditText) findViewById(R.id.pw_et);
	    alert = new MyAlertDialog(this);
        
	    /**버튼기능*/
        /*로그인버튼*/
	    Button login = (Button)findViewById(R.id.loginBtn);
        login.setOnClickListener(new OnClickListener() {
        	public void onClick(View v ) {
        		Intent intent = new Intent(Login.this, MainActivity.class);
        		startActivity(intent);
        		
        		//db연동후 아이디 비밀번호 비교 후 if->페이지이동 else->오류창
        		Toast.makeText(getApplicationContext(), "로그인 되었습니다!", Toast.LENGTH_SHORT).show();
        		
        	}
        });
        /*가입버튼*/
	    Button join = (Button)findViewById(R.id.joinBtn);
        join.setOnClickListener(new OnClickListener() {
        	public void onClick(View v ) {
        		Intent intent = new Intent(Login.this, Join.class);
        		startActivity(intent);
        	}
        });
	}
	class MyAlertDialog extends AlertDialog.Builder{

		public MyAlertDialog(Context arg0) {
			super(arg0);
			// TODO Auto-generated constructor stub
		}
		
	}
}


