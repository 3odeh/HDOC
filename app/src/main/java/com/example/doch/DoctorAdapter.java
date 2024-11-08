package com.example.doch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DoctorAdapter extends BaseAdapter {

    private Context context;
    private List<Doctor> doctorList;

    public DoctorAdapter(Context context, List<Doctor> doctorList) {
        this.context = context;
        this.doctorList = doctorList;
    }

    @Override
    public int getCount() {
        return doctorList.size();
    }

    @Override
    public Object getItem(int position) {
        return doctorList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.doctor_card, parent,false);
        }

        Doctor doctor = doctorList.get(position);

        ImageView doctorImage = convertView.findViewById(R.id.doctor_image);
        TextView doctorName = convertView.findViewById(R.id.book_doctor_name);
        TextView doctorSpecialty = convertView.findViewById(R.id.book_doctor_specialty);
        TextView doctorLocation = convertView.findViewById(R.id.book_doctor_location);
        TextView doctorRating = convertView.findViewById(R.id.book_doctor_rating);

        doctorImage.setImageResource(doctor.getImageResourceId());
        doctorName.setText(doctor.getName());
        doctorSpecialty.setText(doctor.getSpecialty());
        doctorLocation.setText(doctor.getPlace());
        doctorRating.setText(doctor.getRating() + "");

        return convertView;
    }

}
