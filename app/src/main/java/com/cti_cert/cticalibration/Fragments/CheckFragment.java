package com.cti_cert.cticalibration.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.SupportMapFragment;
import com.amap.api.maps.model.MyLocationStyle;
import com.cti_cert.cticalibration.R;
import com.cti_cert.cticalibration.Utils.LocationUtil;


/**
 * A simple {@link Fragment} subclass.
 */
public class CheckFragment extends Fragment {

    private static final String TAG = "CheckFragment";

    private AMap aMap;

    private SupportMapFragment mapFragment;

    private Button btn_Check;

    private AMapLocationClient mLocationClient;

    private TextView locationInfo;

    public CheckFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: execute");
        View view = inflater.inflate(R.layout.fragment_check, container, false);
        btn_Check = (Button) view.findViewById(R.id.attendance_check);
        btn_Check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "已签到", Toast.LENGTH_SHORT).show();
            }
        });
        locationInfo = (TextView) view.findViewById(R.id.loacationInfo);
        setUpLocationClient();
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
        Log.d(TAG, "onDestroyView: execute");
        mLocationClient.stopLocation();
        mLocationClient.onDestroy();
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
        MyLocationStyle myLocationStyle = new MyLocationStyle();
        myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_FOLLOW);
        myLocationStyle.interval(2000);
        aMap.setMyLocationStyle(myLocationStyle);
        aMap.setMyLocationEnabled(true);

    }

    /*初始化AMapLocationClient对象*/
    private void setUpLocationClient() {

        mLocationClient = new AMapLocationClient(getContext());
        mLocationClient.setLocationListener(new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation aMapLocation) {
                String info = LocationUtil.parseLoaction(aMapLocation);
                if (TextUtils.isEmpty(info)) {
                    Toast.makeText(getContext(), "解析地理信息异常", Toast.LENGTH_SHORT).show();
                    return;
                }
                locationInfo.setText(info);
            }
        });

        AMapLocationClientOption mLocationOption = new AMapLocationClientOption();
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy)
                .setInterval(2000)
                .setNeedAddress(true)
                .setWifiScan(false);
        mLocationClient.setLocationOption(mLocationOption);
        mLocationClient.startLocation();


    }

}
