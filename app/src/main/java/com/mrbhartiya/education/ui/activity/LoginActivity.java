package com.mrbhartiya.education.ui.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.google.firebase.iid.FirebaseInstanceId;
import com.mrbhartiya.education.R;
import com.mrbhartiya.education.api.ApiService;
import com.mrbhartiya.education.api.RetrofitClient;
import com.mrbhartiya.education.model.UserModel;
import com.mrbhartiya.education.utility.PreferenceHelper;
import com.mrbhartiya.education.utility.StringUtility;
import com.mrbhartiya.education.utility.SystemUtility;

import java.util.WeakHashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private Button mLogin;
    private TextView mSignUp, mForgotPassword;
    private EditText mPhoneNo;
    private EditText mPassword;
    private ImageView mImageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mLogin = findViewById(R.id.btn_login);
        mSignUp = findViewById(R.id.textViewSignUp);
        mForgotPassword = findViewById(R.id.txt_forgot_password);
        mPhoneNo = findViewById(R.id.ed_phone_number);
        mPassword = findViewById(R.id.ed_password);
        mImageView = findViewById(R.id.test_image);
        Log.e("uuid", PreferenceHelper.getDeviceUuid());
        Log.e("fcm", FirebaseInstanceId.getInstance().getToken());

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                if (isValidateFields()) {
                    if (SystemUtility.isConnectingToInternet(LoginActivity.this)) {
                        performLogin();
                    } else {
                        SystemUtility.showNetworkFailureAlert(LoginActivity.this);
                    }
                }
                break;
            case R.id.textViewSignUp:
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
                break;
            case R.id.txt_forgot_password:
                if (!TextUtils.isEmpty(mPhoneNo.getText().toString().trim())) {
                    if (SystemUtility.isConnectingToInternet(LoginActivity.this))
                        performForgotPassword();
                    else
                        SystemUtility.showNetworkFailureAlert(LoginActivity.this);

                } else {
                    SystemUtility.showAlert(this, getResources().getString(R.string.app_name), getResources().getString(R.string.err_phone_empty));
                }


        }
    }

    private void performForgotPassword() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Loading...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
        ApiService apiService = RetrofitClient.createRetrofitService(ApiService.class);
        Call<UserModel> call = apiService.performForgotPassword( mPhoneNo.getText().toString().trim());
        call.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                progressDialog.dismiss();

                if (response.code() == 200) {
                    if (response.body().isStatus()) {
                        onForgotSuccess(response.body());

                    } else {
                        Toast.makeText(LoginActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else
                    Toast.makeText(LoginActivity.this, "Something went wrong..", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                progressDialog.dismiss();

                Toast.makeText(LoginActivity.this, "Call Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void onForgotSuccess(UserModel body) {
        startActivity(new Intent(this, ForgotPasswordActivity.class));//.putExtra("otp", body.getData().getOtp()).putExtra("contact_no", body.getData().getContact_no()));
    }

    private void performLogin() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Logging in...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
        WeakHashMap<String, String> param = new WeakHashMap<>();
        param.put("username", mPhoneNo.getText().toString());
        param.put("password", mPassword.getText().toString());
        param.put("device_id", PreferenceHelper.getDeviceUuid());
        param.put("fcm_token", FirebaseInstanceId.getInstance().getToken());
        ApiService apiService = RetrofitClient.createRetrofitService(ApiService.class);
        Call<UserModel> call = apiService.performLogin(param);
        call.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, retrofit2.Response<UserModel> response) {
                progressDialog.dismiss();
                if (response.code() == 200) {
                    if (response.body().isStatus()) {
                        PreferenceHelper.setKeyUserData(response.body());
                        PreferenceHelper.setUserClass(response.body().getData().getUser_class());
                        PreferenceHelper.setUserToken("Bearer " + response.body().getData().getAccess_token());
                        PreferenceHelper.setBucketUrl(response.body().getData().getBucket_url());
                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else
                    Toast.makeText(LoginActivity.this, "Something went wrong..", Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(LoginActivity.this, "Call Failed", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }


    public boolean isValidateFields() {
        if (mPhoneNo.getText().toString().isEmpty()) {
            mPhoneNo.setError(getResources().getString(R.string.err_phone_empty));
            return false;
        } else if (!StringUtility.isValidPhoneNumber(mPhoneNo.getText().toString())) {
            mPhoneNo.setError(getResources().getString(R.string.err_phone_invalid));
            return false;
        } else if (mPassword.getText().toString().isEmpty()) {
            mPassword.setError(getResources().getString(R.string.err_password_empty));
            return false;
        } else
            return true;
    }

}
