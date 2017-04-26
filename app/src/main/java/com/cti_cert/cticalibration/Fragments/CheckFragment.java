package com.cti_cert.cticalibration.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amap.api.maps.AMap;
import com.amap.api.maps.SupportMapFragment;
import com.cti_cert.cticalibration.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class CheckFragment extends Fragment {

    private AMap aMap;

    private SupportMapFragment mapFragment;


    public CheckFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_check, container, false);
        setUpMap();
        return view;
    }

    /*释放mapFragment。需要先从父级fragment中移除，否则重新加载onCreateView时会抛异常*/
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mapFragment != null) {
            getChildFragmentManager().beginTransaction().remove(mapFragment).commitAllowingStateLoss();
        }
        mapFragment = null;
        aMap = null;
    }

    /*初始化AMAP对象*/
    private void setUpMap() {
        if (mapFragment == null) {
            mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        }
        if (aMap == null) {
            aMap = mapFragment.getMap();
        }
    }

}
