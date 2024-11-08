package com.example.doch;

import java.util.List;

public class Doctor {
    private String name;
    private float rating;
    private String specialty;
    private String place;
    private int imageResourceId;
    private int backgroundResourceId;
    private List<String> availableTimeSlots;


    public Doctor(String name, float rating, String specialty, String place, int backgroundResourceId, int imageResourceId, List<String> availableTimeSlots) {
        this.name = name;
        this.rating = rating;
        this.specialty = specialty;
        this.place = place;
        this.imageResourceId = imageResourceId;
        this.backgroundResourceId = backgroundResourceId;
        this.availableTimeSlots = availableTimeSlots;

    }

    public String getName() {
        return name;
    }

    public float getRating() {
        return rating;
    }

    public String getSpecialty() {
        return specialty;
    }

    public String getPlace() {
        return place;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
    public int getBackgroundResourceId() {
        return backgroundResourceId;
    }

    public List<String> getAvailableTimeSlots() {
        return availableTimeSlots;
    }
}
