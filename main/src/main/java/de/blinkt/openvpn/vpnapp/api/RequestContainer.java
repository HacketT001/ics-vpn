/*
 * Copyright (c) 2012-2018 Arne Schwabe
 * Distributed under the GNU GPL v2 with additional terms. For full terms see the file doc/LICENSE.txt
 */

package de.blinkt.openvpn.vpnapp;

import java.util.List;

import de.blinkt.openvpn.vpnapp.models.Server;
import de.blinkt.openvpn.vpnapp.models.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by hackett001 on 06.01.18.
 */

public interface RequestContainer {

    @POST("/api/login")
    Call<User> authenticate(@Query("token") String authKey);

    @POST("/api/logout")
    Call<Void> logout();

    @GET("/api/servers")
    Call<List<Server>> getServers(@Header("Authorization") String serverKey);

}
