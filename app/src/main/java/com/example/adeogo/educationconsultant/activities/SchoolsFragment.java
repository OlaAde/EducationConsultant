package com.example.adeogo.educationconsultant.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.adeogo.educationconsultant.R;
import com.example.adeogo.educationconsultant.adapters.SchoolsAdapter;
import com.example.adeogo.educationconsultant.models.School;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adeogo on 7/30/2017.
 */

public class SchoolsFragment extends Fragment implements SchoolsAdapter.SchoolsAdapterOnclickHandler {

    private SchoolsAdapter mSchoolsAdapter;
    private List<School> mListSchool = null;
    private LinearLayoutManager mLayoutManager;
    private RecyclerView mRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_schools, container, false);
        mRecyclerView = rootView.findViewById(R.id.schools_rv);
        mSchoolsAdapter = new SchoolsAdapter(getContext(), this);
        setListSchool();
        mLayoutManager =  new LinearLayoutManager(getContext());
        mSchoolsAdapter.swapData(mListSchool);
        mRecyclerView.setAdapter(mSchoolsAdapter);
        mRecyclerView.setLayoutManager(mLayoutManager);
        return rootView;
    }

    @Override
    public void voidMethod(List<School> schoolList, int adapterPosition) {
        Intent intent = new Intent(getContext(), DetailSchoolActivity.class);
        intent.putExtra("school_name", mListSchool.get(adapterPosition).getSchoolName() );
        intent.putExtra("school_description", mListSchool.get(adapterPosition).getAboutSchool() );
        startActivity(intent);
    }

    private void setListSchool()
    {
        mListSchool = new ArrayList<School>();
        mListSchool.add(new School("KAZAN STATE MEDICAL UNIVERSITY", "Kazan State Medica.",0 ));
        mListSchool.add(new School("KAZAN STATE MEDICAL UNIVERSITY", "Kazan State Medica.",0 ));
    }
}
