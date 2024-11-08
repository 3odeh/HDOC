package com.example.doch;

public class Appointment {
    private Doctor doctor;
    private String timeSlot;
    private String consultationType;
    private boolean medicalReport;
    private boolean labTests;
    private String patientDescription;

    public Appointment(Doctor doctor, String timeSlot, String consultationType, boolean medicalReport, boolean labTests, String patientDescription) {
        this.doctor = doctor;
        this.timeSlot = timeSlot;
        this.consultationType = consultationType;
        this.medicalReport = medicalReport;
        this.labTests = labTests;
        this.patientDescription = patientDescription;
    }

    public Doctor getDoctorName() {
        return doctor;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public String getConsultationType() {
        return consultationType;
    }

    public boolean isMedicalReport() {
        return medicalReport;
    }

    public boolean isLabTests() {
        return labTests;
    }

    public String getPatientDescription() {
        return patientDescription;
    }
}
