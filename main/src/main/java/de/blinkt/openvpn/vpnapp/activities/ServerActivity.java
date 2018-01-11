/*
 * Copyright (c) 2012-2018 Arne Schwabe
 * Distributed under the GNU GPL v2 with additional terms. For full terms see the file doc/LICENSE.txt
 */

package de.blinkt.openvpn.vpnapp.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import de.blinkt.openvpn.R;

/**
 * Created by hackett001 on 08.01.18.
 */

public class ServerListActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serverlist);


    }
}
