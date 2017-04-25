package com.cti_cert.cticalibration.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cti_cert.cticalibration.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class QRScanFragment extends Fragment {


    public QRScanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_qrscan, container, false);
    }

}
