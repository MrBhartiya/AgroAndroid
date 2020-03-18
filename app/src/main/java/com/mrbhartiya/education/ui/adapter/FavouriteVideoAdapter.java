package com.mrbhartiya.education.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mrbhartiya.education.R;
import com.mrbhartiya.education.model.HomeModel;
import com.mrbhartiya.education.utility.PreferenceHelper;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FavouriteVideoAdapter extends RecyclerView.Adapter<FavouriteVideoAdapter.MyViewHolder> {

    private ArrayList<HomeModel.DataBean.FavouriteVideosBean> chapterList = new ArrayList<>();
    private FavouriteVideoAdapter.onItemClick onItemClick;
    private FavouriteVideoAdapter.onItemDelete onItemDelete;

    public FavouriteVideoAdapter(ArrayList<HomeModel.DataBean.FavouriteVideosBean> chapterList, onItemClick homeActivity, onItemDelete activity) {
        this.chapterList = chapterList;
        this.onItemClick = homeActivity;
        this.onItemDelete = activity;

    }

    @NonNull
    @Override
    public FavouriteVideoAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_fav_list, parent, false);
        return new FavouriteVideoAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FavouriteVideoAdapter.MyViewHolder holder, final int position) {
        if(chapterList.get(position).getVideo()!=null){
            holder.mItemName.setText(chapterList.get(position).getVideo().getTitle());
            holder.mItemDesc.setText(chapterList.get(position).getVideo().getVideo_description());
        }
        else{
            holder.mItemName.setText("");
            holder.mItemDesc.setText("");
        }
        Picasso.get().load(PreferenceHelper.getBucketUrl()+chapterList.get(position).getVideo().getThumbnail()).placeholder(R.drawable.recent_video_thumbnail).into(holder.mItemImage);

        holder.mItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClick.onItemClickListener(position);
            }
        });
        holder.mDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemDelete.onItemDeleteListener(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return chapterList.size();
    }

    public interface onItemClick {
        public void onItemClickListener(int position);

    }

    public interface onItemDelete {
        public void onItemDeleteListener(int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mItemName, mItemDesc;
        View mView;
        private ImageView mItemImage;
        private LinearLayout mItemView;
        private ImageView mDelete;

        public MyViewHolder(View view) {
            super(view);
            mView = view;
            mItemImage = view.findViewById(R.id.item_image);
            mItemName = view.findViewById(R.id.item_name);
            mItemDesc = view.findViewById(R.id.item_name_detail);
            mItemView = view.findViewById(R.id.item_view);
            mDelete = view.findViewById(R.id.img_delete);
        }
    }
}


