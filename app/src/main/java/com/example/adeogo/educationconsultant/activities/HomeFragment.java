package com.example.adeogo.educationconsultant.activities;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

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

        coursesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object item = parent.getItemAtPosition(position);
                String Text = item.toString();
                Toast.makeText(getContext(), Text, Toast.LENGTH_SHORT).show();

            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        // Inflate the layout for this fragment
        return rootView;
    }

}
