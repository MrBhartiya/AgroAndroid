package com.mrbhartiya.education.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mrbhartiya.education.R;
import com.mrbhartiya.education.model.HomeModel;
import com.mrbhartiya.education.ui.adapter.DemoVideoAdapter;

import java.util.ArrayList;

public class DemoVideoActivity extends BaseActivity implements DemoVideoAdapter.onItemClick, View.OnClickListener {
    ArrayList<HomeModel.DataBean.DemoVideoListBean> arrDemoData = new ArrayList<>();
    private RecyclerView recycleDemoVideo;
    private TextView txtTittle;
    private ImageView btnBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_videos);
        arrDemoData = (ArrayList<HomeModel.DataBean.DemoVideoListBean>) getIntent().getSerializableExtra("demoVideo");
        recycleDemoVideo = findViewById(R.id.recycle_demo);
        txtTittle = findViewById(R.id.toolbar).findViewById(R.id.toolbar_title);
        txtTittle.setText(getResources().getString(R.string.str_demo_videos));
        recycleDemoVideo.setLayoutManager(new LinearLayoutManager(this));
        recycleDemoVideo.setAdapter(new DemoVideoAdapter(arrDemoData, this));
        btnBack = findViewById(R.id.toolbar).findViewById(R.id.toolbar_left_icon);
        btnBack.setOnClickListener(this);


    }

    @Override
    public void onItemClickListener(int position) {
        Intent intent = new Intent(this, VideoDiscription.class);
        intent.putExtra("id", arrDemoData.get(position).getVideo_id());
        intent.putExtra("url", arrDemoData.get(position).getVideo_url());
        intent.putExtra("description", arrDemoData.get(position).getDescription());
        intent.putExtra("isLiked", arrDemoData.get(position).isIsLiked());
        intent.putExtra("isFavourited", arrDemoData.get(position).isIsFavourited());
        intent.putExtra("thumbnail", arrDemoData.get(position).getThumbnail());
        intent.putExtra("notes_url", arrDemoData.get(position).getVideo_notes_url());
        intent.putExtra("video_name", arrDemoData.get(position).getVideo_name());
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.toolbar_left_icon:
                onBackPressed();
                break;
        }

    }
}
