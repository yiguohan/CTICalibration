package com.cti_cert.cticalibration.Utils;

import com.cti_cert.cticalibration.Beans.Attendance;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;

/**
 * Created by yiguo on 2017/4/25.
 * Email:yiguohan@gmail.com
 */

public class DataUtil {

    public static List<Attendance> initAttendanceData() {
        List<Attendance> list = new ArrayList<Attendance>();
        Calendar calendar = Calendar.getInstance();
        String date = calendar.get(Calendar.YEAR) + "年" + (calendar.get(Calendar.MONTH) + 1) + "月" + calendar.get(Calendar.DATE) + "日";
        String time = calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND);
        for (int i = 0; i < 50; i++) {
            list.add(new Attendance(date, time, "上班打卡"));
        }
        return list;
    }
}
