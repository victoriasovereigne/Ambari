package com.example.myambariapp;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * Kelas utama ketika app dijalankan
 * 
 * @author V Anugrah
 *
 */
public class LoginActivity extends Activity {
	ActionBar actionBar; // action bar
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState); 
		actionBar = getActionBar(); // mengambil action bar (hanya ada di API 14)
		actionBar.hide(); // action bar tidak ditampilkan
		setContentView(R.layout.activity_login); // mengambil activity_login.xml untuk ditampilkan ke app
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	/**
	 * Method untuk onClick button login
	 * @param view
	 */
	public void redirectHome(View view){
		// Membuat Intent yang redirect ke MainActivity
		Intent intent = new Intent(this, MyActivity.class);
	    startActivity(intent);
	}
	
	public void redirectMy(View view){
		// Membuat Intent yang redirect ke MainActivity
		Intent intent = new Intent(this, MainActivity.class);
	    startActivity(intent);
	}
}