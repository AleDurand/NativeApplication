package com.adurand.nativeapplication.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.adurand.nativeapplication.R;
import com.adurand.nativeapplication.adapters.MagazineAdapter;
import com.adurand.nativeapplication.models.MagazineModel;
import com.adurand.nativeapplication.services.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by adurand on 31/01/17.
 */

public class MagazineListActivity extends AppCompatActivity {

    private MagazineAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magazine_list);

        adapter = new MagazineAdapter(this, new ArrayList<MagazineModel>());
        ListView listView = (ListView) findViewById(R.id.magazine_lists_list);
        listView.setAdapter(adapter);
        refresh();
    }

    private void refresh() {
        Call<List<MagazineModel>> call = ApiClient.getApi().getMagazines();
        call.enqueue(new Callback<List<MagazineModel>>() {
            @Override
            public void onFailure(Call<List<MagazineModel>> call, Throwable t) {
                Log.d(MagazineListActivity.class.getName(), "Error occured: " + t.getMessage());
            }

            @Override
            public void onResponse(Call<List<MagazineModel>> call, Response<List<MagazineModel>> response) {
                adapter.clear();
                adapter.addAll(response.body());
            }
        });
    }
}
