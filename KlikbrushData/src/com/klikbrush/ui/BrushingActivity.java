package com.klikbrush.ui;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.FragmentActivity;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.klikbrushdata.R;

public class BrushingActivity extends FragmentActivity {
	
	TextView txtCounter, txtFrequency, txtStroke;
	ProgressBar prgPhase;
    int passedSenconds = 0;

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_brushing);
		
        initUI ();                         // get all views 
        
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
	
	private void initUI(){
		txtCounter = (TextView) findViewById(R.id.txt_counter);
		txtFrequency = (TextView) findViewById(R.id.txt_frequency);
		txtStroke = (TextView) findViewById(R.id.txt_strokelength);
		prgPhase = (ProgressBar) findViewById(R.id.progress_phase);
		prgPhase.setMax(30);
		prgPhase.setProgress(0);
	}
	
	private void updateUICounter(){    
	    passedSenconds++;
	    int seconds = passedSenconds % 60;
        int minutes = (passedSenconds / 60) % 60;
        txtCounter.setText(String.format("%02d : %02d", minutes, seconds));
        
        if(seconds <= 30){
        	prgPhase.setProgress(seconds);
        }else{
        	prgPhase.setProgress(seconds-30);
        }
        
	}
	


	 
	
	
}
