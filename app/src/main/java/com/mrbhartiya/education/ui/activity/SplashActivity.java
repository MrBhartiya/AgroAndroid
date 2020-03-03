package com.mrbhartiya.education.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;

import com.mrbhartiya.education.R;
import com.mrbhartiya.education.utility.PreferenceHelper;

public class SplashActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }
    @Override
    protected void onStart() {
        super.onStart();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
                if (PreferenceHelper.getKeyUserData().isEmpty()) {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
                } else {
                    startActivity(new Intent(SplashActivity.this, HomeActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));

                }
            }
        }, 3000);
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkUserSession();
    }

    private void checkUserSession() {
        PreferenceHelper.setDeviceUuid(Settings.Secure.getString(getContext().getContentResolver(), Settings.Secure.ANDROID_ID));

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}
