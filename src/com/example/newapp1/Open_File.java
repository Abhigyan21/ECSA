package com.example.ecsa;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Open_File extends Fragment {
TextView tv;
View rootView;
public Open_File(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

		rootView = inflater.inflate(R.layout.openfile, container, false);
        
        TextView tv=(TextView) rootView.findViewById(R.id.display);
		tv.setText(readText());
		return rootView;
      }

	private String readText() {
		// TODO Auto-generated method stub
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