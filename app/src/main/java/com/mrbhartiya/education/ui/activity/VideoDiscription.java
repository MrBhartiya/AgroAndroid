package com.mrbhartiya.education.ui.activity;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.mrbhartiya.education.R;
import com.mrbhartiya.education.api.ApiService;
import com.mrbhartiya.education.api.RetrofitClient;
import com.mrbhartiya.education.api.response.BaseResponse;
import com.mrbhartiya.education.model.AssessmentModel;
import com.mrbhartiya.education.model.VideoOperation;
import com.mrbhartiya.education.utility.Constant;
import com.mrbhartiya.education.utility.PreferenceHelper;
import com.mrbhartiya.education.utility.SystemUtility;
import com.squareup.picasso.Picasso;
import com.universalvideoview.UniversalMediaController;
import com.universalvideoview.UniversalVideoView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VideoDiscription extends BaseActivity implements View.OnClickListener , UniversalVideoView.VideoViewCallback {

private static final String TAG = "MainActivity";
private static final String SEEK_POSITION_KEY = "SEEK_POSITION_KEY";
private static  String VIDEO_URL = "https://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4";

        UniversalVideoView mVideoView;
        UniversalMediaController mMediaController;

        View mBottomLayout;
        View mVideoLayout;
        TextView mStart;

private int mSeekPosition;
private int cachedHeight;
private boolean isFullscreen;

private String videoUrl;
    private String videoDesc;
    LinearLayout linearLike, linearFav, linearDownload;

    public static final String PROGRESS_UPDATE = "update";
    private String videoName;
    private Boolean isFavourited = false;
    private Boolean isLike = false;
    private String likes;
    private TextView mVideoTitle;
    private TextView mVideoDesc;
    private ImageView mThumbnail, imgBack;
    private LinearLayout mPlayVideo;
    private String videoNotes;
    private ImageView mVideoPDF;
    private ImageView mVideodownload;
    private String thumbnail, video_id;
    private LinearLayout mNotesLayout;
    private LinearLayout mFavlayout;
    private long downloadID;
    private ImageView mLikeImage;
    private ImageView mFavouritedImage;
    private LinearLayout mAssessmetll;
    private List<AssessmentModel.DataBean> assessmentList = new ArrayList<>();
    private BroadcastReceiver onDownloadComplete = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            long id = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);
            if (downloadID == id) {
                Toast.makeText(VideoDiscription.this, "Download Completed", Toast.LENGTH_SHORT).show();
            }
        }
    };
