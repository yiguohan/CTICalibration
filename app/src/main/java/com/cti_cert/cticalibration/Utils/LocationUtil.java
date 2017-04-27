package com.cti_cert.cticalibration.Utils;

import android.util.Log;

import com.amap.api.location.AMapLocation;

/**
 * Created by yiguo on 2017/4/27.
 * Email:yiguohan@gmail.com
 */

public class LocationUtil {

    public static String parseLoaction(AMapLocation location) {
        StringBuilder info = new StringBuilder();
        if (location != null) {
            if (location.getErrorCode() == 0) {
                info.append(location.getCountry())
                        .append(location.getProvince())
                        .append(location.getCity())
                        .append(location.getDistrict())
                        .append(location.getStreet())
                        .append(location.getStreetNum())
                        .append(location.getAoiName())
                        .append(location.getFloor())
                        .append(location.getBuildingId());
            } else {
                Log.e("AMapError", "parseLoaction: locationErrorCode:" + location.getErrorCode() + ",errorInfo" + location.getErrorInfo());
            }
        }
        return info.toString();
    }
}
