package com.klikbrush.ui;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.klikbrushdata.R;

public class BrushingActivity extends BTActivity {

	TextView txtCounter, txtFrequency, txtStroke;
	ProgressBar prgPhase;
	int passedSenconds = 0;

	double currentState = 0;

	@Override
	protected void processMessage(String message) {
		// Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
		String[] params = message.split(",");

		int outputState = Integer.parseInt(params[0]);
		double frequencyX = Double.parseDouble(params[1]);
		double frequencyY = Double.parseDouble(params[2]);
		double frequencyZ = Double.parseDouble(params[3]);

		double magnitudeX = Double.parseDouble(params[4]);
		double magnitudeY = Double.parseDouble(params[5]);
		double magnitudeZ = Double.parseDouble(params[6]);
		
		double circleXY = Double.parseDouble(params[7]);
		double circleYZ = Double.parseDouble(params[8]);
		double circleZX = Double.parseDouble(params[9]);
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
		txtFrequency = (TextView) findViewById(R.id.txt_frequency);
		txtStroke = (TextView) findViewById(R.id.txt_strokelength);
		prgPhase = (ProgressBar) findViewById(R.id.progress_phase);
		prgPhase.setMax(30);
		prgPhase.setProgress(0);

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

}
