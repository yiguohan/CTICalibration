package com.cti_cert.cticalibration.Utils;

import com.cti_cert.cticalibration.Beans.Attendance;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


/**
 * Created by yiguo on 2017/4/25.
 * Email:yiguohan@gmail.com
 */

public class DataUtil {

    public static void initAttendanceData(List<Attendance> list) {
        Calendar calendar = Calendar.getInstance();
        String date = calendar.get(Calendar.YEAR) + "年" + (calendar.get(Calendar.MONTH) + 1) + "月" + calendar.get(Calendar.DATE) + "日";
        String time = calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND);
        String type = "上班打卡";
        if (list.size() > 0) {
            list.clear();
        }
        for (int i = 0; i < 50; i++) {
            list.add(new Attendance(date, time, type));
            if (type.equals("上班打卡")) {
                type = "下班打卡";
            } else {
                type = "上班打卡";
            }
        }
    }
}
