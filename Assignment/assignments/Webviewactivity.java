package com.example.assignments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.example.assignments.databinding.ActivityWebviewactivityBinding;

public class Webviewactivity extends AppCompatActivity {

    ActivityWebviewactivityBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityWebviewactivityBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);


        binding.webview.getSettings().setJavaScriptEnabled(true);
        binding.webview.setWebViewClient(new WebViewClient());

        binding.webview.loadUrl("https://www.google.com");

        if (!AvailibilityOfInternet()){
            Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show();
            return;
        }
        binding.webview.setWebViewClient(new WebViewClient(){
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                Toast.makeText(Webviewactivity.this, "Error Loading Page", Toast.LENGTH_SHORT).show();
            }
        });


        // Back button click

        binding.buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.webview.canGoBack());
                binding.webview.goBack();
            }
        });
        // Forward button click
        binding.buttonForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.webview.canGoForward()){
                    binding.webview.goForward();
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (binding.webview.canGoBack()){
            binding.webview.goBack();
        }
        else
        {
            super.onBackPressed();
        }
    }
    private boolean AvailibilityOfInternet(){
        ConnectivityManager c=(ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=c.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();

    }
}