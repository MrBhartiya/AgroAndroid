package com.mrbhartiya.education.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.mrbhartiya.education.R;
import com.mrbhartiya.education.utility.PreferenceHelper;

import org.json.JSONException;
import org.json.JSONObject;

public class ReferEarnActivity extends BaseActivity implements View.OnClickListener {
    ImageView imgBack,img_share;
    TextView txtTittle;
    TextView referalCode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refer_earn);
        imgBack = findViewById(R.id.toolbar_refer).findViewById(R.id.toolbar_left_icon);
        imgBack.setOnClickListener(this);
        txtTittle = findViewById(R.id.toolbar_refer).findViewById(R.id.toolbar_title);
        txtTittle.setText(getResources().getString(R.string.str_refer_tittle));
        referalCode = findViewById(R.id.txt_refer_code);
        img_share=findViewById(R.id.img_share);
        img_share.setOnClickListener(this);

        try {
            JSONObject obj  = new JSONObject(PreferenceHelper.getKeyUserData());
            JSONObject userObject = obj.getJSONObject("data");
            referalCode.setText(userObject.getString("referral_code"));

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_left_icon:
                onBackPressed();
                break;

            case  R.id.img_share:
                _sharemydetail();
                break;

        }

    }

    private void _sharemydetail() {

        try{
            String msg="HURRY ,\n  download this from https:mrbhartiya.com and get reawrds use my code:-"+referalCode.getText().toString()
                    ;

            Intent share = new Intent(Intent.ACTION_SEND);
            share.setType("text/plain");
            share.putExtra(Intent.EXTRA_TEXT, msg);

            startActivity(Intent.createChooser(share,"") );




        }catch (Exception e)
        {
            Log.d("ERROR",e.toString());
        }

    }
}
