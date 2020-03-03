package com.mrbhartiya.education.ui.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mrbhartiya.education.R;
import com.mrbhartiya.education.api.ApiService;
import com.mrbhartiya.education.api.RetrofitClient;
import com.mrbhartiya.education.model.HomeModel;
import com.mrbhartiya.education.model.SearchModel;
import com.mrbhartiya.education.model.TopicModel;
import com.mrbhartiya.education.ui.adapter.TopicAdapter;
import com.mrbhartiya.education.utility.PreferenceHelper;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class TopicActivity extends BaseActivity implements View.OnClickListener, TopicAdapter.onItemClick {
    private String chapterName, color;
    private String chapterId;
    private RecyclerView mRecycleChapter;
    private ImageView btnBack;
    private HomeModel.DataBean.SubjectListBean data;
    private TextView mItemName, mTitle;
    private TopicAdapter mTopicAdapter;
    private List<TopicModel.DataBean> topicBean = new ArrayList<>();
    private TextView mtext;
    private LinearLayout mLinearlayout;
    private SearchView mSearchText;
    private List<SearchModel.DataBean> searchResult = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);
        getIntentData();
        initializeView();

    }

    private void getChapters() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Loading...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
        ApiService apiService = RetrofitClient.createRetrofitService(ApiService.class);
        Call<TopicModel> call = apiService.perfromVideoFetchOperation(chapterId);
        call.enqueue(new Callback<TopicModel>() {
            @Override
            public void onResponse(Call<TopicModel> call, retrofit2.Response<TopicModel> response) {
                progressDialog.dismiss();
                if (response.code() == 200) {
                    if (response.body().isStatus()) {
                        topicBean.clear();
                        for (int i = 0; i < response.body().getData().size(); i++)
                            topicBean.add(response.body().getData().get(i));
                        mRecycleChapter.setAdapter(mTopicAdapter);


                    } else {
                        Toast.makeText(TopicActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else
                    Toast.makeText(TopicActivity.this, "Something went wrong..", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<TopicModel> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(TopicActivity.this, "Call Failed", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void getIntentData() {
        chapterName = getIntent().getExtras().getString("chapter_name");
        chapterId = getIntent().getExtras().getString("chapter_id");
        color = getIntent().getExtras().getString("color");
    }


    private void initializeView() {
        mLinearlayout = findViewById(R.id.ll_chapter);
        mRecycleChapter = findViewById(R.id.recycle_chapter);
        Toolbar toolbar = findViewById(R.id.custom_toolbar);
        toolbar.setBackgroundColor(Color.parseColor(color));
        mLinearlayout.setBackgroundColor(Color.parseColor(color));
        btnBack = toolbar.findViewById(R.id.toolbar_left_icon);
        mTitle = toolbar.findViewById(R.id.toolbar_title);
        mTitle.setText(chapterName);
        mItemName = findViewById(R.id.chapter_text);
        mItemName.setTextColor(Color.parseColor(color));
        mItemName.setText("Topics Name");
        mRecycleChapter.setLayoutManager(new LinearLayoutManager(this));
        btnBack.setOnClickListener(this);
        mTopicAdapter = new TopicAdapter(topicBean, this);
        mSearchText = toolbar.findViewById(R.id.toolbar_search);
        EditText searchEditText = (EditText) mSearchText.findViewById(R.id.search_src_text);
        searchEditText.setTextColor(getResources().getColor(R.color.white));
        View searchplate = (View) mSearchText.findViewById(R.id.search_plate);
        searchplate.getBackground().setColorFilter(Color.WHITE, PorterDuff.Mode.MULTIPLY);
        searchEditText.setHintTextColor(getResources().getColor(R.color.white));


        mSearchText.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                search(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //search(newText);
                return false;
            }
        });

    }

    private void search(String query) {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Searching...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
        ApiService apiService = RetrofitClient.createRetrofitService(ApiService.class);
        Call<SearchModel> call = apiService.performSearchOperation(query);
        call.enqueue(new Callback<SearchModel>() {
            @Override
            public void onResponse(Call<SearchModel> call, retrofit2.Response<SearchModel> response) {
                progressDialog.dismiss();
                if (response.code() == 200) {
                    if (response.body().isStatus()) {
                        searchResult.clear();
                        for (int i = 0; i < response.body().getData().size(); i++)
                            searchResult.add(response.body().getData().get(i));
                        if (searchResult.size() == 0) {
                            Toast.makeText(TopicActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        } else {
                            startActivity(new Intent(TopicActivity.this, SearchResultActivity.class).putParcelableArrayListExtra("search_result", (ArrayList<? extends Parcelable>) searchResult));

                        }

                    } else {
                        Toast.makeText(TopicActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else
                    Toast.makeText(TopicActivity.this, "Something went wrong..", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<SearchModel> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(TopicActivity.this, "Call Failed", Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public void onClick(View view) {
        onBackPressed();
    }

    @Override
    public void onItemClickListener(int position) {
        Intent intent = new Intent(this, VideoDiscription.class);
        intent.putExtra("id", topicBean.get(position).getChapter_id());
        intent.putExtra("url", topicBean.get(position).getVideo_url());
        intent.putExtra("description", topicBean.get(position).getDescription());
        intent.putExtra("likes", topicBean.get(position).getVideo_like());
        intent.putExtra("thumbnail", topicBean.get(position).getThumbnail());
        intent.putExtra("notes_url", topicBean.get(position).getThumbnail());
        intent.putExtra("video_name", topicBean.get(position).getVideo_name());
        intent.putExtra("video_id", topicBean.get(position).getVideo_id());
        intent.putExtra("isLike", topicBean.get(position).isIsLiked());
        intent.putExtra("isFavourited", topicBean.get(position).isIsFavourited());
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getChapters();
    }
}
