package com.example.ecsa;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class Forum extends Fragment {
WebView brow;
	public Forum(){}

		@Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {

	        View rootView = inflater.inflate(R.layout.forum, container, false);
	        brow = (WebView) rootView.findViewById(R.id.webView1);
	        brow.loadUrl("http://ecsa.editboard.com");
	        brow.getSettings().getJavaScriptEnabled();
	        brow.getSettings().getUseWideViewPort();
	        return rootView;
	        
	       
	    }
		
	}

	

