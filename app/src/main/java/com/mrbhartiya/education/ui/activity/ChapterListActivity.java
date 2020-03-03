package com.mrbhartiya.education.ui.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mrbhartiya.education.R;
import com.mrbhartiya.education.api.ApiService;
import com.mrbhartiya.education.api.RetrofitClient;
import com.mrbhartiya.education.model.ChapterModel;
import com.mrbhartiya.education.model.HomeModel;
import com.mrbhartiya.education.model.SearchModel;
import com.mrbhartiya.education.ui.adapter.ChapterListAdapter;
import com.mrbhartiya.education.utility.PreferenceHelper;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class ChapterListActivity extends BaseActivity implements View.OnClickListener, ChapterListAdapter.onItemClick {
    private RecyclerView mRecycleChapter;
    private ImageView btnBack;
    private HomeModel.DataBean.SubjectListBean data;
    private TextView mItemName;
    private ChapterListAdapter mChapterAdapter;
    private List<ChapterModel.DataBean> chapterList = new ArrayList<>();
    private LinearLayout mLLChapter;
    private TextView mTitle;
    private SearchView mSearchText;
    private List<SearchModel.DataBean> searchResult = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);
        getIntentData();
        initializeView();
        getChapters();
    }

    private void getChapters() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Loading...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
        ApiService apiService = RetrofitClient.createRetrofitService(ApiService.class);
        Call<ChapterModel> call = apiService.perfromChapterFetchOperation(data.getSubject_id());
        call.enqueue(new Callback<ChapterModel>() {
            @Override
            public void onResponse(Call<ChapterModel> call, retrofit2.Response<ChapterModel> response) {
                progressDialog.dismiss();
                if (response.code() == 200) {
                    if (response.body().isStatus()) {
                        chapterList.clear();
                        for (int i = 0; i < response.body().getData().size(); i++) {
                            chapterList.add(response.body().getData().get(i));
                        }
                        mRecycleChapter.setAdapter(mChapterAdapter);


                    } else {
                        Toast.makeText(ChapterListActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else
                    Toast.makeText(ChapterListActivity.this, "Something went wrong..", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<ChapterModel> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(ChapterListActivity.this, "Call Failed", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void getIntentData() {
        Intent i = getIntent();
        Bundle bundle = i.getExtras();
        data = bundle.getParcelable("subject_data");

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void initializeView() {
        mLLChapter = findViewById(R.id.ll_chapter);
        mRecycleChapter = findViewById(R.id.recycle_chapter);
        mItemName = findViewById(R.id.chapter_text);
        mTitle = findViewById(R.id.toolbar_title);
        mItemName.setTextColor(Color.parseColor(data.getColor_code()));
        mRecycleChapter.setLayoutManager(new LinearLayoutManager(this));
        mChapterAdapter = new ChapterListAdapter(chapterList, this);
        Toolbar toolbar = findViewById(R.id.custom_toolbar);
        mTitle = toolbar.findViewById(R.id.toolbar_title);
        btnBack = toolbar.findViewById(R.id.toolbar_left_icon);
        btnBack.setOnClickListener(this);
        toolbar.setBackgroundColor(Color.parseColor(data.getColor_code()));
        mLLChapter.setBackgroundColor(Color.parseColor(data.getColor_code()));
        mTitle.setText(data.getSubject_name());
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
                // search(newText);
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
                            Toast.makeText(ChapterListActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        } else {
                            startActivity(new Intent(ChapterListActivity.this, SearchResultActivity.class).putParcelableArrayListExtra("search_result", (ArrayList<? extends Parcelable>) searchResult));

                        }

                    } else {
                        Toast.makeText(ChapterListActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else
                    Toast.makeText(ChapterListActivity.this, "Something went wrong..", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<SearchModel> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(ChapterListActivity.this, "Call Failed", Toast.LENGTH_SHORT).show();

            }
        });

    }


    @Override
    public void onClick(View view) {
        onBackPressed();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onItemClickListener(int position) {
        Intent intent = new Intent(this, TopicActivity.class);
        intent.putExtra("chapter_id", chapterList.get(position).getChapter_id());
        intent.putExtra("chapter_name", chapterList.get(position).getChapter_name());
        intent.putExtra("color", data.getColor_code());
        startActivity(intent);
    }
}
