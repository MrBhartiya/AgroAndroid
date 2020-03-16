package com.mrbhartiya.education.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.mrbhartiya.education.R;
import com.mrbhartiya.education.utility.PreferenceHelper;

import org.json.JSONException;
import org.json.JSONObject;

public class EditProfileActivity extends BaseActivity implements View.OnClickListener {
    TextView txt_username,txt_useremail,txt_userdob,txt_userclass,txt_userphone,txt_city,txt_userstate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        JSONObject obj = null;
        try {
            obj = new JSONObject(PreferenceHelper.getKeyUserData());
            JSONObject userObject = obj.getJSONObject("data");
            txt_username=findViewById(R.id.txt_username);
            txt_useremail=findViewById(R.id.txt_useremail);
            txt_userdob=findViewById(R.id.txt_userdob);
            txt_userclass=findViewById(R.id.txt_userclass);
            txt_userphone=findViewById(R.id.txt_userphone);
            txt_city=findViewById(R.id.txt_city);
            txt_userstate=findViewById(R.id.txt_userstate);

            txt_username.setText(userObject.getString("name"));
            txt_useremail.setText(userObject.getString("email"));
            txt_userdob.setText(userObject.getString("dob"));
            txt_userclass.setText(userObject.getString("user_class"));
            txt_userphone.setText(userObject.getString("mobile_no"));
            txt_city.setText(userObject.getString("city"));
            txt_userstate.setText(userObject.getString("state"));
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
        }
    }
}
