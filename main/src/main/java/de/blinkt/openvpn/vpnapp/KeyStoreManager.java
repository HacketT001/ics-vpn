/*
 * Copyright (c) 2012-2018 Arne Schwabe
 * Distributed under the GNU GPL v2 with additional terms. For full terms see the file doc/LICENSE.txt
 */

package de.blinkt.openvpn.vpnapp.api;

import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

/**
 * Created by hackett001 on 12.01.18.
 */

public class KeyStoreManager {

    private static final String AndroidKeyStore = "AndroidKeyStore";
    private static final String AES_MODE = "AES/GCM/NoPadding";

    private KeyStore keyStore;

    public KeyStoreManager(){
        try {

            keyStore = KeyStore.getInstance(AndroidKeyStore);
            keyStore.load(null);
                

        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
