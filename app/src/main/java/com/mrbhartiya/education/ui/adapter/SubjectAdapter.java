package com.mrbhartiya.education.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.mrbhartiya.education.R;
import com.mrbhartiya.education.model.HomeModel;
import com.mrbhartiya.education.utility.PreferenceHelper;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.MyViewHolder> {

    private onSubjectClick onItemClick;

    List<HomeModel.DataBean.SubjectListBean> subjectList = new ArrayList<>();

    public SubjectAdapter(List<HomeModel.DataBean.SubjectListBean> subject, onSubjectClick homeActivity) {
        this.subjectList = subject;
        this.onItemClick = homeActivity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.subject_item_view, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.mSubjectText.setText(subjectList.get(position).getSubject_name());
        String path=PreferenceHelper.getBucketUrl() +subjectList.get(position).getIcons();
        Picasso.get().load(path).into(holder.mSubjectImage);
        holder.linear_subject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick.onSubjectItemClick(position);
            }
        });

    }

    public interface onSubjectClick {
        public void onSubjectItemClick(int position);
    }

    @Override
    public int getItemCount() {
        return subjectList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mSubjectText;
        public LinearLayout linear_subject;
        private CircleImageView mSubjectImage;
        View mView;

        public MyViewHolder(View view) {
            super(view);
            mView = view;
            mSubjectImage = view.findViewById(R.id.subject_image);
            mSubjectText = view.findViewById(R.id.subject_name);
            linear_subject = view.findViewById(R.id.linear_subject);
        }
    }
}