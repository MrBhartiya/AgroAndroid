package com.mrbhartiya.education.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.mrbhartiya.education.R;

public class RedeemActivity extends BaseActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redeem_amount);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_back:
                onBackPressed();
                break;
            case R.id.img_paytm:
                startActivity(new Intent(this, BankDetailsActivity.class));
                break;
            case R.id.img_google_pay:
                break;
        }

    }
}
