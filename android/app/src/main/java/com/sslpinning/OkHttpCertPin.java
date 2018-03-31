package com.sslpinning;

import com.facebook.react.modules.network.OkHttpClientFactory;
import com.facebook.react.modules.network.OkHttpClientProvider;
import com.facebook.react.modules.network.ReactCookieJarContainer;
import java.util.concurrent.TimeUnit;
import okhttp3.CertificatePinner;
import okhttp3.OkHttpClient;
public class OkHttpCertPin implements OkHttpClientFactory {
    private static String hostname = "wwwqa.ayco.com";
    @Override
    public OkHttpClient createNewNetworkModuleClient() {
        CertificatePinner certificatePinner = new CertificatePinner.Builder()
                .add(hostname, "sha256/RIOrFUuuh7vKQH8t+/HA9a4OOrNzuMlis+ROKAskIeY=")
                .add(hostname, "sha256/fb0Tfqir1HP3KpDb+G45zaPKd4IMWkZQgeiSsLeH8tk=")
                .add(hostname, "sha256/lnsM2T/O9/J84sJFdnrpsFp3awZJ+ZZbYpCWhGloaHI=")
                .build();
        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .connectTimeout(0, TimeUnit.MILLISECONDS)
                .readTimeout(0, TimeUnit.MILLISECONDS)
                .writeTimeout(0, TimeUnit.MILLISECONDS)
                .cookieJar(new ReactCookieJarContainer())
                .addInterceptor(new PinningInterceptor())
                .certificatePinner(certificatePinner);
        return OkHttpClientProvider.enableTls12OnPreLollipop(client).build();
    }
}