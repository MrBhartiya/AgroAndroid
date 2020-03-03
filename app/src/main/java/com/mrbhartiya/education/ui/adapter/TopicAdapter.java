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
import com.mrbhartiya.education.model.TopicModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.MyViewHolder> {

    private List<TopicModel.DataBean> topicBean = new ArrayList<>();
    private onItemClick onItemClick;

    public TopicAdapter(List<TopicModel.DataBean> topicBean, onItemClick homeActivity) {
        this.topicBean = topicBean;
        this.onItemClick = homeActivity;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.vertical_list_item, parent, false);
        return new TopicAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.mItemName.setText(topicBean.get(position).getVideo_name());
        holder.mItemDesc.setText(topicBean.get(position).getDescription());
        Picasso.get().load(topicBean.get(position).getThumbnail()).into(holder.mItemImage);

        holder.mItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClick.onItemClickListener(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return topicBean.size();
    }

    public interface onItemClick {
        public void onItemClickListener(int position);
    }

    public void updateList(List<TopicModel.DataBean> topicList) {
        this.topicBean = topicList;
        notifyDataSetChanged();
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
