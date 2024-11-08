package com.example.doch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataSource {
    private static List<Doctor> doctors = new ArrayList<>();
    private static List<Appointment> appointments = new ArrayList<>();

    static {

        List<String> timeSlots1 = Arrays.asList("9:00 AM", "10:00 AM", "11:00 AM");
        List<String> timeSlots2 = Arrays.asList("1:00 PM", "2:00 PM", "3:00 PM");
        List<String> timeSlots3 = Arrays.asList("4:00 PM", "5:00 PM", "6:00 PM");
        List<String> timeSlots4 = Arrays.asList("2:00 PM", "3:00 PM", "7:00 PM");

        doctors.add(new Doctor("Dr. Abdallah Odeh", 5f, "Cardiology", "Ramallah", R.drawable.doctor_background, R.drawable.doctor, timeSlots1));
        doctors.add(new Doctor("Dr. Mahdi Mohammad", 4.8f, "Neurology", "Jenin", R.drawable.doctor_background, R.drawable.doctor, timeSlots2));
        doctors.add(new Doctor("Dr. Mohammad Khaled", 4.7f, "Pediatrics", "Gaza", R.drawable.doctor_background, R.drawable.doctor, timeSlots3));
        doctors.add(new Doctor("Dr. Khalil Khaled", 4.2f, "Cardiology", "Tulkarm", R.drawable.doctor_background, R.drawable.doctor, timeSlots4));

        appointments.add(new Appointment(
                getDoctor(0),
                "9:00 AM - 10:00 AM",
                "Online",
                true,
                false,
                "Regular check-up"
        ));

        appointments.add(new Appointment(
                getDoctor(0),
                "10:00 AM - 11:00 AM",
                "In-person",
                false,
                true,
                "Follow-up after surgery"
        ));

        appointments.add(new Appointment(
                getDoctor(1),
                "1:00 PM - 2:00 PM",
                "Online",
                true,
                true,
                "Discuss lab test results"
        ));

        appointments.add(new Appointment(
                getDoctor(3),
                "3:00 PM - 4:00 PM",
                "In-person",
                false,
                false,
                "Consultation for a second opinion"
        ));
    }

    public static List<Doctor> getAllDoctors() {
        return doctors;
    }

    public static Doctor getDoctor(int id) {
        return getAllDoctors().get(id);
    }

    public static List<Appointment> getAllAppointments() {
        return appointments;
    }

    public static void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public static int addAppointmentsCount() {
        return appointments.size();
    }
}