///// VIDEO DE

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_discription_layout);
        registerReceiver(onDownloadComplete, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
        mLikeImage = findViewById(R.id.image_like);
        mFavouritedImage = findViewById(R.id.favourited_image);
        mVideoTitle = findViewById(R.id.video_title);
        mVideoDesc = findViewById(R.id.video_disc);
        mThumbnail = findViewById(R.id.demo_video_view);
        mPlayVideo = findViewById(R.id.play_video);
        mVideoPDF = findViewById(R.id.video_notes);
        mVideodownload = findViewById(R.id.video_download);
        linearLike = findViewById(R.id.linear_like);
        linearFav = findViewById(R.id.linear_fav);
        linearDownload = findViewById(R.id.linear_download);
        mNotesLayout = findViewById(R.id.linear_notes);
        mFavlayout = findViewById(R.id.linear_fav);
        imgBack = findViewById(R.id.img_back);
        mAssessmetll = findViewById(R.id.assessment_ll);
        getIntentData();
        setData();


        if (isLike)
            mLikeImage.setBackground(getResources().getDrawable(R.drawable.like));
        if (isFavourited)
            mFavouritedImage.setBackground(getResources().getDrawable(R.drawable.favorite));


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(onDownloadComplete);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void download() {
        File directory = new File(Constant.STORAGE_LOCATION);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        File file = new File(Constant.STORAGE_LOCATION, videoName);
        Toast.makeText(VideoDiscription.this, "Downloading File", Toast.LENGTH_SHORT).show();
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(videoUrl))
                .setTitle(videoName)// Title of the Download Notification
                .setDescription("Downloading")// Description of the Download Notification
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)// Visibility of the download Notification
                .setDestinationUri(Uri.fromFile(file))// Uri of the destination file
                .setRequiresCharging(false)// Set if charging is required to begin the download
                .setAllowedOverMetered(true)// Set if download is allowed on Mobile network
                .setAllowedOverRoaming(true);// Set if download is allowed on roaming network
        DownloadManager downloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
        downloadID = downloadManager.enqueue(request);// enqueue puts the download request in the queue.

    }


    private void getIntentData() {
        video_id = getIntent().getExtras().getString("video_id");
        videoUrl = getIntent().getExtras().getString("url");
        videoDesc = getIntent().getExtras().getString("description");
        likes = String.valueOf(getIntent().getExtras().getInt("likes", 0));
        thumbnail = getIntent().getExtras().getString("thumbnail");
        videoNotes = getIntent().getExtras().getString("notes_url");
        videoName = getIntent().getExtras().getString("video_name");
        isFavourited = getIntent().getExtras().getBoolean("isFavourited");
        isLike = getIntent().getExtras().getBoolean("isLike");

    }

    private void setData() {
        mVideoDesc.setText(videoDesc);
        Picasso.get().load(thumbnail).into(mThumbnail);

        mVideoLayout = findViewById(R.id.video_layout);
        mVideoView = findViewById(R.id.videoView);
        mBottomLayout = findViewById(R.id.bottom_layout);
        mMediaController = (UniversalMediaController) findViewById(R.id.media_controller);
        mVideoView.setMediaController(mMediaController);
        setVideoAreaSize();
        mVideoView.setVideoViewCallback(this);
        mStart = (TextView) findViewById(R.id.start);

        Log.d(TAG, "onCompletion position " + mSeekPosition);
        VIDEO_URL= PreferenceHelper.getBucketUrl()+videoUrl;

//        mStart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (mSeekPosition > 0) {
//                    mVideoView.seekTo(mSeekPosition);
//                }
//                mVideoView.start();
//                mMediaController.setTitle("Big Buck Bunny");
//            }
//        });

        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Log.d(TAG, "onCompletion ");
            }
        });
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.play_video:
                Intent player = new Intent(VideoDiscription.this, VideoPlayer.class);
                player.putExtra("url", videoUrl);
                PreferenceHelper.setLastPlayedVideo(videoUrl);
                startActivity(player);
                break;
            case R.id.linear_notes:
                Intent player1 = new Intent(VideoDiscription.this, PDFViewActivity.class);
                player1.putExtra("url", videoNotes);
                startActivity(player1);

                break;
            case R.id.video_download:
                download();
                break;

            case R.id.linear_fav:
                favouriteOperation();
                break;
            case R.id.linear_like:
                if (SystemUtility.isConnectingToInternet(VideoDiscription.this)) {
                    likeVideos();
                } else {
                    Toast.makeText(this, getResources().getString(R.string.network_not_available_mg), Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.assessment_ll:
                if (SystemUtility.isConnectingToInternet(VideoDiscription.this)) {
                    getAssessment();

                } else {
                    Toast.makeText(this, getResources().getString(R.string.network_not_available_mg), Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.img_back:
                onBackPressed();
                break;
        }

    }

    private void getAssessment() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Loading...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
        WeakHashMap<String, String> param = new WeakHashMap<>();
        param.put("video_id", video_id);
        ApiService apiService = RetrofitClient.createRetrofitService(ApiService.class);
        Call<AssessmentModel> call = apiService.performAssessmentOperation(video_id);
        call.enqueue(new Callback<AssessmentModel>() {
            @Override
            public void onResponse(Call<AssessmentModel> call, Response<AssessmentModel> response) {
                progressDialog.dismiss();

                if (response.code() == 200) {
                    if (response.body().isStatus()) {
                        assessmentList.clear();
                        for (int i = 0; i < response.body().getData().size(); i++)
                            assessmentList.add(response.body().getData().get(i));
                        if (assessmentList.size() == 0) {
                            Toast.makeText(VideoDiscription.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        } else {
                            startActivity(new Intent(VideoDiscription.this, QuestionsActivity.class).putParcelableArrayListExtra("assessment", (ArrayList<? extends Parcelable>) assessmentList));

                        }

                    } else {
                        Toast.makeText(VideoDiscription.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else
                    Toast.makeText(VideoDiscription.this, "Something went wrong..", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<AssessmentModel> call, Throwable t) {
                progressDialog.dismiss();

                Toast.makeText(VideoDiscription.this, "Call Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void favouriteOperation() {
        WeakHashMap<String, String> param = new WeakHashMap<>();
        param.put("video_id", video_id);
        ApiService apiService = RetrofitClient.createRetrofitService(ApiService.class);
        Call<VideoOperation> call = apiService.performVideoFavourite(param);
        call.enqueue(new Callback<VideoOperation>() {
            @Override
            public void onResponse(Call<VideoOperation> call, Response<VideoOperation> response) {
                if (response.code() == 200) {
                    if (response.body().isStatus()) {
                       if(response.body().getMessage().equals( "video unfavourited successfully")){
                           mFavouritedImage.setBackground(getResources().getDrawable(R.drawable.favorite_icon_inactive));

                       }
                       else{
                           mFavouritedImage.setBackground(getResources().getDrawable(R.drawable.favorite));

                       }
                        Toast.makeText(VideoDiscription.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(VideoDiscription.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else
                    Toast.makeText(VideoDiscription.this, "Something went wrong..", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<VideoOperation> call, Throwable t) {
                Toast.makeText(VideoDiscription.this, "Call Failed", Toast.LENGTH_SHORT).show();
            }
        });

    }


    public void likeVideos() {

        WeakHashMap<String, String> param = new WeakHashMap<>();
        param.put("video_id", video_id);
        param.put("operation", "like");
        ApiService apiService = RetrofitClient.createRetrofitService(ApiService.class);
        Call<BaseResponse> call = apiService.performVideoLike( param);
        call.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                if (response.code() == 200) {
                    if (response.body().isStatus()) {
                        if(response.body().getMessage().equals("Video liked successfully")){
                            mLikeImage.setBackground(getResources().getDrawable(R.drawable.like));
                        }
                        else{
                            mLikeImage.setBackground(getResources().getDrawable(R.drawable.like_icon_inactive));
                        }


                        Toast.makeText(VideoDiscription.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(VideoDiscription.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else
                    Toast.makeText(VideoDiscription.this, "Something went wrong..", Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                Toast.makeText(VideoDiscription.this, "Call Failed", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause ");
        if (mVideoView != null && mVideoView.isPlaying()) {
            mSeekPosition = mVideoView.getCurrentPosition();
            Log.d(TAG, "onPause mSeekPosition=" + mSeekPosition);
            mVideoView.pause();
        }
    }


    private void setVideoAreaSize() {
        mVideoLayout.post(new Runnable() {
            @Override
            public void run() {
                int width = mVideoLayout.getWidth();
                cachedHeight = (int) (width * 405f / 720f);
                ViewGroup.LayoutParams videoLayoutParams = mVideoLayout.getLayoutParams();
                videoLayoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
                videoLayoutParams.height = cachedHeight;
                mVideoLayout.setLayoutParams(videoLayoutParams);
                mVideoView.setVideoPath(VIDEO_URL);

                mVideoView.requestFocus();
                mVideoView.seekTo(1);

            }
        });
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState Position=" + mVideoView.getCurrentPosition());
        outState.putInt(SEEK_POSITION_KEY, mSeekPosition);
    }

    @Override
    protected void onRestoreInstanceState(Bundle outState) {
        super.onRestoreInstanceState(outState);
        mSeekPosition = outState.getInt(SEEK_POSITION_KEY);
        Log.d(TAG, "onRestoreInstanceState Position=" + mSeekPosition);


    }


    @Override
    public void onScaleChange(boolean isFullscreen) {
        this.isFullscreen = isFullscreen;
        if (isFullscreen) {
            ViewGroup.LayoutParams layoutParams = mVideoLayout.getLayoutParams();
            layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
            layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
            mVideoLayout.setLayoutParams(layoutParams);
            mBottomLayout.setVisibility(View.GONE);
            mVideoView.seekTo(mSeekPosition);
            mVideoView.start();

        } else {
            ViewGroup.LayoutParams layoutParams = mVideoLayout.getLayoutParams();
            layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
            layoutParams.height = this.cachedHeight;
            mVideoLayout.setLayoutParams(layoutParams);
            mBottomLayout.setVisibility(View.VISIBLE);
            mVideoView.seekTo(mSeekPosition);
            mVideoView.start();
        }

        switchTitleBar(!isFullscreen);
    }

    private void switchTitleBar(boolean show) {
//        ActionBar supportActionBar = getSupportActionBar();
//        if (supportActionBar != null) {
//            if (show) {
//                supportActionBar.show();
//            } else {
//                supportActionBar.hide();
//            }
//        }
    }

    @Override
    public void onPause(MediaPlayer mediaPlayer) {
        Log.d(TAG, "onPause UniversalVideoView callback");
    }

    @Override
    public void onStart(MediaPlayer mediaPlayer) {
        Log.d(TAG, "onStart UniversalVideoView callback");
    }

    @Override
    public void onBufferingStart(MediaPlayer mediaPlayer) {
        Log.d(TAG, "onBufferingStart UniversalVideoView callback");

    }

    @Override
    public void onBufferingEnd(MediaPlayer mediaPlayer) {
        Log.d(TAG, "onBufferingEnd UniversalVideoView callback");
    }

    @Override
    public void onBackPressed() {
        if (this.isFullscreen) {
            mVideoView.setFullscreen(false);
        } else {
            super.onBackPressed();
        }
    }


}