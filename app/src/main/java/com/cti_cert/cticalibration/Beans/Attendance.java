package com.cti_cert.cticalibration.Beans;

/**
 * Created by yiguo on 2017/4/25.
 * Email:yiguohan@gmail.com
 */

public class Attendance {
    String date;
    String time;
    String type;

    public Attendance() {
    }

    public Attendance(String date, String time, String type) {
        this.date = date;
        this.time = time;
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
