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
import com.mrbhartiya.education.model.SearchModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyViewHolder> {

    private List<SearchModel.DataBean> topicBean = new ArrayList<>();
    private SearchAdapter.onItemClick onItemClick;

    public SearchAdapter(List<SearchModel.DataBean> topicBean, SearchAdapter.onItemClick homeActivity) {
        this.topicBean = topicBean;
        this.onItemClick = homeActivity;

    }

    @NonNull
    @Override
    public SearchAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.vertical_list_item, parent, false);
        return new SearchAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.MyViewHolder holder, final int position) {
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

    public void updateList(List<SearchModel.DataBean> topicList) {
        this.topicBean = topicList;
        notifyDataSetChanged();
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