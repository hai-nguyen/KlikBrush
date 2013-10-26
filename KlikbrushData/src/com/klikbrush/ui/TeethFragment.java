package com.klikbrush.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.klikbrushdata.R;

public class TeethFragment extends Fragment {
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        // Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.fragment_teethstate, container, false);
		LinearLayout parent = ((LinearLayout) view.findViewById(R.id.ll_teeth_parent));
		
        return view;
    }

}
