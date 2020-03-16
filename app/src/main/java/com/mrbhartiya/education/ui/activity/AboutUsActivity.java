package com.mrbhartiya.education.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mrbhartiya.education.R;

public class AboutUsActivity extends AppCompatActivity {
    ImageView imgBack,img_share;
    TextView txtTittle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        imgBack = findViewById(R.id.toolbar_refer).findViewById(R.id.toolbar_left_icon);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        txtTittle = findViewById(R.id.toolbar_refer).findViewById(R.id.toolbar_title);
        txtTittle.setText(getResources().getString(R.string.str_about_us));
    }
}
