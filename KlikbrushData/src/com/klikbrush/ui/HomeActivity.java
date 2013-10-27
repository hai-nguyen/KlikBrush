package com.klikbrush.ui;

import com.example.klikbrushdata.R;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;

public class HomeActivity extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		setUpActionBar();
	}
	
	private void setUpActionBar(){
		ActionBar actionBar = getActionBar();
		actionBar.setTitle("Brush"); 
		// more stuff here...
		actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.header));
		actionBar.show(); 
		
		
	}

}
