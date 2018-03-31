package com.sslpinning;

import android.util.Log;

import java.io.IOException;

import javax.net.ssl.SSLPeerUnverifiedException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class PinningInterceptor implements Interceptor {
    private static final String TAG = "logging";
    private static String sslPinning;
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
            }
            throw e;
        }
    }

}
