package com.mrbhartiya.education.ui.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.mrbhartiya.education.R;
import com.mrbhartiya.education.api.ApiService;
import com.mrbhartiya.education.api.RetrofitClient;
import com.mrbhartiya.education.model.UserModel;
import com.mrbhartiya.education.utility.PreferenceHelper;
import com.mrbhartiya.education.utility.SystemUtility;

import java.util.WeakHashMap;

import retrofit2.Call;
import retrofit2.Callback;

public class OTPVerificationActivity extends BaseActivity {
    private TextView mTittle;
    private ImageView mBack;
    private Button mOTPSignUp;
    private String otp = "";
    private String contactNo = "";
    private EditText mOTP;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_veriifcation);
        initializeView();
        getIntentData();

    }

    private void getIntentData() {
        otp = getIntent().getExtras().getString("otp");
        contactNo = getIntent().getExtras().getString("contact_no");
    }

    private void initializeView() {
        mTittle = findViewById(R.id.layout_otp).findViewById(R.id.toolbar_title);
        mBack = findViewById(R.id.layout_otp).findViewById(R.id.toolbar_left_icon);
        mBack.setVisibility(View.GONE);
        mOTPSignUp = findViewById(R.id.btn_opt);
        mOTP = findViewById(R.id.ed_otp);
        mTittle.setText(getResources().getString(R.string.signup_tittle));
        mBack.setVisibility(View.GONE);
        mTittle.setText(getResources().getString(R.string.otp_tittle));
        mOTPSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOTP.getText().toString().isEmpty()) {
                    mOTP.setError(getResources().getString(R.string.err_otp_empty));
                    return;
                } else {
                    if (SystemUtility.isConnectingToInternet(OTPVerificationActivity.this)) {
                        verifyOTP();
                    } else {
                        SystemUtility.showNetworkFailureAlert(OTPVerificationActivity.this);
                    }

                }
            }
        });
    }

    private void verifyOTP() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Logging in....");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
        WeakHashMap<String, String> param = new WeakHashMap<>();
        param.put("otp", mOTP.getText().toString());
        param.put("mobile_no", contactNo);
        ApiService apiService = RetrofitClient.createRetrofitService(ApiService.class);
        Call<UserModel> call = apiService.performOTPVerification(param);
        call.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, retrofit2.Response<UserModel> response) {
                progressDialog.dismiss();
                if (response.code() == 200) {
                    if (response.body().isStatus()) {
                        PreferenceHelper.setKeyUserData(response.body());
                        PreferenceHelper.setUserClass(response.body().getData().getUser_class());
                        PreferenceHelper.setUserToken("Bearer " + response.body().getData().getAccess_token());
                        startActivity(new Intent(OTPVerificationActivity.this, HomeActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
                    } else {
                        Toast.makeText(OTPVerificationActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else
                    Toast.makeText(OTPVerificationActivity.this, "Something went wrong..", Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                progressDialog.dismiss();
                System.out.println(call);
                Toast.makeText(OTPVerificationActivity.this, "call failed", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public void onBackPressed() {

    }
}
