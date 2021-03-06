package com.cks.netty.https;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;

/**
 * @Author: cks
 * @Date: Created by 下午14:35 2018/2/27
 * @Package: com.cks.netty.https
 * @Description: SSLContext
 */
public class SSLContextFactory {

    public static SSLContext getContext() {
        FileInputStream fis = null;
        SSLContext sslContext;
        try {
            sslContext = SSLContext.getInstance("TLSv1");
            KeyStore ks = KeyStore.getInstance("JKS");
            char[] password = "123456".toCharArray();
            fis = new FileInputStream("E:\\cks.jks");
            ks.load(fis, password);
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(ks, "123456".toCharArray());
            sslContext.init(keyManagerFactory.getKeyManagers(), null, null);
            return sslContext;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
