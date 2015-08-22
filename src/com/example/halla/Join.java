package com.example.halla;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Join extends Activity implements OnClickListener {
	private DBManager dbm;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.join);
	    // TODO Auto-generated method stub
	    /**뒤로가기*/
	    ImageButton helpback = (ImageButton)findViewById(R.id.backBtn);
        helpback.setOnClickListener(new OnClickListener() {
        	public void onClick(View v ) {
        		finish();
        	}
        });
        
        
        /*완료 버튼*/
        Button join = (Button)findViewById(R.id.completeBtn);
        join.setOnClickListener(this);
	}
	
	public void onClick(View v){
		//중복확인 버튼
		if(v.getId()==R.id.idcheckBtn){
			//db연동 후 중복확인 기능 삽입
			/*
			if(){
				AlertDialog.Builder alertDlg = new AlertDialog.Builder(this);
			    alertDlg.setMessage("이미 있는 아이디 입니다.");
			    alertDlg.setPositiveButton("확인", new DialogInterface.OnClickListener() { 
			     @Override
			    public void onClick(DialogInterface dialog, int whichButton) {
			    	 dialog.cancel(); 
			     }
			    
			      });
			      AlertDialog alert = alertDlg.create();
			      alert.setTitle("");
			    //  alert.setIcon(R.drawable.ic_launcher); // 이미지삽입
			      alert.show();
			}else{
				AlertDialog.Builder alertDlg = new AlertDialog.Builder(this);
			    alertDlg.setMessage("사용할 수 있는 아이디 입니다.");
			    alertDlg.setPositiveButton("확인", new DialogInterface.OnClickListener() { 
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
			*/
		}
		
		//가입하기 버튼
		if(v.getId()==R.id.completeBtn){
		
			//작성한 내용 추출
			EditText nameET=(EditText)findViewById(R.id.nameT);
			EditText idET=(EditText)findViewById(R.id.idT);
			EditText pwET=(EditText)findViewById(R.id.pwT);
//			EditText pwcheckET=(EditText)findViewById(R.id.pwcheckT);
			
			RadioGroup divisionG=(RadioGroup)findViewById(R.id.divisionG);
			String division="";
			if(divisionG.getCheckedRadioButtonId()==R.id.parentBtn){
				division="부모";
			}
			if(divisionG.getCheckedRadioButtonId()==R.id.childBtn){
				division="아이";
			}
			
			if(nameET.getText().toString().equals("") | idET.getText().toString().equals("") 
					| pwET.getText().toString().equals("") /* | pwcheckET.getText().toString().equals("") 
					*/| divisionG.equals("false")) {
//				Toast.makeText(getApplicationContext(), "모두 입력해 주세요!", Toast.LENGTH_SHORT).show();
				AlertDialog.Builder alertDlg = new AlertDialog.Builder(this);
			    alertDlg.setMessage("정보를 모두 입력해 주세요.");
			    alertDlg.setPositiveButton("확인", new DialogInterface.OnClickListener() { 
			     @Override
			    public void onClick(DialogInterface dialog, int whichButton) {
			    	 dialog.cancel(); 
			     }
			      });
			      AlertDialog alert = alertDlg.create();
			      alert.setTitle("");
			      alert.show();  
			}/*else if(!(pwET.getText().toString()==pwcheckET.getText().toString())){
				AlertDialog.Builder alertDlg = new AlertDialog.Builder(this);
			    alertDlg.setMessage("비밀번호를 다시 확인해 주세요.");
			    alertDlg.setPositiveButton("확인", new DialogInterface.OnClickListener() { 
			     @Override
			    public void onClick(DialogInterface dialog, int whichButton) {
			    	 dialog.cancel(); 
			     }
			      });
			      AlertDialog alert = alertDlg.create();
			      alert.setTitle("");
			      alert.show();
			}*/ else if(pwET.getEditableText().length()<3){
				Toast.makeText(getApplicationContext(), "비밀번호를 3자리이상 입력해 주세요!", Toast.LENGTH_SHORT).show();
				
			}else{
			
				//db연결
				try{
					dbm = new DBManager(this);
					SQLiteDatabase sdb;
					sdb = dbm.getWritableDatabase();
					//members테이블에 추출정보 추가
					sdb.execSQL("insert into customers values('" + nameET + "'," + idET + "','" + pwET + "','" + division + "');");
					dbm.close();
				}catch(SQLiteException e){
				}
				
				Intent it = new Intent(this,Login.class);
				startActivity(it);
				finish();
				}
		}
	}

}
