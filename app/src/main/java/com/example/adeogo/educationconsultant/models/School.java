package com.example.adeogo.educationconsultant.models;

/**
 * Created by Adeogo on 7/25/2017.
 */

public class School {

    private String mSchoolName;
    private String mAboutSchool;
    private int mSchoolImage;

    public void School(String SchoolName, String AboutSchool, int SchoolImage){
        mSchoolName = SchoolName;
        mAboutSchool = AboutSchool;
        mSchoolImage = SchoolImage;
    }

    public String getSchoolName(){
        return mSchoolName;
    }

    public String getAboutSchool(){
        return mAboutSchool;
    }

    public int getSchoolImage(){
        return mSchoolImage;
    }
}
