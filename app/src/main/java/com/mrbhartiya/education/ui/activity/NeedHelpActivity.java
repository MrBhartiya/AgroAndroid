package com.mrbhartiya.education.ui.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;

import com.mrbhartiya.education.R;

public class NeedHelpActivity extends BaseActivity implements View.OnClickListener {
    TextView txtTittle;
    ImageView imgBack;
    Button btn_callus,btn_mail;

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
        btn_callus=findViewById(R.id.btn_callus);
        btn_callus.setOnClickListener(this);
        btn_mail=findViewById(R.id.btn_mail);
        btn_mail.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolbar_left_icon:
                onBackPressed();
                break;
            case R.id.btn_callus:
                _callactionforhelp();

                break;
            case R.id.btn_mail:
                _sendEmail();
                break;
            default:
                break;
        }

    }

    private void _sendEmail() {
        try{

            String[] TO = {"someone@gmail.com"};
            String[] CC = {"xyz@gmail.com"};
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setData(Uri.parse("mailto:"));
            emailIntent.setType("text/plain");


            emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
            emailIntent.putExtra(Intent.EXTRA_CC, CC);
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");


                startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                finish();


        }
        catch (Exception e)
        {
            Log.d("ERROR",e.toString());
        }


    }

    private void _callactionforhelp() {

        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (checkSelfPermission(Manifest.permission.CALL_PHONE)
                        == PackageManager.PERMISSION_GRANTED) {
                    Log.v("TAG", "Permission is granted");
                    String phnum = "+91-8233988003";
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:" + phnum));

                    startActivity(callIntent);
                } else {

                    Log.v("TAG", "Permission is revoked");
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);

                }
            } else { //permission is automatically granted on sdk<23 upon installation
                String phnum = "+91-8233988003";
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + phnum));

                startActivity(callIntent);
            }


        } catch (Exception e) {
            Log.d("ERROR", e.toString());
        }


    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {

            case 1: {

                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    String phnum = "+91-8233988003";
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:" + phnum));

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                             return;
                        }
                    }
                    startActivity(callIntent);

                } else {
                    Toast.makeText(getApplicationContext(), "Permission denied", Toast.LENGTH_SHORT).show();
                }
                return;
            }
    }}

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
