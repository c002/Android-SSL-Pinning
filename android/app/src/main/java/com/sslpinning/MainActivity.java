package com.sslpinning;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.UiThread;
import android.util.Log;
import android.widget.Toast;

import com.facebook.react.modules.network.OkHttpClientProvider;
import okhttp3.OkHttpClient;
import com.facebook.react.ReactActivity;

public class MainActivity extends ReactActivity {

    private MainActivity instance;

    public Handler mHandler;

    /**
     * Returns the name of the main component registered from JavaScript.
     * This is used to schedule rendering of the component.
     */

    Handler messageHandler;
    private static String Tag = "Mainactivity";

    @Override
    protected String getMainComponentName() {
        return "sslPinning";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
        mHandler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message message) {
                super.handleMessage(message);
                // This is where you do your work in the UI thread.
                // Your worker tells you in the message what to do.
                Log.v(Tag, "In ui thread" + message);
                if (message.what == 0 ){
                    Toast.makeText(instance.getApplicationContext(), "Certificate pinning failed. Please call your administrator.", Toast.LENGTH_LONG ).show();
                }
            }
        };
        OkHttpClientProvider.setOkHttpClientFactory(new OkHttpCertPin(this));


    }
}
