package com.sslpinning;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.UiThread;
import android.util.Log;
import android.widget.Toast;

import com.facebook.react.modules.network.OkHttpClientProvider;
import okhttp3.OkHttpClient;
import com.facebook.react.ReactActivity;

public class MainActivity extends ReactActivity {

    private MainApplication instance;
    /**
     * Returns the name of the main component registered from JavaScript.
     * This is used to schedule rendering of the component.
     */

    Handler messageHandler;
    private static String Tag;

    @Override
    protected String getMainComponentName() {
        return "sslPinning";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OkHttpClientProvider.setOkHttpClientFactory(new OkHttpCertPin());
//        messageHandler = new Handler() {
//            public void handleMessage(android.os.Message msg) {
//                super.handleMessage(msg);
//                Toast.makeText(getApplicationContext(), "DISPLAY MESSAGE", Toast.LENGTH_SHORT).show();
//            }
//        };
    }
}
