package com.mrbhartiya.education.ui.activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;

import com.mrbhartiya.education.R;

import java.io.File;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import fr.maxcom.http.LocalSingleHttpServer;
import fr.maxcom.libmedia.Licensing;

public class CustomMediaPlayer extends BaseActivity {
    LocalSingleHttpServer mServer;
    String pathID;
    MediaPlayer mediaPlayer;
    private VideoView savedVideoLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_play);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        savedVideoLayout = findViewById(R.id.videoviewLocal);
        Intent bundle = getIntent();
        pathID = bundle.getStringExtra("id");
        Licensing.allow(getApplicationContext());
        offlineVideos();
    }

    public void offlineVideos() {
        try {
            String path = Environment.getExternalStorageDirectory() + File.separator + ".mbr/Introductionenc";
            mServer = new LocalSingleHttpServer();
            mServer.setCipher(myGetCipher());
            mServer.start();
            String serverPath = mServer.getURL(path);

            savedVideoLayout.setVisibility(View.VISIBLE);
            final MediaController mediacontroller = new MediaController(this);
            mediacontroller.setAnchorView(savedVideoLayout);
            savedVideoLayout.setMediaController(mediacontroller);
            savedVideoLayout.setVideoURI(Uri.parse(serverPath));
            savedVideoLayout.requestFocus();
            savedVideoLayout.start();
            savedVideoLayout.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                @Override
                public boolean onError(MediaPlayer mp, int what, int extra) {
                    Toast.makeText(CustomMediaPlayer.this, "error....", Toast.LENGTH_SHORT).show();
                    return false;
                }
            });
            savedVideoLayout.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                public void onPrepared(MediaPlayer mediaPlayer) {
                    CustomMediaPlayer.this.mediaPlayer = mediaPlayer;
                    savedVideoLayout.start();
                }
            });

        } catch (Exception ex) {
            Log.e("httpserver", ex.getMessage());
        }
    }

    private Cipher myGetCipher() {
        // avoid the default security provider "AndroidOpenSSL" in Android 4.3+ (http://libeasy.alwaysdata.net/network/#provider)
        Cipher c = null;
        try {
            c = Cipher.getInstance("AES");
            c.init(Cipher.DECRYPT_MODE, new SecretKeySpec("MyDifficultPassw".getBytes(), "AES"), new IvParameterSpec(new byte[16]));
        } catch (Exception ex) {
            Log.e("error in decrypt", ex.toString());
        }
        return c;
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            // getSupportActionBar().show();


        } else if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // getSupportActionBar().hide();
            savedVideoLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT));
        }

    }

    private void setPlaySpeed(float speed) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && mediaPlayer != null) {
            PlaybackParams playbackParamsSpeed = mediaPlayer.getPlaybackParams();
            playbackParamsSpeed.setSpeed(speed); //you can set speed here
            mediaPlayer.setPlaybackParams(playbackParamsSpeed);
        }
    }


}
