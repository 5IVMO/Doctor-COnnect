package com.example.hii.doctorconnect.Doctor;

/**
 * Created by hii on 2/16/2017.
 */

public class Patient {
    private String patientName;
    private int thumbnail;
    private int rating;

    public Patient(String patientName, int thumbnail,int rating) {
        this.patientName = patientName;
        this.thumbnail = thumbnail;
        this.rating=rating;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
