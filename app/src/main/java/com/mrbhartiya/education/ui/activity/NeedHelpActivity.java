package com.mrbhartiya.education.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mrbhartiya.education.R;

public class NeedHelpActivity extends BaseActivity implements View.OnClickListener {
    TextView txtTittle;
    ImageView imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_need_help);
        init();

    }

    private void init() {
        txtTittle = findViewById(R.id.toolbar_help).findViewById(R.id.toolbar_title);
        txtTittle.setText(getResources().getString(R.string.str_need_help_tittle));
        imgBack = findViewById(R.id.toolbar_help).findViewById(R.id.toolbar_left_icon);
        imgBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_left_icon:
                onBackPressed();
                break;
            default:
                break;
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
