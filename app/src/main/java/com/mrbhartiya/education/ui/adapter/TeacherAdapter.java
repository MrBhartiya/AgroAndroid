package com.mrbhartiya.education.ui.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.mrbhartiya.education.R;
import com.mrbhartiya.education.model.HomeModel;
import com.mrbhartiya.education.ui.activity.HomeActivity;
import com.mrbhartiya.education.utility.PreferenceHelper;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.MyViewHolder> {

    //private List<Movie> moviesList;

    onSubjectClick onItemClick;

    List<HomeModel.DataBean.TeacherListBean> teacherList = new ArrayList<>();

    public TeacherAdapter(List<HomeModel.DataBean.TeacherListBean> teacherList, HomeActivity homeActivity) {
        this.teacherList = teacherList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.teacher_item_view, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.mteacherDesc.setText(teacherList.get(position).getDescription());
        holder.mteacherSubject.setText(teacherList.get(position).getTeacher_subject());
        Picasso.get().load(PreferenceHelper.getBucketUrl()+teacherList.get(position).getTeacher_image()).into(holder.mteacherImage);


    }

    @Override
    public int getItemCount() {
        Log.e("teacherList", String.valueOf(teacherList.size()));
        return teacherList.size();
    }

    public interface onSubjectClick {
        public void onSubjectItemnClick(int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mteacherSubject, mteacherDesc;
        public LinearLayout linear_subject;
        View mView;
        private ImageView mteacherImage;

        public MyViewHolder(View view) {
            super(view);
            mView = view;
            mteacherImage = view.findViewById(R.id.teacher_image);
            mteacherSubject = view.findViewById(R.id.teacher_subject);
            mteacherDesc = view.findViewById(R.id.teacher_desc);
            linear_subject = (LinearLayout) view.findViewById(R.id.linear_subject);
        }
    }
}