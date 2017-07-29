package com.example.adeogo.educationconsultant.activities;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.adeogo.educationconsultant.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        Spinner schoolsSpinner = rootView.findViewById(R.id.schools_spinner);
        Spinner coursesSpinner = rootView.findViewById(R.id.courses_spinner);
        ArrayAdapter<CharSequence> schoolsAdapter = ArrayAdapter.createFromResource(getContext(),
                R.array.schools_array, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> coursesAdapter = ArrayAdapter.createFromResource(getContext(),
                R.array.courses_array, android.R.layout.simple_spinner_item);
        coursesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        schoolsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        schoolsSpinner.setAdapter(schoolsAdapter);
        coursesSpinner.setAdapter(coursesAdapter);
        // Inflate the layout for this fragment
        return rootView;
    }

}
