package com.example.myambariapp.fragment;

import com.example.myambariapp.R;
import com.example.myambariapp.R.layout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A dummy fragment representing a section of the app, but that simply
 * displays dummy text.
 */
public class MyHomeFragment extends Fragment {
	/**
	 * The fragment argument representing the section number for this
	 * fragment.
	 */
	public static final String ARG_SECTION_NUMBER = "section_number";

	public MyHomeFragment() {
	}
	
	public static MyHomeFragment newInstance(int sectionNumber){
		MyHomeFragment fragment = new MyHomeFragment();
		Bundle args = new Bundle();
		args.putInt(ARG_SECTION_NUMBER, sectionNumber + 1);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.activity_home, container, false);
		return rootView;
	}
}