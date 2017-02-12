package com.example.hii.doctorconnect.Patient;

/**
 * Created by hii on 11/16/2016.
 */

public class Doctor {
    private String doctorName;
    private String hospitalName;
    private String Specialization;
    private int Rating;
    private int thumbnail;

    public Doctor(String doctorName, String hospitalName, String specialization, int rating,int thumbnail) {
        this.doctorName = doctorName;
        this.hospitalName = hospitalName;
        Specialization = specialization;
        Rating = rating;
        this.thumbnail=thumbnail;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }


    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getSpecialization() {
        return Specialization;
    }

    public void setSpecialization(String specialization) {
        Specialization = specialization;
    }

    public int getRating() {
        return Rating;
    }

    public void setRating(int rating) {
        Rating = rating;
    }
}
