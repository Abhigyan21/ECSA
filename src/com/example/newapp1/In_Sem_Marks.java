package com.example.ecsa;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class In_Sem_Marks extends Fragment {
Button b1,b2,b3,b4,b5,b6,b7;
View rootView;

	public In_Sem_Marks(){}

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.in_sem, container, false);
        b1= (Button) rootView.findViewById(R.id.sa);
        b2= (Button) rootView.findViewById(R.id.sb);
        b3= (Button) rootView.findViewById(R.id.sc);
        b4= (Button) rootView.findViewById(R.id.ta);
        b5= (Button) rootView.findViewById(R.id.tb);
        b6= (Button) rootView.findViewById(R.id.fa);
        b7= (Button) rootView.findViewById(R.id.fb);
        
 b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v){
				Intent i = new Intent (android.content.Intent.ACTION_VIEW);
				i.setData(Uri.parse(("https://www.dropbox.com/sh/fzkq88atrpqdz2x/ctUPUkoTIQ")));
				startActivity(i);
			}
			}
		);
 b2.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v){
			Intent i = new Intent (android.content.Intent.ACTION_VIEW);
			i.setData(Uri.parse(("https://www.dropbox.com/sh/34xi8h32ndp1mcn/vRoPQFf9hX")));
			startActivity(i);
		}
		}
	);
 b3.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v){
			Intent i = new Intent (android.content.Intent.ACTION_VIEW);
			i.setData(Uri.parse(("https://www.dropbox.com/sh/7w44bnxg7ksi7f5/lcO_HrSuW1")));
			startActivity(i);
			}
		}
	);
 b4.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v){
			Intent i = new Intent (android.content.Intent.ACTION_VIEW);
			i.setData(Uri.parse(("https://www.dropbox.com/sh/mle491lnbrioi0s/kIN4QdUhms")));
			startActivity(i);}
		}
	);
 b5.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v){
			Intent i = new Intent (android.content.Intent.ACTION_VIEW);
			i.setData(Uri.parse(("https://www.dropbox.com/sh/f7gju9bh2npqenu/aodn1wSn3q")));
			startActivity(i);}
		}
	);
 b6.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v){
			Intent i = new Intent (android.content.Intent.ACTION_VIEW);
			i.setData(Uri.parse(("https://www.dropbox.com/sh/hts44qv5ifm92pa/PL1ZM3_Dox")));
			startActivity(i);}
		}
	);
 b7.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v){
			Intent i = new Intent (android.content.Intent.ACTION_VIEW);
			i.setData(Uri.parse(("https://www.dropbox.com/sh/pmewzvh2jlrcqmv/G9CqMp0cUO")));
			startActivity(i);}
		}
	);
 
	
	return rootView;
	}
}
