package com.mrbhartiya.education.ui.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.mrbhartiya.education.R;


public class PDFViewActivity extends BaseActivity {
    String url = "";
    String pdf = "http://www.adobe.com/devnet/acrobat/pdfs/pdf_open_parameters.pdf";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pdf_viewer);
        getIntentData();
        //displayFromAsset(url);
        pdf();
    }

    private void pdf() {
        WebView webview = (WebView) findViewById(R.id.web_view);
        WebSettings webSetting = webview.getSettings();
        webSetting.setBuiltInZoomControls(false);
        webview.setWebViewClient(new WebViewClient());
        webSetting.setJavaScriptEnabled(true);
        String myPdfUrl = "http://example.com/awesome.pdf";
        String path = "http://docs.google.com/gview?embedded=true&url=" + url;
        webview.loadUrl("javascript:(function() { " +
                "document.querySelector('[role=\"toolbar\"]').remove();})()");
        webview.loadUrl(path);
        webview.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
    }

    private void getIntentData() {
        url = getIntent().getExtras().getString("url");

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public class WebViewClient extends android.webkit.WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {

            // TODO Auto-generated method stub
            super.onPageStarted(view, url, favicon);
            view.loadUrl("javascript:(function() { " +
                    "document.querySelector('[role=\"toolbar\"]').remove();})()");
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            // TODO Auto-generated method stub
            view.loadUrl("javascript:(function() { " +
                    "document.querySelector('[role=\"toolbar\"]').remove();})()");
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {

            // TODO Auto-generated method stub

            super.onPageFinished(view, url);
            view.loadUrl("javascript:(function() { " +
                    "document.querySelector('[role=\"toolbar\"]').remove();})()");
        }
    }
}