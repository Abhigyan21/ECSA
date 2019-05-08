package com.example.ecsa;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class About_ECSA extends Fragment {
	TextView tv;
	Button  b1,b2,b3,b4;;
	     public About_ECSA(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.about_ecsa, container, false);
        b1 = (Button) rootView.findViewById(R.id.adept);
        b2 = (Button) rootView.findViewById(R.id.facl);
        b3 = (Button) rootView.findViewById(R.id.stuc);
        b4 = (Button) rootView.findViewById(R.id.resp);
        tv = (TextView) rootView.findViewById(R.id.display);
        
        
        b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v){
				Intent i = new Intent (android.content.Intent.ACTION_VIEW);
				i.setData(Uri.parse(("http://www.ecsa.in/department/")));
				startActivity(i);
			}
			}
		);

		b2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Fragment fr =null;
				switch(v.getId()){
				case R.id.facl:
					fr = new Open_File();
					break;
				}
				if(fr !=null){
					FragmentManager fm = getFragmentManager();
					fm.beginTransaction().replace(R.id.frame_container, fr).addToBackStack(null).commit();
				}
				  }
			
			});
			
			
	 b3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Fragment fr =null;
				switch(v.getId()){
				case R.id.stuc:
					fr = new Open_File1();
					break;
				}
				if(fr !=null){
					FragmentManager fm = getFragmentManager();
					fm.beginTransaction().replace(R.id.frame_container, fr).addToBackStack(null).commit();
				}
			}
		});
	 b4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent (android.content.Intent.ACTION_VIEW);
				i.setData(Uri.parse(("http://www.ecsa.in/projects/")));
				startActivity(i);
			
			}
		});
	 
       return rootView;
   
    }
        public String readText(){
	 		InputStream is=getResources().openRawResource(R.raw.facultylist);
	 		ByteArrayOutputStream ba=new ByteArrayOutputStream();
	 		int i;
	 		try{
	 			i=is.read();
	 		while(i!=-1){
	 		ba.write(i);
	 		i=is.read();
	 		}is.close();
	 		}catch(IOException e){
	 			e.printStackTrace();
	 		}
	 		return ba.toString();
	 		
	 	
	 	
	}
}
