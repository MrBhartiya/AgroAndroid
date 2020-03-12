package com.mrbhartiya.education.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.mrbhartiya.education.R;
import com.mrbhartiya.education.api.ApiService;
import com.mrbhartiya.education.api.RetrofitClient;
import com.mrbhartiya.education.model.UserModel;
import com.mrbhartiya.education.model.UserModelSec;
import com.mrbhartiya.education.utility.PreferenceHelper;
import com.mrbhartiya.education.utility.SystemUtility;

import java.util.WeakHashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FirstForgotPasswordActivity extends AppCompatActivity implements View.OnClickListener{
Button btn_Submit;
EditText ed_otp;
TextView txtTittle;
ImageView btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_forgot_password);

        btn_Submit=findViewById(R.id.btn_Submit);
        ed_otp=findViewById(R.id.ed_otp);
        txtTittle = findViewById(R.id.toolbar).findViewById(R.id.toolbar_title);
        txtTittle.setText(getResources().getString(R.string.forgot_tittle));
        btnBack = findViewById(R.id.toolbar).findViewById(R.id.toolbar_left_icon);
        btnBack.setOnClickListener(this);
        btn_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ed_otp.getText().toString().isEmpty()) {
                    ed_otp.setError(getResources().getString(R.string.err_phone_empty));

                }
                else{
                    if (SystemUtility.isConnectingToInternet(FirstForgotPasswordActivity.this))
                        performForgotPassword();
                    else
                        SystemUtility.showNetworkFailureAlert(FirstForgotPasswordActivity.this);

                }
            }
        });
        
    }

    private void performForgotPassword() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Loading...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
        ApiService apiService = RetrofitClient.createRetrofitService(ApiService.class);

        WeakHashMap<String, String> param = new WeakHashMap<>();
        param.put("mobile_no", ed_otp.getText().toString());



        Call<UserModelSec> call = apiService.performForgotPassword(param);
        call.enqueue(new Callback<UserModelSec>() {
            @Override
            public void onResponse(Call<UserModelSec> call, Response<UserModelSec> response) {
                progressDialog.dismiss();

                if (response.body().statuscode == 200) {
                    if (response.body().isStatus()) {
                        onForgotSuccess(response.body());

                    } else {
                        Toast.makeText(FirstForgotPasswordActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else
                    Toast.makeText(FirstForgotPasswordActivity.this, "Something went wrong..", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<UserModelSec> call, Throwable t) {
                progressDialog.dismiss();

                Toast.makeText(FirstForgotPasswordActivity.this, "Call Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void onForgotSuccess(UserModelSec body) {
        startActivity(new Intent(this, ForgotPasswordActivity.class));//.putExtra("otp", body.getData().getOtp()).putExtra("contact_no", body.getData().getContact_no()));
     finish();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.toolbar_left_icon:
                onBackPressed();
                break;
            case R.id.btn_Submit:
                if (isValidAllData()) {
                    if (SystemUtility.isConnectingToInternet(FirstForgotPasswordActivity.this)) {
                        performForgotPassword();
                    } else {
                        SystemUtility.showNetworkFailureAlert(FirstForgotPasswordActivity.this);
                    }

                }
                break;
        }
    }

    private boolean isValidAllData() {
        if (ed_otp.getText().toString().isEmpty()) {
            ed_otp.setError(getResources().getString(R.string.err_otp_empty));
            return false;
        } else
            return true;
    }
}
