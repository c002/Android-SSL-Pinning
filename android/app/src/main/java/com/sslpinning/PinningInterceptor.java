package com.sslpinning;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;

import javax.net.ssl.SSLPeerUnverifiedException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import com.sslpinning.MainActivity;

public class PinningInterceptor implements Interceptor {
    private static final String TAG = "logging";
    private static String sslPinning;
    private MainActivity instance;
    @Override public Response intercept(Interceptor.Chain chain) throws IOException {
        try{
            Request request = chain.request();
            Response response = chain.proceed(request);
            return response;
        }catch(SSLPeerUnverifiedException e){
            sslPinning = e.getMessage();
            Log.v(TAG, "SSL Error" + sslPinning);
            if (sslPinning.contains("Certificate pinning failure!")){
                Log.v(TAG, "Crash application");
                if(instance == null){
                    throw e;
                }
            }
            throw e;
        }
    }

}
