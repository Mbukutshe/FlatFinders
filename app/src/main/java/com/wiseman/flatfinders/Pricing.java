package com.wiseman.flatfinders;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

/**
 * Created by Wiseman on 2017-09-04.
 */

public class Pricing extends Fragment{
    View myView;
    ScrollView scrollView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myView = inflater.inflate(R.layout.pricing_layout,container,false);
        // Inflate the layout for this fragment
        scrollView = (ScrollView)myView.findViewById(R.id.asked_questions_background);
        scrollView.getBackground().setAlpha(190);
        return myView;
    }
}
