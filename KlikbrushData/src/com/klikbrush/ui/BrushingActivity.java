package com.klikbrush.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.klikbrushdata.R;

public class BrushingActivity extends BTActivity {

	TextView txtCounter;
	ProgressBar prgPhase;
	int passedSenconds = 0;
	ImageView txtFrequency, txtStroke, img_toothPhase;
	SeekBar sbFrequency, sbMagnitude, sbCircle;

	double currentState = 0;

	@Override
	protected void processMessage(String message) {
		//Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

		String[] params = message.split(",");


		int outputState = Integer.parseInt(params[0]);
		double frequencyX = Double.parseDouble(params[1]);
		double frequencyY = Double.parseDouble(params[2]);
		double frequencyZ = Double.parseDouble(params[3]);
		//0-10

		double magnitudeX = Double.parseDouble(params[4]);
		double magnitudeY = Double.parseDouble(params[5]);
		double magnitudeZ = Double.parseDouble(params[6]);
		//0-1000
		
		double circleXY = Double.parseDouble(params[7]);
		double circleYZ = Double.parseDouble(params[8]);
		double circleZX = Double.parseDouble(params[9]);
		
		
		Log.i("info", "frequencyX " + frequencyX);
		Log.i("info", "frequencyY " + frequencyY);
		Log.i("info", "frequencyZ " + frequencyZ);
		if(outputState==1){
			img_toothPhase.setBackgroundResource(R.drawable.main_teeth_front);
			sbFrequency.setProgress((int) frequencyX * 10);
			sbMagnitude.setProgress((int) magnitudeX);
			sbCircle.setProgress((int) circleXY * 10);
		}
		else if(outputState==2){
			img_toothPhase.setBackgroundResource(R.drawable.main_teeth_top);
			sbFrequency.setProgress((int) frequencyZ*10);
			sbMagnitude.setProgress((int) magnitudeZ);
			sbCircle.setProgress((int) circleYZ*10);

		}
		
		//img_toothPhase.refreshDrawableState();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_brushing);

		initUI(); // get all views

		Thread t = new Thread() {

			@Override
			public void run() {
				try {
					while (!isInterrupted()) {
						Thread.sleep(1000);
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								updateUICounter();
							}
						});
					}
				} catch (InterruptedException e) {
				}
			}
		};

		t.start();

	}

	private void initUI() {
		Typeface tf = Typeface.createFromAsset(getAssets(),
		        "fonts/lato.ttf");
		txtCounter = (TextView) findViewById(R.id.txt_counter);
		txtCounter.setTypeface(tf);
		txtFrequency = (ImageView) findViewById(R.id.txt_frequency);
		txtStroke = (ImageView) findViewById(R.id.txt_strokelength);
		prgPhase = (ProgressBar) findViewById(R.id.progress_phase);
		prgPhase.setMax(30);
		prgPhase.setProgress(0);
		
		img_toothPhase = (ImageView) findViewById(R.id.img_toothPhase);
		sbFrequency = (SeekBar) findViewById(R.id.slider);
		sbMagnitude = (SeekBar) findViewById(R.id.slider2);
		sbCircle = (SeekBar) findViewById(R.id.slider3);

	}

	private void updateUICounter() {
		passedSenconds++;
		int seconds = passedSenconds % 60;
		int minutes = (passedSenconds / 60) % 60;
		txtCounter.setText(String.format("%02d : %02d", minutes, seconds));

		if (seconds <= 30) {
			prgPhase.setProgress(seconds);
		} else {
			prgPhase.setProgress(seconds - 30);
		}

	}
	
	@Override
	  public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main, menu);
	    return true;
	  } 
	
	@Override
	  public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    case R.id.action_box:
	      Intent launchActivity = new Intent(this, ResultActivity.class);
	      startActivity(launchActivity);
	      break;
	

	    default:
	      break;
	    }

	    return true;
	  } 

}
