package com.example.ecsa;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class Whats_New extends Fragment {
WebView brow;
	public Whats_New(){}
		
		@Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {

	        View rootView = inflater.inflate(R.layout.forum, container, false);
	        brow = (WebView) rootView.findViewById(R.id.webView1);
	        brow.loadUrl("http://ecsa.in/news-update/");
	        brow.getSettings().getJavaScriptEnabled();
	        brow.getSettings().getUseWideViewPort();
	        return rootView;
}
}
