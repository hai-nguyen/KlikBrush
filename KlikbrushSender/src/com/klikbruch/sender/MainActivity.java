package com.klikbruch.sender;

import java.io.File;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends Activity {

	private SensorManager mSensorManager;
	private TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

		findViewById(R.id.btn_start).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				registerListeners();
			}
		});

		findViewById(R.id.btn_stop).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			}
		});

		tv = ((TextView) findViewById(R.id.txt_debug));

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void registerListeners() {
		mSensorManager.registerListener(
				new SensorEventListener() {
					
					
					private static final int sampleSize = 128;
					double[] realNumbers, imagNumbers;
					int count = 0;
					
					File output = new File(Environment.getExternalStorageDirectory(),"output.csv"); 

					private long lastUpdate;

					@Override
					public void onSensorChanged(SensorEvent event) {
						
						if (System.currentTimeMillis() - lastUpdate > 50) {
							
							if(count==0){
								realNumbers = new double[sampleSize];
								imagNumbers = new double[sampleSize];
							}
							
							realNumbers[count] = event.values[0];
							imagNumbers[count] = 0d;
							count++;
							
							if(count==sampleSize){ 
								System.out
										.println("MainActivity.registerListeners().new SensorEventListener() {...}.onSensorChanged()");
								new FFT(sampleSize).fft(realNumbers, imagNumbers);
								Util.addDoublesToFiles(realNumbers, imagNumbers, output);
								count = 0;
							}
							
//							lastUpdate = System.currentTimeMillis();
//							tv.setText(Float.toString(event.values[0])
//									+ "\n"
//									+ Float.toString(event.values[1])
//									+ "\n"
//									+ Float.toString(event.values[2]));
							
						}
					}

					@Override
					public void onAccuracyChanged(Sensor sensor, int accuracy) {
						// TODO Auto-generated method stub

					}
				}, mSensorManager
						.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
				SensorManager.SENSOR_DELAY_NORMAL);
		
//		mSensorManager.registerListener(
//				new SensorEventListener() {
//
//					private long lastUpdate;
//
//					@Override
//					public void onSensorChanged(SensorEvent event) {
//						if (System.currentTimeMillis() - lastUpdate > 100) {
//						}
//					}
//
//					@Override
//					public void onAccuracyChanged(Sensor sensor, int accuracy) {
//						// TODO Auto-generated method stub
//
//					}
//				}, mSensorManager
//						.getDefaultSensor(Sensor.TYPE_ORIENTATION),
//				SensorManager.SENSOR_DELAY_GAME);
	}
}
