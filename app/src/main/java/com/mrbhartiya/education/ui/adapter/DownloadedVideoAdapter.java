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
import com.mrbhartiya.education.model.DownloadedVideoModel;

import java.util.ArrayList;
import java.util.List;

public class DownloadedVideoAdapter extends RecyclerView.Adapter<DownloadedVideoAdapter.MyViewHolder> {

    private List<DownloadedVideoModel> chapterList = new ArrayList<>();
    private DownloadedVideoAdapter.onItemClick onItemClick;

    public DownloadedVideoAdapter(List<DownloadedVideoModel> chapterList, DownloadedVideoAdapter.onItemClick homeActivity) {
        this.chapterList = chapterList;
        this.onItemClick = homeActivity;

    }

    @NonNull
    @Override
    public DownloadedVideoAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_fav_list, parent, false);
        return new DownloadedVideoAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DownloadedVideoAdapter.MyViewHolder holder, final int position) {
        holder.mItemName.setText(chapterList.get(position).getFileName());
        // holder.mItemDesc.setText(chapterList.get(position).getDescription());
        holder.img_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClick.onItemClickListener(position);
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

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mItemName, mItemDesc;
        View mView;
        private ImageView mItemImage, img_delete;
        private LinearLayout mItemView;

        public MyViewHolder(View view) {
            super(view);
            mView = view;
            mItemImage = view.findViewById(R.id.item_image);
            mItemName = view.findViewById(R.id.item_name);
            mItemDesc = view.findViewById(R.id.item_name_detail);
            mItemView = view.findViewById(R.id.item_view);
            img_delete = view.findViewById(R.id.img_delete);
        }
    }
}


