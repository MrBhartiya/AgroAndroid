package com.mrbhartiya.education.ui.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.mrbhartiya.education.R;
import com.mrbhartiya.education.permission.PermissionResultCallback;
import com.mrbhartiya.education.permission.PermissionUtils;
import com.mrbhartiya.education.ui.view.BaseView;
import com.mrbhartiya.education.utility.ForceUpdateChecker;
import com.mrbhartiya.education.utility.StringUtility;

import java.util.ArrayList;
import java.util.concurrent.ScheduledExecutorService;


public abstract class BaseActivity extends Activity implements PermissionResultCallback, BaseView, ForceUpdateChecker.OnUpdateNeededListener {
    ProgressDialog progressDialog;
    PermissionUtils permissionUtils;
    ArrayList<String> blutoothPermission = new ArrayList();

    @Override
    protected void onStop() {
        super.onStop();
    }


    ScheduledExecutorService scheduleTaskExecutor;


    @Override
    protected void onResume() {
        super.onResume();

    }

    public String tag() {
        return getClass().getSimpleName();
    }

    public void log(String message) {
        Log.d(tag(), message);
    }

    public void toast(final String message) {
        Toast.makeText(BaseActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    public void configureToolBar(@NonNull final Toolbar toolbar, boolean isHome) {
        configureToolBar(toolbar, R.color.white, isHome);
    }

    public void configureToolBar(@NonNull final Toolbar toolbar, @ColorRes int color, boolean isFromHome) {

        setTitle("Home ACtivity");
        for (int i = 0; i < toolbar.getChildCount(); i++) {
            View view = toolbar.getChildAt(i);

            if (view instanceof TextView) {
                TextView textView = (TextView) view;

                if (isFromHome)
                    textView.setVisibility(View.GONE);
                else {

                    textView.setVisibility(View.VISIBLE);
               /*
               // Typeface myCustomFont = Typeface.createFromAsset(getAssets(), "fonts/" + getString(R.string.font_neue));
                textView.setTypeface(myCustomFont);
                textView.setTextColor(ContextCompat.getColor(this, color));*/
                }
            }
        }
    }

    public void setToolbarChildVisible(@NonNull View view, int a) {
        view.setVisibility(a);
    }

    public void setSearchHint(@NonNull EditText view, String text) {
        view.setHint(text);
        view.setText("");
    }

    public void setToolbarTitle(@NonNull TextView view, String s) {
        view.setText(s);
    }


    public void loadProgressBar(String title, String message, boolean cancellable) {
        if (!isFinishing()) {
            if (progressDialog == null)
                progressDialog = ProgressDialog.show(this, title, message, false, cancellable);
        }

    }

    public void dismissProgressBar() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        progressDialog = null;
    }

    public AlertDialog.Builder getAlertDialogBuilder(String title, String message, boolean cancellable) {
        return new AlertDialog.Builder(this, R.style.AppTheme_AlertDialog)
                .setTitle(title)
                .setMessage(message)
                .setCancelable(cancellable);

    }


    public void enableLoadingBar(boolean enable) {
        if (!isFinishing()) {
            if (enable) {
                loadProgressBar(null, getString(R.string.loading), false);
            } else {
                dismissProgressBar();
            }
        }
    }


    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onStart() {
        super.onStart();

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        permissionUtils.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


    @Override
    public void PermissionGranted(int request_code) {

    }

    @Override
    public void PartialPermissionGranted(int request_code, ArrayList<String> granted_permissions) {

    }

    @Override
    public void PermissionDenied(int request_code) {

    }

    @Override
    public void NeverAskAgain(int request_code) {
    }

    @Override
    public void onInfo(String message) {
        toast(message);
    }

    public void onError(String reason) {
        if (!isFinishing())
            onError(reason, false);
    }

    public void onError(String reason, final boolean finishOnOk) {
        if (StringUtility.validateString(reason)) {
            getAlertDialogBuilder(null, reason, false).setPositiveButton(getString(R.string.ok), finishOnOk ? new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            } : null).show();
        } else {
            getAlertDialogBuilder(null, getString(R.string.default_error), false)
                    .setPositiveButton(getString(R.string.ok), finishOnOk ? new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    } : null).show();
        }
    }


    @Override
    public void onForceUpdate() {

    }

    @Override
    public void onSoftUpdate() {

    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        permissionUtils = new PermissionUtils(this);
        ForceUpdateChecker.with(this).onUpdateNeeded(this).check();


    }


    private void getFcmId() {
        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if (!task.isSuccessful()) {
                            return;
                        }

                        // Get new Instance ID token
                        String token = task.getResult().getToken();

                        // Log and toast
                        String msg = getString(R.string.msg_token_fmt, token);
                        Toast.makeText(BaseActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });

    }


    @Override
    public void onUpdateNeeded(final String updateUrl) {
        AlertDialog dialog = new AlertDialog.Builder(this)
                //               .setTitle("Free trial expired")
                .setCancelable(false)
//                .setMessage("Free trial expired")
//                .setPositiveButton("Update",
//                        new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                redirectStore(updateUrl);
//                            }
//                        }).setNegativeButton("No, thanks",
//                        new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                finish();
//                            }
//                        })
                .create();

        dialog.show();
    }

    private void redirectStore(String updateUrl) {
        final Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(updateUrl));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }


}
