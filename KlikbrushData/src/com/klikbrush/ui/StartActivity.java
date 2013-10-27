package com.klikbrush.ui;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.klikbrushdata.R;

public class StartActivity extends Activity {
	
	private ImageButton btn_start;
	private TextView txtName;
	private ImageView imgMark;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		setUpActionBar();
		btn_start = (ImageButton) findViewById(R.id.btn_start);
		btn_start.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent startActivityIntent = new Intent(StartActivity.this, BrushingActivity.class);
				startActivity(startActivityIntent);
				
			}
			
		});
		
		Typeface tf = Typeface.createFromAsset(getAssets(),
		        "fonts/lato.ttf");
		txtName = (TextView) findViewById(R.id.myTextViewMark);
		txtName.setTypeface(tf);
		
		
		imgMark = (ImageView) findViewById(R.id.iv1);
		imgMark.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent startActivityIntent = new Intent(StartActivity.this, HomeActivity.class);
				startActivity(startActivityIntent);
			}
			
		});
	}
	
	private void setUpActionBar(){
		ActionBar actionBar = getActionBar();
		actionBar.setTitle("Brush"); 
		// more stuff here...
		actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.header));
		actionBar.show(); 
	}

}
