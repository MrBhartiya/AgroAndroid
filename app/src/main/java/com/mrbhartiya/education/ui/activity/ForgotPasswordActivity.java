package com.mrbhartiya.education.ui.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mrbhartiya.education.R;
import com.mrbhartiya.education.api.ApiService;
import com.mrbhartiya.education.api.RetrofitClient;
import com.mrbhartiya.education.model.UserModel;
import com.mrbhartiya.education.utility.SystemUtility;

import java.util.WeakHashMap;

import retrofit2.Call;
import retrofit2.Callback;

public class ForgotPasswordActivity extends Activity implements View.OnClickListener {
    private TextView txtTittle;
    private Button btnSubmit;
    private ImageView btnBack;
    private EditText ed_otp, ed_Password, ed_Confirm_Password;
    int otp;
    String contactNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        initializeView();

    }

    private void initializeView() {
        txtTittle = findViewById(R.id.toolbar).findViewById(R.id.toolbar_title);
        txtTittle.setText(getResources().getString(R.string.forgot_tittle));
        btnBack = findViewById(R.id.toolbar).findViewById(R.id.toolbar_left_icon);
        btnBack.setOnClickListener(this);
        ed_otp = findViewById(R.id.ed_otp);
        ed_Password = findViewById(R.id.ed_password);
        ed_Confirm_Password = findViewById(R.id.ed_confirm_password);
        btnSubmit = findViewById(R.id.btn_Submit);
        btnSubmit.setOnClickListener(this);
        if (getIntent().hasExtra("otp")) {
            otp = getIntent().getIntExtra("otp", 0);
            contactNo = getIntent().getStringExtra("contact_no");
        }


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.toolbar_left_icon:
                onBackPressed();
                break;
            case R.id.btn_Submit:
                if (isValidAllData()) {
                    if (SystemUtility.isConnectingToInternet(ForgotPasswordActivity.this)) {
                        performForgotOperation();
                    } else {
                        SystemUtility.showNetworkFailureAlert(ForgotPasswordActivity.this);
                    }

                }
                break;
        }
    }

    private void performForgotOperation() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Submitting info...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
        WeakHashMap<String, String> param = new WeakHashMap<>();
        param.put("contact_no", contactNo);
        param.put("new_password", ed_Password.getText().toString());
        param.put("otp", String.valueOf(otp));
        ApiService apiService = RetrofitClient.createRetrofitService(ApiService.class);
        Call<UserModel> call = apiService.performForgotPasswordWithDetail(param);
        call.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, retrofit2.Response<UserModel> response) {
                progressDialog.dismiss();
                if (response.code() == 200) {
                    if (response.body().isStatus()) {

                        startLoginActivity();
                    } else {
                        Toast.makeText(ForgotPasswordActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else
                    Toast.makeText(ForgotPasswordActivity.this, "Something went wrong..", Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(ForgotPasswordActivity.this, "Call Failed", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void startLoginActivity() {
        startActivity(new Intent(this, LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
        finish();
    }


    private boolean isValidAllData() {
        if (ed_otp.getText().toString().isEmpty()) {
            ed_otp.setError(getResources().getString(R.string.err_otp_empty));
            return false;
        } else if (ed_Password.getText().toString().isEmpty()) {
            ed_Password.setError(getResources().getString(R.string.err_password_empty));
            return false;
        } else if (ed_Confirm_Password.getText().toString().isEmpty()) {
            ed_Confirm_Password.setError(getResources().getString(R.string.err_confirm_password_empty));
            return false;
        } else if (!ed_Password.getText().toString().trim().equals(ed_Confirm_Password.getText().toString().trim())) {
            SystemUtility.showAlert(this, getResources().getString(R.string.app_name), getResources().getString(R.string.err_password_not_match));
            return false;
        } else
            return true;
    }


}
