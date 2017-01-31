package com.adurand.nativeapplication.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adurand.nativeapplication.R;

/**
 * Created by adurand on 31/01/17.
 */

public class MagazineFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.magazine_view, container, false);
    }
}

