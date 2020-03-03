package com.mrbhartiya.education.ui.activity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.google.firebase.iid.FirebaseInstanceId;
import com.mrbhartiya.education.R;
import com.mrbhartiya.education.api.ApiService;
import com.mrbhartiya.education.api.RetrofitClient;
import com.mrbhartiya.education.model.CitiesModel;
import com.mrbhartiya.education.model.SignupModel;
import com.mrbhartiya.education.model.StatesModel;
import com.mrbhartiya.education.utility.PreferenceHelper;
import com.mrbhartiya.education.utility.StringUtility;
import com.mrbhartiya.education.utility.SystemUtility;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.WeakHashMap;

import retrofit2.Call;
import retrofit2.Callback;

public class SignUpActivity extends BaseActivity implements View.OnClickListener {
    TextView mTittle;
    ImageView mBack;
    ArrayAdapter<CharSequence> langAdapter;
    private Spinner mClassSpinner, mStateSpinner, mCitySpinner;
    private String[] classArray;
    final Calendar myCalendar = Calendar.getInstance();
    private String[] stateArray;
    private String[] cityArray;
    private String selectedClass = "", selectedState = "", selectedCity = "";
    private Button mSignUp;
    private EditText mFullName;
    private Button mMale;
    private Button mFemale;
    private EditText mEmail;
    private TextView mDOB;
    private EditText mPassword;
    private EditText mPhoneNumber;
    private EditText mInviteCode;
    private String gender = "Male";
    private String loaderMessage = "Loading...";
    private List<String> classNewList = new ArrayList<>();
    private List<String> stateNewList = new ArrayList<>();
    private List<String> cityNewList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        initializeView();
    }

    private void initializeView() {

        mTittle = findViewById(R.id.toolbar_signup).findViewById(R.id.toolbar_title);
        mBack = findViewById(R.id.toolbar_signup).findViewById(R.id.toolbar_left_icon);
        mClassSpinner = findViewById(R.id.class_spinner);
        mCitySpinner = findViewById(R.id.city_spinner);
        mStateSpinner = findViewById(R.id.state_spinner);
        mSignUp = findViewById(R.id.btn_signUp);
        mFullName = findViewById(R.id.full_name);
        mMale = findViewById(R.id.btn_male);
        mFemale = findViewById(R.id.btn_female);
        mEmail = findViewById(R.id.email);
        mDOB = findViewById(R.id.dob);
        mPassword = findViewById(R.id.password);
        mPhoneNumber = findViewById(R.id.ed_phone_number);
        mInviteCode = findViewById(R.id.ed_invite_code);
        mTittle.setText(getResources().getString(R.string.signup_tittle));
        mBack.setOnClickListener(this);
        getStateAndClass();
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };
        mClassSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                selectedClass = mClassSpinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
        mStateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                selectedState = mStateSpinner.getSelectedItem().toString();
                getCities(selectedState);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
        mCitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                selectedCity = mCitySpinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
        mDOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(SignUpActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


    }

    private void updateLabel() {
        String myFormat = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        mDOB.setText(sdf.format(myCalendar.getTime()));
    }

    private void performSignUp() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage(loaderMessage);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
        WeakHashMap<String, String> param = new WeakHashMap<>();
        param.put("mobile_no", mPhoneNumber.getText().toString());
        param.put("password", mPassword.getText().toString());
        param.put("name", mFullName.getText().toString());
        param.put("gender", gender);
        param.put("dob", mDOB.getText().toString());
        param.put("email", mEmail.getText().toString());
        param.put("class", selectedClass);
        param.put("city", selectedCity);
        param.put("state", selectedState);
        param.put("referred_by", mInviteCode.getText().toString());
        param.put("device_id", PreferenceHelper.getDeviceUuid());
        param.put("fcm_token", FirebaseInstanceId.getInstance().getToken());
        ApiService apiService = RetrofitClient.createRetrofitService(ApiService.class);
        Call<SignupModel> call = apiService.performSignup(param);
        call.enqueue(new Callback<SignupModel>() {
            @Override
            public void onResponse(Call<SignupModel> call, retrofit2.Response<SignupModel> response) {
                progressDialog.dismiss();
                if (response.code() == 200) {
                    if (response.body().isStatus()) {
                        PreferenceHelper.setKeySignedup("otp");
                        Intent intent = new Intent(SignUpActivity.this, OTPVerificationActivity.class);
                        intent.putExtra("contact_no",mPhoneNumber.getText().toString() );
                        startActivity(intent);
                    } else {
                        Toast.makeText(SignUpActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else
                    Toast.makeText(SignUpActivity.this, "Something went wrong..", Toast.LENGTH_SHORT).show();

            }


            @Override
            public void onFailure(Call<SignupModel> call, Throwable t) {
                progressDialog.dismiss();

                Toast.makeText(SignUpActivity.this, "Call Failed", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void getCities(String selectedState) {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage(loaderMessage);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
        ApiService apiService = RetrofitClient.createRetrofitService(ApiService.class);
        Call<CitiesModel> call = apiService.getAllCities(selectedState);
        call.enqueue(new Callback<CitiesModel>() {
            @Override
            public void onResponse(Call<CitiesModel> call, retrofit2.Response<CitiesModel> response) {
                progressDialog.dismiss();
                if (response.code() == 200) {
                    if (response.body().isStatus()) {
                        cityNewList.clear();
                        for (int i = 0; i < response.body().getData().size(); i++)
                            cityNewList.add(response.body().getData().get(i).getCity_name());
                        cityArray = cityNewList.toArray(new String[0]);
                        langAdapter = new ArrayAdapter<CharSequence>(SignUpActivity.this, R.layout.spinner_text, cityArray);
                        langAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown);
                        mCitySpinner.setAdapter(langAdapter);
                    } else {
                        Toast.makeText(SignUpActivity.this, "Something went wrong..", Toast.LENGTH_SHORT).show();
                    }

                } else
                    Toast.makeText(SignUpActivity.this, "Something went wrong..", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<CitiesModel> call, Throwable t) {
                progressDialog.dismiss();
                System.out.println(call);
                Toast.makeText(SignUpActivity.this, "Call failed", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.toolbar_left_icon:
                onBackPressed();
                break;
            case R.id.btn_signUp:
                if (isValidFields()) {
                    if (SystemUtility.isConnectingToInternet(SignUpActivity.this)) {


                        performSignUp();
                    } else
                        SystemUtility.showNetworkFailureAlert(SignUpActivity.this);
                }
                break;
            case R.id.btn_male:
                gender = "Male";
                mMale.setBackground(getResources().getDrawable(R.drawable.button_language_selected));
                mMale.setTextColor(getResources().getColor(R.color.white));
                mFemale.setBackground(getResources().getDrawable(R.drawable.button_unselected));
                mFemale.setTextColor(getResources().getColor(R.color.colorAccent));
                break;

            case R.id.btn_female:
                gender = "Female";
                mFemale.setBackground(getResources().getDrawable(R.drawable.female_selected));
                mFemale.setTextColor(getResources().getColor(R.color.white));
                mMale.setBackground(getResources().getDrawable(R.drawable.male_unselected));
                mMale.setTextColor(getResources().getColor(R.color.colorAccent));
                break;
        }
    }

    public void getStateAndClass() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage(loaderMessage);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
        ApiService apiService = RetrofitClient.createRetrofitService(ApiService.class);
        Call<StatesModel> call = apiService.getAllStates();
        call.enqueue(new Callback<StatesModel>() {
            @Override
            public void onResponse(Call<StatesModel> call, retrofit2.Response<StatesModel> response) {
                progressDialog.dismiss();
                if (response.code() == 200) {
                    if (response.body().isStatus()) {
                        for (int i = 0; i < response.body().getData().getUser_class().size(); i++)
                            classNewList.add(response.body().getData().getUser_class().get(i).getClass_name());

                        for (int i = 0; i < response.body().getData().getState().size(); i++)
                            stateNewList.add(response.body().getData().getState().get(i).getName());

                        classArray = classNewList.toArray(new String[0]);
                        stateArray = stateNewList.toArray(new String[0]);
                        langAdapter = new ArrayAdapter<CharSequence>(SignUpActivity.this, R.layout.spinner_text, classArray);
                        langAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown);
                        mClassSpinner.setAdapter(langAdapter);

                        langAdapter = new ArrayAdapter<CharSequence>(SignUpActivity.this, R.layout.spinner_text, stateArray);
                        langAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown);
                        mStateSpinner.setAdapter(langAdapter);

                    } else
                        Toast.makeText(SignUpActivity.this, "Something went wrong..", Toast.LENGTH_SHORT).show();

                } else
                    Toast.makeText(SignUpActivity.this, "Something went wrong..", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<StatesModel> call, Throwable t) {
                progressDialog.dismiss();
                System.out.println(call);
                Toast.makeText(SignUpActivity.this, "Something went wrong..", Toast.LENGTH_SHORT).show();

            }
        });
    }


    private boolean isValidFields() {

        if (mFullName.getText().toString().isEmpty()) {
            mFullName.setError(getResources().getString(R.string.err_full_name));
            return false;
        } else if (mEmail.getText().toString().isEmpty()) {
            mEmail.setError(getResources().getString(R.string.err_email_empty));
            return false;
        } else if (mDOB.getText().toString().isEmpty()) {
            mDOB.setError(getResources().getString(R.string.err_dob_empty));
            return false;
        } else if (mPassword.getText().toString().isEmpty()) {
            mPassword.setError(getResources().getString(R.string.err_password_empty));
            return false;
        } else if (mPhoneNumber.getText().toString().isEmpty()) {
            mPhoneNumber.setError(getResources().getString(R.string.err_phone_empty));
            return false;
        } else if (!StringUtility.isValidPhoneNumber(mPhoneNumber.getText().toString())) {
            mPhoneNumber.setError(getResources().getString(R.string.err_phone_invalid));
            return false;
        } else
            return true;

    }

}
