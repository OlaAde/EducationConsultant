package com.example.adeogo.educationconsultant.activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.adeogo.educationconsultant.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private Button mButton;
    private String mSchoolName;
    private String mCourse;
    private Spinner mSchoolsSpinner;
    private Spinner mCoursesSpinner;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        mSchoolsSpinner = rootView.findViewById(R.id.schools_spinner);
        mCoursesSpinner = rootView.findViewById(R.id.courses_spinner);
        ArrayAdapter<CharSequence> schoolsAdapter = ArrayAdapter.createFromResource(getContext(),
                R.array.schools_array, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> coursesAdapter = ArrayAdapter.createFromResource(getContext(),
                R.array.courses_array, android.R.layout.simple_spinner_item);
        coursesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        schoolsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSchoolsSpinner.setAdapter(schoolsAdapter);
        mCoursesSpinner.setAdapter(coursesAdapter);
        mButton = (Button) rootView.findViewById(R.id.button_apply_now);

        mCoursesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object item = parent.getItemAtPosition(position);
                String Text = item.toString();
                mSchoolName = Text;
                Toast.makeText(getContext(), Text, Toast.LENGTH_SHORT).show();
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        mSchoolsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object item = parent.getItemAtPosition(position);
                String Text = item.toString();
                mCourse = Text;
                Toast.makeText(getContext(), Text, Toast.LENGTH_SHORT).show();
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), OrderSummaryActivity.class);
                if(TextUtils.equals(mSchoolName, null) || TextUtils.equals(mSchoolName, "None") || TextUtils.equals(mCourse, null) || TextUtils.equals(mCourse, "None"))
                {
                    Toast.makeText(getContext(), "Pick an appropriate Course or University!!!", Toast.LENGTH_SHORT).show();
                    return;
                }
                intent.putExtra("schoolName", mSchoolName);
                intent.putExtra("course", mCourse);
                startActivity(intent);
            }
        });

        // Inflate the layout for this fragment
        return rootView;
    }


}
