package com.example.ecsa;

import java.util.ArrayList;
import com.example.slidingmenu.adapter.NavDrawerListAdapter;
import com.example.slidingmenu.model.NavDrawerItem;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends Activity {
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;
	private CharSequence mDrawerTitle;
	private CharSequence mTitle;
	private String[] navMenuTitles;
	private TypedArray navMenuIcons;
	private ArrayList<NavDrawerItem> navDrawerItems;
	private NavDrawerListAdapter adapter;
	
@SuppressWarnings("deprecation")
@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);
	
	SharedPreferences getPrefs= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
	boolean night= getPrefs.getBoolean("nmode", true);
	if(night==true)
	{
	AlertDialog alert = new AlertDialog.Builder(MainActivity.this).create();
	alert.setTitle("Welcome");
	alert.setMessage("Swipe the screen from left to access the menu. Go to Settings-> Show Welcome Box to disable this.");
	alert.setButton("Click to continue", new DialogInterface.OnClickListener() {
		
		@Override
		public void onClick(DialogInterface dialog, int y) {
			// TODO Auto-generated method stub
			 
		}
	});
	alert.show();
	}
mTitle = mDrawerTitle = getTitle();

navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);
navMenuIcons = getResources().obtainTypedArray(R.array.nav_drawer_icons);
mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
mDrawerList = (ListView) findViewById(R.id.list_slidermenu);
navDrawerItems = new ArrayList<NavDrawerItem>();

mDrawerList.setOnItemClickListener(new SlideMenuClickListener());


navDrawerItems.add(new NavDrawerItem(navMenuTitles[0], navMenuIcons.getResourceId(0, -1)));

navDrawerItems.add(new NavDrawerItem(navMenuTitles[1], navMenuIcons.getResourceId(1, -1)));

navDrawerItems.add(new NavDrawerItem(navMenuTitles[2], navMenuIcons.getResourceId(2, -1)));

navDrawerItems.add(new NavDrawerItem(navMenuTitles[3], navMenuIcons.getResourceId(3, -1)));

navDrawerItems.add(new NavDrawerItem(navMenuTitles[4], navMenuIcons.getResourceId(4, -1)));

navDrawerItems.add(new NavDrawerItem(navMenuTitles[5], navMenuIcons.getResourceId(5, -1)));

	navMenuIcons.recycle();

	adapter = new NavDrawerListAdapter(getApplicationContext(),
	navDrawerItems);
	mDrawerList.setAdapter(adapter);

	getActionBar().setDisplayHomeAsUpEnabled(true);
	getActionBar().setHomeButtonEnabled(true);
	mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,R.drawable.ic_drawer,R.string.app_name,R.string.app_name){
	public void onDrawerClosed(View view) {
		getActionBar().setTitle(mTitle);
		invalidateOptionsMenu();
		}
		public void onDrawerOpened(View drawerView) {
		getActionBar().setTitle(mDrawerTitle);
		invalidateOptionsMenu();
		}
	};
	mDrawerLayout.setDrawerListener(mDrawerToggle);
	if (savedInstanceState == null) {
	displayView(0);
	}
}

private class SlideMenuClickListener implements ListView.OnItemClickListener{

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// TODO Auto-generated method stub
		displayView(position);
	}
	
}
private void displayView(int position) {
	// TODO Auto-generated method stub
	Fragment fragment = null;
	switch (position) {
		case 0:
		fragment = new About_ECSA();
		break;
		case 1:
		fragment = new In_Sem_Marks();
		break;
		case 2:
		fragment = new Whats_New();
		break;
		case 3:
		fragment = new Upcoming_Events();
		break;
		case 4:
		fragment = new Forum();
		break;
		case 5:
		fragment = new About_CodeLabs();
		break;
		default:
		break;
	}
	if (fragment != null) {
	FragmentManager fragmentManager = getFragmentManager();
	fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).addToBackStack(null).commit();
	// update selected item and title, then close the drawer
	mDrawerList.setItemChecked(position, true);
	mDrawerList.setSelection(position);
	setTitle(navMenuTitles[position]);
	mDrawerLayout.closeDrawer(mDrawerList);
	} else {
	Log.e("MainActivity", "Error in creating fragment");
	}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    if (mDrawerToggle.onOptionsItemSelected(item)) {
		return true;
		}
		switch (item.getItemId()) {
		case R.id.action_settings:
			Intent in=new Intent("com.example.newapp1.PREFS");
			startActivity(in);
			break;
		case R.id.exit:
	           finish();
			break;
		}return false;
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
		menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
		return super.onPrepareOptionsMenu(menu);
	}

	@Override
		public void setTitle(CharSequence title) {
		mTitle = title;
		getActionBar().setTitle(mTitle);
	}
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();
	}
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}
	 
}
