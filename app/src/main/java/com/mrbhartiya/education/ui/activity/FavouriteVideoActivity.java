package com.mrbhartiya.education.ui.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mrbhartiya.education.R;
import com.mrbhartiya.education.api.ApiService;
import com.mrbhartiya.education.api.RetrofitClient;
import com.mrbhartiya.education.api.response.BaseResponse;
import com.mrbhartiya.education.model.HomeModel;
import com.mrbhartiya.education.ui.adapter.FavouriteVideoAdapter;
import com.mrbhartiya.education.utility.PreferenceHelper;
import com.mrbhartiya.education.utility.SystemUtility;

import java.util.ArrayList;
import java.util.WeakHashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FavouriteVideoActivity extends BaseActivity implements FavouriteVideoAdapter.onItemClick, View.OnClickListener, FavouriteVideoAdapter.onItemDelete {
    ArrayList<HomeModel.DataBean.FavouriteVideosBean> arrFavData = new ArrayList<>();
    ImageView btnBack;
    TextView txtTittle;
    private RecyclerView recycleFavourite;
    private TextView mDeleteAll;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite_video);

        if (getIntent().hasExtra("favVideo")) {
            arrFavData = getIntent().getParcelableArrayListExtra("favVideo");
        }
        Toolbar toolbar = findViewById(R.id.toolbar);
        recycleFavourite = findViewById(R.id.recycle_favourite);

        recycleFavourite.setLayoutManager(new LinearLayoutManager(this));
        recycleFavourite.setAdapter(new FavouriteVideoAdapter(arrFavData, this, this));
        txtTittle = toolbar.findViewById(R.id.toolbar_title);
        txtTittle.setText(getResources().getString(R.string.str_fav_video));
        mDeleteAll = findViewById(R.id.delete_all);
        btnBack = toolbar.findViewById(R.id.toolbar_left_icon);
        btnBack.setOnClickListener(this);


    }

    private void deleteAllVideo() {
        ApiService apiService = RetrofitClient.createRetrofitService(ApiService.class);
        Call<BaseResponse> call = apiService.performDeleteAllFavourite();
        call.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                if (response.code() == 200) {
                    if (response.body().isStatus()) {
                        Toast.makeText(FavouriteVideoActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(FavouriteVideoActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else
                    Toast.makeText(FavouriteVideoActivity.this, "Something went wrong..", Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                Toast.makeText(FavouriteVideoActivity.this, "Call Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onItemClickListener(int position) {
        Intent intent = new Intent(this, VideoDiscription.class);
        intent.putExtra("id", arrFavData.get(position).getChapter_id());
        intent.putExtra("url", arrFavData.get(position).getVideo().getVideo_url());
        intent.putExtra("description", arrFavData.get(position).getVideo().getVideo_description());
        intent.putExtra("likes", arrFavData.get(position).getVideo_like());
        intent.putExtra("thumbnail", arrFavData.get(position).getThumbnail());
        intent.putExtra("notes_url", arrFavData.get(position).getVideo().getDocument_url());
        intent.putExtra("video_name", arrFavData.get(position).getVideo().getTitle());
        intent.putExtra("video_id", arrFavData.get(position).getVideo().getVideo_id());
        intent.putExtra("isFavourited", true);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.toolbar_left_icon:
                onBackPressed();
                break;
            case R.id.delete_all:
                SystemUtility.showAlert(FavouriteVideoActivity.this, getResources().getString(R.string.app_name), getResources().getString(R.string.delete_all_video), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        deleteAllVideo();

                    }
                });
                break;
        }

    }

    @Override
    public void onItemDeleteListener(final int position) {

        SystemUtility.showAlert(FavouriteVideoActivity.this, getResources().getString(R.string.app_name), getResources().getString(R.string.str_delete_single_video), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                WeakHashMap<String, String> param = new WeakHashMap<>();
                param.put("video_id", arrFavData.get(position).getVideo_id());
                ApiService apiService = RetrofitClient.createRetrofitService(ApiService.class);
                Call<BaseResponse> call = apiService.performDeleteFavourite( param);
                call.enqueue(new Callback<BaseResponse>() {
                    @Override
                    public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                        if (response.code() == 200) {
                            if (response.body().isStatus()) {
                                Toast.makeText(FavouriteVideoActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                arrFavData.remove(position);
                                recycleFavourite.setAdapter(new FavouriteVideoAdapter(arrFavData, FavouriteVideoActivity.this, FavouriteVideoActivity.this));

                            } else {
                                Toast.makeText(FavouriteVideoActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        } else
                            Toast.makeText(FavouriteVideoActivity.this, "Something went wrong..", Toast.LENGTH_SHORT).show();


                    }

                    @Override
                    public void onFailure(Call<BaseResponse> call, Throwable t) {
                        Toast.makeText(FavouriteVideoActivity.this, "Call Failed", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


    }
}
