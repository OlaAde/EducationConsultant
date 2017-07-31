package com.example.adeogo.educationconsultant.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.example.adeogo.educationconsultant.R;

import org.w3c.dom.Text;

public class OrderSummaryActivity extends AppCompatActivity {

    private String mSchoolName;
    private String mCourse;
    private String mFirstName;
    private String mSecondName;
    private String mEmail;
    private String mAboutMe;
    private static String mEmailDestination = "oladipo@gmail.com";

    private TextInputEditText mFirstNameEditText;
    private TextInputEditText mSecondNameEditText;
    private TextView mCourseTextView;
    private TextView mSchoolNameTextView;
    private TextInputEditText mEmailEditText;
    private EditText mAboutMeEditText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mFirstNameEditText = (TextInputEditText) findViewById(R.id.first_name_etv);
        mSecondNameEditText = (TextInputEditText) findViewById(R.id.second_name_etv);
        mEmailEditText = (TextInputEditText) findViewById(R.id.email_etv);
        mAboutMeEditText = (EditText) findViewById(R.id.about_yourself_etv);

        mCourseTextView = (TextView) findViewById(R.id.course_name_tv);
        mSchoolNameTextView = (TextView) findViewById(R.id.school_name_tv);

        Intent intent = getIntent();
        mSchoolName = intent.getStringExtra("schoolName");
        mCourse = intent.getStringExtra("course");
        if(!TextUtils.equals("None", mSchoolName))
            mSchoolNameTextView.setText("School: " + mSchoolName);

        if(!TextUtils.equals("None", mCourse))
            mCourseTextView.setText("Course: " + mCourse);
    }

    private void ExtractData(){
        mFirstName = mFirstNameEditText.getText().toString();
        mSecondName = mSecondNameEditText.getText().toString();
        mEmail = mEmailEditText.getText().toString();
        mAboutMe = mAboutMeEditText.getText().toString();
    }
    private void applyNow(){
        ExtractData();
        String emailMessage = "";

        emailMessage = "I " + mFirstName + mSecondName + " want a Scholarship" + "\n" + " This is my email: " + mEmail + "\n" + mAboutMe;
                Intent intent = new Intent(Intent.ACTION_SENDTO);
//        intent.setData(Uri.parse("mailto:")); // only email apps should handle this

        intent.setData(Uri.parse("mailto:" + mEmailDestination));
        intent.putExtra(Intent.EXTRA_SUBJECT,
                getString(R.string.order_summary_email_subject));
        intent.putExtra(Intent.EXTRA_TEXT, emailMessage);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.summary, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_apply) {
            applyNow();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
