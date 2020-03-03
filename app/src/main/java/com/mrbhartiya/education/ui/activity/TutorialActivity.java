package com.mrbhartiya.education.ui.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.mrbhartiya.education.R;
import com.mrbhartiya.education.ui.adapter.TutorialAdapter;
import com.robohorse.pagerbullet.PagerBullet;

public class TutorialActivity extends AppCompatActivity {

    PagerBullet mPager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        initViews();
    }

    private void initViews() {

    }


}
