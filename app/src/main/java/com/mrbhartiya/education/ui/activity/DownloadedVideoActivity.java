package com.mrbhartiya.education.ui.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mrbhartiya.education.R;
import com.mrbhartiya.education.model.DownloadedVideoModel;
import com.mrbhartiya.education.ui.adapter.DownloadedVideoAdapter;
import com.mrbhartiya.education.utility.Constant;
import com.mrbhartiya.education.utility.SystemUtility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DownloadedVideoActivity extends BaseActivity implements DownloadedVideoAdapter.onItemClick, View.OnClickListener {

    RecyclerView mRecycleDownload;
    ImageView imgBack;
    TextView txtTittle, txtClearAll;
    private List<DownloadedVideoModel> downloadedVideo = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_downloaded_video);
        mRecycleDownload = findViewById(R.id.recycle_downloaded);
        mRecycleDownload.setLayoutManager(new LinearLayoutManager(this));
        imgBack = findViewById(R.id.toolbar).findViewById(R.id.toolbar_left_icon);
        txtTittle = findViewById(R.id.toolbar).findViewById(R.id.toolbar_title);
        txtTittle.setText(getResources().getString(R.string.str_downloaded_videos));
        txtClearAll = findViewById(R.id.txt_clear_all);
        imgBack.setOnClickListener(this);
        getDownloadedVideo();

    }


    private void getDownloadedVideo() {
        downloadedVideo.clear();
        // String path = Environment.getExternalStorageDirectory().toString();
        File f = new File(Constant.STORAGE_LOCATION);
        File file[] = f.listFiles();
        if (file != null) {
            for (int i = 0; i < file.length; i++) {
                DownloadedVideoModel downloadedVideoModel = new DownloadedVideoModel();
                downloadedVideoModel.setFileName(file[i].getName());
                downloadedVideoModel.setFilePath(file[i].getPath());
                downloadedVideo.add(downloadedVideoModel);
            }
        }
        mRecycleDownload.setAdapter(new DownloadedVideoAdapter(downloadedVideo, this));


    }


    @Override
    public void onItemClickListener(final int position) {

        SystemUtility.showAlert(DownloadedVideoActivity.this, getResources().getString(R.string.app_name), getResources().getString(R.string.str_delete_single_video), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                File fdelete = new File(downloadedVideo.get(position).getFilePath());
                if (fdelete.exists()) {
                    if (fdelete.delete()) {
                        downloadedVideo.remove(position);
                        ((DownloadedVideoAdapter) mRecycleDownload.getAdapter()).notifyDataSetChanged();
                    } else {
                        System.out.println("file not Deleted :" + downloadedVideo.get(position).getFilePath());
                    }

                }

            }
        });


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.toolbar_left_icon:
                onBackPressed();
                break;
            case R.id.txt_clear_all:
                SystemUtility.showAlert(DownloadedVideoActivity.this, getResources().getString(R.string.app_name),
                        getResources().getString(R.string.delete_all_video), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                File dir = new File(Environment.getExternalStorageDirectory() + Constant.STORAGE_LOCATION);
                                deleteFiles(Constant.STORAGE_LOCATION);
                            }
                        });
                break;
            default:
                break;
        }


    }


    public void deleteFiles(String path) {

        File file = new File(path);

        if (file.exists()) {
            String deleteCmd = "rm -r " + path;
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec(deleteCmd);
            } catch (IOException e) {
            }
            ((DownloadedVideoAdapter) mRecycleDownload.getAdapter()).notifyDataSetChanged();
            downloadedVideo.clear();
        }


    }
}
