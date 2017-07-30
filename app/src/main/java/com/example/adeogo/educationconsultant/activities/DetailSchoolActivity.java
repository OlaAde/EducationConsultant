package com.example.adeogo.educationconsultant.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.adeogo.educationconsultant.R;

public class DetailSchoolActivity extends AppCompatActivity {

    private String mSchoolName;
    private String mSchoolDescription;
    private TextView mSchoolNameTextView;
    private TextView mSchoolDescpTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_school);
        Intent intent = getIntent();
        mSchoolName = intent.getStringExtra("school_name");
        mSchoolDescription = intent.getStringExtra("school_description");
        mSchoolDescpTextView = (TextView) findViewById(R.id.detail_school_descrip_tv);
        mSchoolNameTextView = (TextView) findViewById(R.id.detail_school_name_tv);
        mSchoolNameTextView.setText(mSchoolName);
        mSchoolDescpTextView.setText(mSchoolDescription);
    }
}
