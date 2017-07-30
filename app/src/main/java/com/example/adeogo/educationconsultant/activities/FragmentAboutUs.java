package com.example.adeogo.educationconsultant.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.adeogo.educationconsultant.R;

/**
 * Created by Adeogo on 7/30/2017.
 */

public class FragmentAboutUs extends Fragment {

    public FragmentAboutUs(){}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.about_us_fragment, container, false);

    return rootView;
    }
    }
