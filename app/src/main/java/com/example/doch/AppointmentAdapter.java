package com.example.doch;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AppointmentAdapter extends BaseAdapter {
    private Context context;
    private List<Appointment> appointments;

    public AppointmentAdapter(Context context, List<Appointment> appointments) {
        this.context = context;
        this.appointments = appointments;
    }

    @Override
    public int getCount() {
        return appointments.size();
    }

    @Override
    public Object getItem(int position) {
        return appointments.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.appointment_list_item, parent, false);
        }

        Appointment appointment = appointments.get(position);

        ImageView doctorImage = convertView.findViewById(R.id.appointment_item_doctor_image);
        TextView doctorName = convertView.findViewById(R.id.appointment_doctor_name);
        TextView doctorPlace = convertView.findViewById(R.id.appointment_item_place_text);
        TextView timeSlot = convertView.findViewById(R.id.appointment_item_time_slot);
        TextView consultationType = convertView.findViewById(R.id.appointment_item_consultation_type);
        CheckBox medicalReport = convertView.findViewById(R.id.appointment_item_medical_report);
        CheckBox labTests = convertView.findViewById(R.id.appointment_item_lab_tests);
        TextView patientDescription = convertView.findViewById(R.id.appointment_item_patient_description);

        doctorImage.setImageResource(appointment.getDoctorName().getImageResourceId());
        doctorName.setText(appointment.getDoctorName().getName());
        doctorPlace.setText(appointment.getDoctorName().getPlace());
        timeSlot.setText("Time: " + appointment.getTimeSlot());
        consultationType.setText("Type: " + appointment.getConsultationType());
        medicalReport.setChecked(appointment.isMedicalReport());
        labTests.setChecked(appointment.isLabTests());
        patientDescription.setText(appointment.getPatientDescription());

        return convertView;
    }
}
