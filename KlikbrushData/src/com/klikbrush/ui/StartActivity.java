package com.klikbrush.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.klikbrushdata.R;

public class StartActivity extends Activity {
	
	private Button btn_start;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		
		btn_start = (Button) findViewById(R.id.btn_start);
		btn_start.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent startActivityIntent = new Intent(StartActivity.this, BrushingActivity.class);
				startActivity(startActivityIntent);
				
			}
			
		});
	}

}
