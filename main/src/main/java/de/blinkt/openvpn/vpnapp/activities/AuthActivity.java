/*
 * Copyright (c) 2012-2018 Arne Schwabe
 * Distributed under the GNU GPL v2 with additional terms. For full terms see the file doc/LICENSE.txt
 */

package de.blinkt.openvpn.vpnapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import de.blinkt.openvpn.R;
import de.blinkt.openvpn.vpnapp.models.Server;
import de.blinkt.openvpn.vpnapp.models.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hackett001 on 05.01.18.
 */

public class AuthActivity extends Activity {
    private static final String BASE_URL = "http://ec2-52-15-213-216.us-east-2.compute.amazonaws.com:8282";
    private Button button;
    private Retrofit retrofit;
    private RequestContainer requestContainer;
    private TextView responseField;
    private EditText tokenID;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentificate);


        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        requestContainer = retrofit.create(RequestContainer.class);

        tokenID = findViewById(R.id.token_et);
        button = findViewById(R.id.request_button);
        responseField = findViewById(R.id.body_request);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<User> userCall = requestContainer.authenticate(tokenID.getText().toString());
                userCall.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if (response.body()!=null)
                            responseField.setText(response.body().toString());
                        else Toast.makeText(AuthActivity.this, "Authentification error", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable throwable) {
                        Toast.makeText(AuthActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                    }
                });

                Call<List<Server>> serversCall = requestContainer.getServers("VPN tokajebhdgasdjfasd;lfasdf");
                serversCall.enqueue(new Callback<List<Server>>() {
                    @Override
                    public void onResponse(Call<List<Server>> call, Response<List<Server>> response) {
                        responseField.append("\n"+response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<List<Server>> call, Throwable throwable) {

                    }
                });

            }
        });



    }
}
