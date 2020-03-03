package com.mrbhartiya.education.ui.activity;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.mrbhartiya.education.R;

public class BankDetailsActivity extends BaseActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_details);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_screen_back:
                onBackPressed();
                break;
        }
    }
}
