package com.cti_cert.cticalibration.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cti_cert.cticalibration.Beans.Attendance;
import com.cti_cert.cticalibration.R;

import java.util.List;

/**
 * Created by yiguo on 2017/4/25.
 * Email:yiguohan@gmail.com
 */

public class AttendanceAdapter extends RecyclerView.Adapter<AttendanceAdapter.ViewHolder> {
    List<Attendance> attendanceList;

    public AttendanceAdapter(List<Attendance> attendanceList) {
        this.attendanceList = attendanceList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.attendance_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.typeText.setText(attendanceList.get(position).getType());
        holder.dateText.setText(attendanceList.get(position).getDate());
        holder.timeText.setText(attendanceList.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        return attendanceList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView dateText;
        TextView timeText;
        TextView typeText;

        public ViewHolder(View view) {
            super(view);
            dateText = (TextView) view.findViewById(R.id.attendance_date);
            timeText = (TextView) view.findViewById(R.id.attendance_time);
            typeText = (TextView) view.findViewById(R.id.attendance_type);
        }


    }
}
