package com.sslpinning;

import android.app.Activity;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;

public class CrashApplication extends Activity {
    private static String Tag = "myactivity";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(Tag, "CrashApplication");
    }
}
