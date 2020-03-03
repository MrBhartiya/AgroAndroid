package com.mrbhartiya.education.ui.fragments;

import android.Manifest;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.mrbhartiya.education.R;
import com.mrbhartiya.education.utility.StringUtility;


/**
 * Created by Radha Soni on 02/22/2019
 */

public class BaseFragment extends Fragment {

    private ProgressDialog progressDialog;


    public BaseFragment() {
        // Required empty radio_uncheck constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public String tag() {
        return getClass().getSimpleName();
    }

    public void log(String message) {
        Log.d(tag(), message);
    }

    public void toast(final String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    public void loadProgressBar(String title, String message, boolean cancellable) {
        if (progressDialog == null)
            progressDialog = ProgressDialog.show(getActivity(), title, message, false, cancellable);
    }

    public void dismissProgressBar() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        progressDialog = null;
    }

    public AlertDialog.Builder getAlertDialogBuilder(String title, String message, boolean cancellable) {
        return new AlertDialog.Builder(getActivity(), R.style.AppTheme_AlertDialog)
                .setTitle(title)
                .setMessage(message)
                .setCancelable(cancellable);

    }

    public AlertDialog.Builder getHintDialogBuilder(String title, String message, boolean cancellable) {
        return new AlertDialog.Builder(getActivity(), R.style.AppTheme_AlertDialog)
                .setTitle(title)
                .setMessage(message)
                .setCancelable(cancellable).setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

    }

    public void enableLoadingBar(boolean enable) {
        if (enable) {
            loadProgressBar(null, getString(R.string.loading), false);
        } else {
            dismissProgressBar();
        }
    }

    public void onError(String reason) {
        if (getActivity() != null && isAdded())
            onError(reason, false);
    }

    public void onError(String reason, final boolean finishOnOk) {
        if (StringUtility.validateString(reason)) {
            getAlertDialogBuilder(null, reason, false).setPositiveButton(getString(R.string.ok), finishOnOk ? new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    getActivity().finish();
                }
            } : null).show();
        } else {
            getAlertDialogBuilder(null, getString(R.string.default_error), false)
                    .setPositiveButton(getString(R.string.ok), finishOnOk ? new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            getActivity().finish();
                        }
                    } : null).show();
        }
    }

    public void onInfo(String message) {
        onInfo(message, false);
    }

    public void onInfo(String message, boolean finishOnOk) {
        getAlertDialogBuilder(null, message, false).setPositiveButton(getString(R.string.ok), finishOnOk ? new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                getActivity().finish();
            }
        } : null).show();
    }


    public void onSoftUpdate() {
    }
//
//    /*Pass null errorMessage to disable error view*/
//    public void setFieldError(TextInputLayout tilField, String errorMessage) {
//        if (tilField != null) {
//            if (StringUtility.validateString(errorMessage)) {
//                tilField.setError(errorMessage);
//            } else {
//                tilField.setErrorEnabled(false);
//            }
//        }
//    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }
}
