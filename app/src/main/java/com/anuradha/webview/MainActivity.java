package com.anuradha.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        //to load clicked links on the app itself instead of loading in the browser
        portfolio_webview.setWebViewClient(new WebViewClient());
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
