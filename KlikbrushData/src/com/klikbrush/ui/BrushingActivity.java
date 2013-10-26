package com.klikbrush.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

import com.example.klikbrushdata.R;

public class BrushingActivity extends FragmentActivity {
	
	TextView txtCounter, txtFrequency, txtStroke;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_brushing);
	}
	
	private void InitUI(){
		txtCounter = (TextView) findViewById(R.id.txt_counter);
		txtFrequency = (TextView) findViewById(R.id.txt_frequency);
		txtStroke = (TextView) findViewById(R.id.txt_strokelength);
	}
	
	
}
