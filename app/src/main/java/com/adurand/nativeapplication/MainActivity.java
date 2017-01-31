package com.adurand.nativeapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.adurand.nativeapplication.models.MagazineModel;
import com.adurand.nativeapplication.services.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private List<MagazineModel> magazines;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.textView = (TextView) findViewById(R.id.tv_text);
    }

    @Override
    protected void onStart() {
        super.onStart();
        getMagazines();
    }

    private void getMagazines() {
        Call<List<MagazineModel>> call = ApiClient.getApi().getMagazines();
        call.enqueue(new Callback<List<MagazineModel>>() {
            @Override
            public void onFailure(Call<List<MagazineModel>> call, Throwable t) {
                Log.d("APIPlug", "Error Occured: " + t.getMessage());
            }

            @Override
            public void onResponse(Call<List<MagazineModel>> call, Response<List<MagazineModel>> response) {
                Log.d("APIPlug", "Successfully response fetched" );
                magazines = response.body();
                textView.setText(magazines.get(0).getDescription());
            }
        });
    }
}
