package com.seyir.tcellapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.seyir.tcellapi.models.DeviceSearch;
import com.seyir.tcellapi.models.ResponseError;
import com.seyir.tcellapi.models.ResponseSuccess;
import com.seyir.tcellapi.rest.APIModule;
import com.seyir.tcellapi.rest.TCellAPI;
import com.seyir.tcellapi.utils.ErrorUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText etTo = (EditText) findViewById(R.id.etTo);
        final EditText etContent = (EditText) findViewById(R.id.etContent);

        Button btnSend = (Button) findViewById(R.id.btnSend);
        Button btnCall = (Button) findViewById(R.id.btnCall);
        Button btnSearch = (Button) findViewById(R.id.btnSearch);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendSmsTask(etTo.getText().toString().trim(), etContent.getText().toString().trim());
            }
        });

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeCallTask(etTo.getText().toString().trim(), etContent.getText().toString().trim());
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                searchDeviceTask();
            }
        });

    }

    private void sendSmsTask(String to, String content) {

        TCellAPI apiService = APIModule.connectTcellAPI().create(TCellAPI.class);

        Call<ResponseSuccess> call = apiService.sendSMS("buraya sms için aldığınız api_key", "buraya cep numaranız", to, content);
        call.enqueue(new Callback<ResponseSuccess>() {
            @Override
            public void onResponse(Call<ResponseSuccess> call, Response<ResponseSuccess> response) {

                if (response.isSuccessful()) {
                    String res = "SMS GÖNDERİLDi\n" + response.body().getInDate().getLocalTime();
                    Toast.makeText(getApplicationContext(), res, Toast.LENGTH_LONG).show();

                } else {

                    ResponseError error = ErrorUtils.parseError(response);
                    Toast.makeText(getApplicationContext(), response.code() + "\n" + error.getMessage(), Toast.LENGTH_LONG).show();

                }

            }

            @Override
            public void onFailure(Call<ResponseSuccess> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getLocalizedMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }

    private void makeCallTask(String to, String content) {

        TCellAPI apiService = APIModule.connectTcellAPI().create(TCellAPI.class);

        Call<ResponseSuccess> call = apiService.makeCall("buraya çağrı için aldığınız api_key", "buraya cep numaranız", to, content);
        call.enqueue(new Callback<ResponseSuccess>() {
            @Override
            public void onResponse(Call<ResponseSuccess> call, Response<ResponseSuccess> response) {

                if (response.isSuccessful()) {
                    String res = "ARAMA YAPILDI\n" + response.body().getInDate().getLocalTime();
                    Toast.makeText(getApplicationContext(), res, Toast.LENGTH_LONG).show();

                } else {

                    ResponseError error = ErrorUtils.parseError(response);
                    Toast.makeText(getApplicationContext(), response.code() + "\n" + error.getMessage(), Toast.LENGTH_LONG).show();

                }

            }

            @Override
            public void onFailure(Call<ResponseSuccess> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getLocalizedMessage(), Toast.LENGTH_LONG).show();

            }
        });

    }

    private void searchDeviceTask() {

        TCellAPI apiService = APIModule.connectTcellAPI().create(TCellAPI.class);

        Call<ResponseSuccess> call = apiService.searchDevice("buraya cihaz için aldığınız api_key", "buraya cep numaranız", 155);
        call.enqueue(new Callback<ResponseSuccess>() {
            @Override
            public void onResponse(Call<ResponseSuccess> call, Response<ResponseSuccess> response) {

                if (response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), response.body().getTicketId(), Toast.LENGTH_LONG).show();

                    getDeviceDetailsTask(response.body().getTicketId());


                } else {

                    ResponseError error = ErrorUtils.parseError(response);
                    Toast.makeText(getApplicationContext(), response.code() + "\n" + error.getMessage(), Toast.LENGTH_LONG).show();

                }

            }

            @Override
            public void onFailure(Call<ResponseSuccess> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getLocalizedMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }

    private void getDeviceDetailsTask(String tickedId) {

        TCellAPI apiService = APIModule.connectTcellAPI().create(TCellAPI.class);
        Call<DeviceSearch> call = apiService.getDeviceDetails("buraya cihaz için aldığınız api_key", tickedId);
        call.enqueue(new Callback<DeviceSearch>() {
            @Override
            public void onResponse(Call<DeviceSearch> call, Response<DeviceSearch> response) {

                if (response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), response.body().getDetail().getDeviceInfo().get(0).getDeviceBrand(), Toast.LENGTH_LONG).show();
                } else {

                    ResponseError error = ErrorUtils.parseError(response);
                    Toast.makeText(getApplicationContext(), response.code() + "\n" + error.getMessage(), Toast.LENGTH_LONG).show();

                }

            }

            @Override
            public void onFailure(Call<DeviceSearch> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getLocalizedMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }

}
