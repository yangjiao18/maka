package com.example.maka.Controller;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import com.company.TestLogger;


public class Test {
    private static TestLogger logger = TestLogger.getLogger(TrustSSL.class);

    private static class TrustAnyTrustManager implements X509TrustManager {

        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[] {};
        }
    }

    private static class TrustAnyHostnameVerifier implements HostnameVerifier {
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }

    public static String sendHttps(String url) throws Exception {
        InputStream in = null;
        OutputStream out = null;
        String returnValue = "";
        try {
            //SSLContext sc = SSLContext.getInstance("SSL");
            System.setProperty("https.protocols", "TLSv1");
            SSLContext sc = SSLContext.getInstance("TLSv1");
            sc.init(null, new TrustManager[] { new TrustAnyTrustManager() }, new java.security.SecureRandom());
            URL console = new URL(url);
            HttpsURLConnection conn = (HttpsURLConnection) console.openConnection();
            conn.setSSLSocketFactory(sc.getSocketFactory());
            conn.setHostnameVerifier(new TrustAnyHostnameVerifier());
            conn.connect();
            InputStream is = conn.getInputStream();
            DataInputStream indata = new DataInputStream(is);
            returnValue = indata.readLine();
            conn.disconnect();
        } catch (ConnectException e) {
            logger.logError(e.getMessage());
            logger.logError(e);
            throw e;

        } catch (IOException e) {
            logger.logError(e.getMessage());
            logger.logError(e);
            throw e;
        } finally {
            try {
                in.close();
            } catch (Exception e) {
            }
            try {
                out.close();
            } catch (Exception e) {
            }
        }
        return returnValue;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(sendHttps("https://test.com/get.do"));
    }
}