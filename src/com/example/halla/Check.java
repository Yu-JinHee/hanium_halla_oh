package com.example.halla;

import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class Check extends Activity {
	Calendar cal = java.util.Calendar.getInstance();//날짜가져오기
    int before=0;	//비교날짜
    int today = cal.get(cal.DATE);//오늘날짜
    int num=0;//stemp[]의 indext
    int coupon=0;//선물갯수
    
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.check);
	    // TODO Auto-generated method stub
	    /**뒤로가기*/
	    Button helpback = (Button)findViewById(R.id.backBtn);
        helpback.setOnClickListener(new OnClickListener() {
        	public void onClick(View v ) {
        		finish();
        	}
        });
        
        /**출석체크*/
        ImageView stemp[]= new ImageView[6];//개구리스티커 배열
        stemp[0] = (ImageView)findViewById(R.id.ImageView01);
        stemp[1] = (ImageView)findViewById(R.id.ImageView02);
        stemp[2] = (ImageView)findViewById(R.id.ImageView03);
        stemp[3] = (ImageView)findViewById(R.id.ImageView04);
        stemp[4] = (ImageView)findViewById(R.id.ImageView05);
 

        //어플실행 첫날은 바로 스템프1개 부여
        if(before == 0){
        	before=today;
        	stemp[0].setVisibility(stemp[0].VISIBLE);
        }
        
      //5일째 되는 날 스템프 다 보이도록
        if(num>=5&&before!=cal.get(cal.DATE)-1){
        	for(num=4;num>=0;num--){
        		stemp[num].setVisibility(stemp[num].INVISIBLE);
        	}
        }else{
        	num=0;
        }

        //연속출석
        if(before==cal.get(cal.DATE)-1){
    		before=today;
    		stemp[num].setVisibility(stemp[num].VISIBLE);
    		num++;
    	}else{
    		if(before==today){
    			//첫날일경우는 스킵
    		}else{//연속 출석을 못했을 경우
	        	for(num=4;num>=0;num--){
	        		stemp[num].setVisibility(stemp[num].INVISIBLE);
	        	}
	        	num=0;
        	}
        }
        
    	//5일 연속 출석일 경우 초기화 & 쿠폰1개 증가
        if(num>=5){
        	coupon += 1;
        	num+=1;
        }
        
	}   
}


