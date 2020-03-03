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
import com.mrbhartiya.education.model.DownloadedVideoModel;

import java.util.ArrayList;
import java.util.List;

public class DownloadAdapter extends RecyclerView.Adapter<DownloadAdapter.MyViewHolder> {

    private onDownloadClick onItemClick;

    private List<DownloadedVideoModel> favouriteList = new ArrayList<>();

    public DownloadAdapter(List<DownloadedVideoModel> favourite, onDownloadClick homeActivity) {
        this.favouriteList = favourite;
        this.onItemClick = homeActivity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.download_video_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        //holder.mSubjectText.setText(favouriteList.get(position).get());
        // Picasso.get().load(favouriteList.get(position).getFileName()).into(holder.mSubjectImage);
        holder.linear_subject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick.onDownloadItemClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        Log.e("favouriteList", String.valueOf(favouriteList.size()));
        return favouriteList.size();
    }

    public interface onDownloadClick {
        public void onDownloadItemClick(int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mSubjectText;
        public LinearLayout linear_subject;
        View mView;
        private ImageView mSubjectImage;

        public MyViewHolder(View view) {
            super(view);
            mView = view;
            mSubjectImage = view.findViewById(R.id.teacher_image);
            linear_subject = view.findViewById(R.id.linear_item);
        }
    }
}