package com.example.myambariapp;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.example.myambariapp.adapter.DrawerItemCustomAdapter;
import com.example.myambariapp.object.ObjectDrawerItem;

public class MyActivity extends FragmentActivity {

	private static final String TAG = MyActivity.class.getSimpleName();

	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;

	private CharSequence mDrawerTitle;
	private CharSequence mTitle;
	private String[] mDrawerItems;

	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my);

		mTitle = mDrawerTitle = getTitle();

		mDrawerItems = getResources().getStringArray(R.array.drawer_titles);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);
		
		ObjectDrawerItem[] drawerItem = new ObjectDrawerItem[4];
		 
		drawerItem[0] = new ObjectDrawerItem(R.drawable.icon_search, mDrawerItems[0]);
		drawerItem[1] = new ObjectDrawerItem(R.drawable.icon_search, mDrawerItems[1]);
		drawerItem[2] = new ObjectDrawerItem(R.drawable.icon_search, mDrawerItems[2]);
		drawerItem[3] = new ObjectDrawerItem(R.drawable.icon_search, mDrawerItems[3]);
		
		DrawerItemCustomAdapter adapter = new DrawerItemCustomAdapter(this, R.layout.listview_item_row, drawerItem);
		mDrawerList.setAdapter(adapter);

		// set a custom shadow that overlays the main content when the drawer
		// opens
		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);

		// Add items to the ListView
//		mDrawerList.setAdapter(new ArrayAdapter<String>(this,
//				R.layout.drawer_list_item, mDrawerItems));
		
		// Set the OnItemClickListener so something happens when a
		// user clicks on an item.
		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

		// Enable ActionBar app icon to behave as action to toggle nav drawer
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close) {
			public void onDrawerClosed(View view) {
				getActionBar().setTitle(mTitle);
				invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu
			}

			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle(mDrawerTitle);
				invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu
			}
		};

		mDrawerLayout.setDrawerListener(mDrawerToggle);

		// Set the default content area to home
		// when the app opens for the first time
		if (savedInstanceState == null) {
			getSupportFragmentManager()
			.beginTransaction()
			.replace(R.id.content_frame, TabbedFragment.newInstance(),
					"HOME").commit();
			setTitle("HOME");
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main_actions, menu);
		return super.onCreateOptionsMenu(menu);
	}

	/*
	 * If you do not have any menus, you still need this function in order to
	 * open or close the NavigationDrawer when the user clicking the ActionBar
	 * app icon.
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		int id = item.getItemId();
		if (id == R.id.action_search) {
			setTitle("Search");
		}
		return super.onOptionsItemSelected(item);
	}

	/*
	 * When using the ActionBarDrawerToggle, you must call it during
	 * onPostCreate() and onConfigurationChanged()
	 */

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

	private class DrawerItemClickListener implements OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			Log.v(TAG, "ponies");
			navigateTo(position);
		}
	}

	private void navigateTo(int position) {
		Log.v(TAG, "List View Item: " + position);

		switch (position) {
		case 0:
			/*
			 * getSupportFragmentManager() .beginTransaction()
			 * .add(R.id.content_frame, ItemOne.newInstance(),
			 * ItemOne.TAG).commit();
			 */
			Intent intent = new Intent(this, FullscreenActivity.class);
			startActivity(intent);
			break;
		case 1:
			intent = new Intent(this, RecommendedActivity.class);
			startActivity(intent);
			break;
			
		case 2:
			getSupportFragmentManager()
					.beginTransaction()
					.replace(R.id.content_frame, TabbedFragment.newInstance(),
							"TRANSACTIONS").commit();
			break;
			
		case 3:
			getSupportFragmentManager()
					.beginTransaction()
					.replace(R.id.content_frame, TabbedFragment.newInstance(),
							"OPTIONS").commit();
			break;
		}
	}

	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getActionBar().setTitle(mTitle);
//		setTitle(mDrawerItems[position]);
	}
}