package com.mrbhartiya.education.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mrbhartiya.education.R;
import com.mrbhartiya.education.model.HomeModel;

import java.util.ArrayList;

public class DemoVideoAdapter extends RecyclerView.Adapter<DemoVideoAdapter.MyViewHolder> {

    private ArrayList<HomeModel.DataBean.DemoVideoListBean> chapterList = new ArrayList<>();
    private DemoVideoAdapter.onItemClick onItemClick;

    public DemoVideoAdapter(ArrayList<HomeModel.DataBean.DemoVideoListBean> chapterList, onItemClick homeActivity) {
        this.chapterList = chapterList;
        this.onItemClick = homeActivity;

    }

    @NonNull
    @Override
    public DemoVideoAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.vertical_list_item, parent, false);
        return new DemoVideoAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DemoVideoAdapter.MyViewHolder holder, final int position) {
        holder.mItemName.setText(chapterList.get(position).getVideo_name());
        holder.mItemDesc.setText(chapterList.get(position).getDescription());
        holder.mItemView.setOnClickListener(new View.OnClickListener() {
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
        private ImageView mItemImage;
        private RelativeLayout mItemView;

        public MyViewHolder(View view) {
            super(view);
            mView = view;
            mItemImage = view.findViewById(R.id.item_image);
            mItemName = view.findViewById(R.id.item_name);
            mItemDesc = view.findViewById(R.id.item_name_detail);
            mItemView = view.findViewById(R.id.item_view);
        }
    }
}

