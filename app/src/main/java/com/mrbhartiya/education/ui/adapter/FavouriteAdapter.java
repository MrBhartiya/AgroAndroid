package com.mrbhartiya.education.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.mrbhartiya.education.R;
import com.mrbhartiya.education.model.HomeModel;
import com.mrbhartiya.education.utility.PreferenceHelper;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class FavouriteAdapter extends RecyclerView.Adapter<FavouriteAdapter.MyViewHolder> {

    private onFavouriteClick onItemClick;

    private List<HomeModel.DataBean.FavouriteVideosBean> favouriteList = new ArrayList<>();

    public FavouriteAdapter(List<HomeModel.DataBean.FavouriteVideosBean> favourite, onFavouriteClick homeActivity) {
        this.favouriteList = favourite;
        this.onItemClick = homeActivity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.teacher_item_view, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        //holder.mSubjectText.setText(favouriteList.get(position).get());
        String path;
        if(favouriteList.get(position).getVideo()!=null){
            path=PreferenceHelper.getBucketUrl()+favouriteList.get(position).getVideo().getThumbnail();

        }
        else{
            path=PreferenceHelper.getBucketUrl();

        }
        Picasso.get().load(path).fit().into(holder.mSubjectImage);
        holder.linear_subject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick.onFavouriteItemClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return favouriteList.size();
    }

    public interface onFavouriteClick {
        public void onFavouriteItemClick(int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mSubjectText;
        public LinearLayout linear_subject;
        private ImageView mSubjectImage;
        View mView;

        public MyViewHolder(View view) {
            super(view);
            mView = view;
            mSubjectImage = view.findViewById(R.id.teacher_image);
            linear_subject = view.findViewById(R.id.linear_item);
        }
    }
}