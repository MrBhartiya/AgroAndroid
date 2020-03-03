package com.mrbhartiya.education.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mrbhartiya.education.R;
import com.mrbhartiya.education.model.SearchModel;
import com.mrbhartiya.education.ui.adapter.SearchAdapter;

import java.util.ArrayList;
import java.util.List;

public class SearchResultActivity extends BaseActivity implements SearchAdapter.onItemClick, View.OnClickListener {
    private RecyclerView mRecyclerView;
    private List<SearchModel.DataBean> mSearchData = new ArrayList<>();
    private SearchAdapter mSearchAdapter;
    private ImageView btnBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        getIntentData();
        Toolbar toolbar = findViewById(R.id.toolbar_signup);
        btnBack = toolbar.findViewById(R.id.toolbar_left_icon);
        btnBack.setOnClickListener(this);
        mSearchAdapter = new SearchAdapter(mSearchData, this);
        mRecyclerView = findViewById(R.id.search_result_recyclerview);
        LinearLayoutManager verticalLayoutManagaer = new LinearLayoutManager(SearchResultActivity.this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(verticalLayoutManagaer);
        mRecyclerView.setAdapter(mSearchAdapter);

    }

    @Override
    public void onClick(View view) {
        onBackPressed();

    }

    private void getIntentData() {
        Intent i = getIntent();
        if (i.hasExtra("search_result")) {
            mSearchData = (ArrayList<SearchModel.DataBean>) getIntent().getSerializableExtra("search_result");
        }

    }

    @Override
    public void onItemClickListener(int position) {
        Intent intent = new Intent(this, VideoDiscription.class);
        intent.putExtra("id", mSearchData.get(position).getChapter_id());
        intent.putExtra("url", mSearchData.get(position).getVideo_url());
        intent.putExtra("description", mSearchData.get(position).getDescription());
        intent.putExtra("likes", mSearchData.get(position).getVideo_like());
        intent.putExtra("thumbnail", mSearchData.get(position).getThumbnail());
        intent.putExtra("notes_url", mSearchData.get(position).getThumbnail());
        intent.putExtra("video_name", mSearchData.get(position).getVideo_name());
        intent.putExtra("video_id", mSearchData.get(position).getVideo_id());
        intent.putExtra("isLike", mSearchData.get(position).isIsLiked());
        intent.putExtra("isFavourited", mSearchData.get(position).isIsFavourited());
        startActivity(intent);
    }
}
