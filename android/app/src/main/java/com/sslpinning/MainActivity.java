package com.sslpinning;

import android.os.Bundle;

import com.facebook.react.modules.network.OkHttpClientProvider;
import okhttp3.OkHttpClient;
import com.facebook.react.ReactActivity;

public class MainActivity extends ReactActivity {

    /**
     * Returns the name of the main component registered from JavaScript.
     * This is used to schedule rendering of the component.
     */
    @Override
    protected String getMainComponentName() {
        return "sslPinning";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OkHttpClientProvider.setOkHttpClientFactory(new OkHttpCertPin());
    }
}
