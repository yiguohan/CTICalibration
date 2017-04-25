package com.cti_cert.cticalibration.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.util.Util;
import com.cti_cert.cticalibration.Adapters.AttendanceAdapter;
import com.cti_cert.cticalibration.Beans.Attendance;
import com.cti_cert.cticalibration.R;
import com.cti_cert.cticalibration.Utils.DataUtil;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class AttendanceFragment extends Fragment {


    public AttendanceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_attendance, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.attendance_recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        AttendanceAdapter attendanceAdapter = new AttendanceAdapter(DataUtil.initAttendanceData());
        recyclerView.setAdapter(attendanceAdapter);
        return view;
    }

}
