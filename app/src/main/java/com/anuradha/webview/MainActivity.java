package com.anuradha.webview;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    WebView portfolio_webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        portfolio_webview = (WebView) findViewById(R.id.portfolio_webview);
        WebSettings webSettings = portfolio_webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        portfolio_webview.loadUrl("https://anoo-radha.github.io/");
        //force-load clicked links on the app's webview itself instead of loading in the browser
        portfolio_webview.setWebViewClient(new MyClient());
        //improve webview performance
        portfolio_webview.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        portfolio_webview.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        portfolio_webview.getSettings().setAppCacheEnabled(true);
        portfolio_webview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSettings.setUseWideViewPort(true);
        webSettings.setSavePassword(true);
        webSettings.setSaveFormData(true);
        webSettings.setEnableSmoothTransition(true);
    }

    private class MyClient extends WebViewClient {
        ProgressDialog pd = null;

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            pd=new ProgressDialog(MainActivity.this);
            pd.setTitle("Please Wait..");
            pd.setMessage("Website is Loading..");
            pd.show();
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            pd.dismiss();
            super.onPageFinished(view, url);
        }
    }

    @Override
    public void onBackPressed() {
        if(portfolio_webview.canGoBack()){
            portfolio_webview.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
