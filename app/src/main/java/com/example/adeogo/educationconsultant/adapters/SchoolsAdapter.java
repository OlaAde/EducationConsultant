package com.example.adeogo.educationconsultant.adapters;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adeogo.educationconsultant.R;
import com.example.adeogo.educationconsultant.models.School;

import java.util.List;
import java.util.Random;

/**
 * Created by Adeogo on 7/30/2017.
 */

public class SchoolsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context mContext;
    private List<School> mschoolList = null;

    private final SchoolsAdapterOnclickHandler mClickHandler;


    public interface SchoolsAdapterOnclickHandler{
        void voidMethod(List<School> schoolList, int adapterPosition);
    }

    public SchoolsAdapter( Context context,SchoolsAdapterOnclickHandler schoolsAdapterOnclickHandler){
        mContext = context;
        mClickHandler = schoolsAdapterOnclickHandler;
    }


    public class SchoolsAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public final TextView mSchoolNameTextView;
        public final ImageView mSchoolImageView;

        public SchoolsAdapterViewHolder(View itemView) {
            super(itemView);
            mSchoolNameTextView = (TextView) itemView.findViewById(R.id.school_name_tv);
            mSchoolImageView = (ImageView) itemView.findViewById(R.id.school_iv);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int adapterPosition = getAdapterPosition();

            mClickHandler.voidMethod(mschoolList, adapterPosition);
        }
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view  = layoutInflater.inflate(R.layout.list_item_school, parent, false);
        return new SchoolsAdapterViewHolder(view);
    }




    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        String schoolName = null;
        int schoolPicture = 0;
        String basePicasso = "http://image.tmdb.org/t/p/w185/";
        if(mschoolList != null){
            School school = mschoolList.get(position);
            schoolName = school.getSchoolName();
            schoolPicture = R.drawable.image_schools;
        }

        ((SchoolsAdapterViewHolder) holder).mSchoolNameTextView.setText(schoolName);
        ((SchoolsAdapterViewHolder) holder).mSchoolImageView.setImageResource(R.drawable.image_schools);
    }


    @Override
    public int getItemCount() {
        if(null == mschoolList){
            return 0;
        }
        return mschoolList.size();
    }


    public List<School> swapData(List<School> schoolList) {
        // check if this cursor is the same as the previous cursor (mCursor)
        if (schoolList == mschoolList) {
            return null; // bc nothing has changed
        }
        List<School> temp = mschoolList;
        this.mschoolList = schoolList; // new cursor value assigned

        //check if this is a valid cursor, then update the cursor
        if (schoolList != null) {
            this.notifyDataSetChanged();
        }
        return temp;
    }
}
