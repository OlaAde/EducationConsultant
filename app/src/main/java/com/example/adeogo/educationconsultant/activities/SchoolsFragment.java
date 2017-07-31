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
        mListSchool.add(new School("KAZAN STATE MEDICAL UNIVERSITY", "Kazan State Medical University is located in the city of Kazan, Tatarstan, Russia. It is the capital and the largest city in the territory of the Republic of Tatarstan with a population of 1,143,535 people.Kazan lies at the confluence of the Volga and Kazanka Rivers in European Russia.\n" +
                "\n" +
                "Kazan State Medical University or KSMU is a multi-functional and multi-leveled state institution of higher learning in medicine. It meets both personal and social needs in acquiring education in medicine, in developing bio-medical and clinical sciences, as well as broadening scientific knowledge of medical sciences. KSMU functions on the basis of self-governance and belongs to the system of Higher Education and Scientific Research of the Ministry of Health of Russia. The highest body or KSMU self-governance is academic with university's regulations. On March 6, 1994, the university was issued with a license number 16 G – 235 by the State Committee of Russian Federation of Higher Education which grants the right to perform activities in the field of professional education. Under the auspices of Kazan State Medical University there work a pharmaceutical and two medical colleges in Kazan, one medical college Mary EI Republic, lycee and bio-medical classes on the secondary school basis. This complex educational system in the frame work of the university provides the continuous higher education of medicine. Kazan State Medical University carries on an aimed preparation of experts in different fields of medicine for 10 republics, Povolzhie and Ural regions. According to the results of a rating of medical schools, KSMU takes the 16 place among 86 other universities. (The Gourman Report A rating of graduate and Professional programs in American and International Universities, Fifth Edition. Revised Dr. Jack Gourman Nation Educational Standards. 1989)",0 ));
        mListSchool.add(new School("KAZAN STATE MEDICAL UNIVERSITY", "Kazan State Medical University is located in the city of Kazan, Tatarstan, Russia. It is the capital and the largest city in the territory of the Republic of Tatarstan with a population of 1,143,535 people.Kazan lies at the confluence of the Volga and Kazanka Rivers in European Russia.\n" +
                "\n" +
                "Kazan State Medical University or KSMU is a multi-functional and multi-leveled state institution of higher learning in medicine. It meets both personal and social needs in acquiring education in medicine, in developing bio-medical and clinical sciences, as well as broadening scientific knowledge of medical sciences. KSMU functions on the basis of self-governance and belongs to the system of Higher Education and Scientific Research of the Ministry of Health of Russia. The highest body or KSMU self-governance is academic with university's regulations. On March 6, 1994, the university was issued with a license number 16 G – 235 by the State Committee of Russian Federation of Higher Education which grants the right to perform activities in the field of professional education. Under the auspices of Kazan State Medical University there work a pharmaceutical and two medical colleges in Kazan, one medical college Mary EI Republic, lycee and bio-medical classes on the secondary school basis. This complex educational system in the frame work of the university provides the continuous higher education of medicine. Kazan State Medical University carries on an aimed preparation of experts in different fields of medicine for 10 republics, Povolzhie and Ural regions. According to the results of a rating of medical schools, KSMU takes the 16 place among 86 other universities. (The Gourman Report A rating of graduate and Professional programs in American and International Universities, Fifth Edition. Revised Dr. Jack Gourman Nation Educational Standards. 1989)",0 ));
    }
}
