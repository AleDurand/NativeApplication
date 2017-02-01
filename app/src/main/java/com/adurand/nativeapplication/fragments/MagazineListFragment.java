package com.adurand.nativeapplication.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class MagazineListFragment extends Fragment {

    private List<MagazineModel> magazines = new ArrayList<>();
    private MagazineAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_magazine_list, container, false);

        adapter = new MagazineAdapter(rootView.getContext(), this.magazines);
        ListView listView = (ListView) rootView.findViewById(R.id.magazine_lists_list);
        listView.setAdapter(adapter);
        refresh();

        return rootView;
    }

    private void refresh() {
        Call<List<MagazineModel>> call = ApiClient.getApi().getMagazines();
        call.enqueue(new Callback<List<MagazineModel>>() {
            @Override
            public void onFailure(Call<List<MagazineModel>> call, Throwable t) {
                Log.d(MagazineListFragment.class.getName(), "Error occured: " + t.getMessage());
            }

            @Override
            public void onResponse(Call<List<MagazineModel>> call, Response<List<MagazineModel>> response) {
                adapter.clear();
                adapter.addAll(response.body());
            }
        });
    }
}
