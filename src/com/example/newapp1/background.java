package com.example.ecsa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class background extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.background);
	    Thread timer = new Thread(){
	    	public void run(){
	               try{
	            	   sleep(3000);
	    	     } catch(InterruptedException e){
	    	    	e.printStackTrace(); 
	    	     } finally{
	    	       Intent openMainActivity= new Intent("com.example.newapp1.MAINACTIVITY");	 
	    	       startActivity(openMainActivity);
	    	     }
	    	     }
	    		
	    };
	    timer.start();
	    
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
	
	}
