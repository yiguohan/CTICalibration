package com.cti_cert.cticalibration.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cti_cert.cticalibration.Adapters.AttendanceAdapter;
import com.cti_cert.cticalibration.Beans.Attendance;
import com.cti_cert.cticalibration.R;
import com.cti_cert.cticalibration.Utils.DataUtil;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class AttendanceRecordFragment extends Fragment {

    private SwipeRefreshLayout swipeRefreshLayout;

    private AttendanceAdapter attendanceAdapter;

    private List<Attendance> attendanceList;

    public AttendanceRecordFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        attendanceList = new ArrayList<Attendance>();
        DataUtil.initAttendanceData(attendanceList);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_attendancerecord, container, false);

        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.attendance_swipeRefresh);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshAttendance();
            }
        });

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.attendance_recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        attendanceAdapter = new AttendanceAdapter(attendanceList);
        recyclerView.setAdapter(attendanceAdapter);
        return view;
    }

    private void refreshAttendance() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        DataUtil.initAttendanceData(attendanceList);
                        attendanceAdapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                });

            }
        }).start();

    }

}
