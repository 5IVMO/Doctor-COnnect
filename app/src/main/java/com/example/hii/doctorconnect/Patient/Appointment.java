package com.example.hii.doctorconnect.Patient;

/**
 * Created by hii on 11/14/2016.
 */

public class Appointment {
    private String doctorName;
    private String hospitalName;
    private String date;
    private String time;
    private String day;

    public Appointment(String doctorName, String hospitalName, String date, String time, String day) {
        this.doctorName = doctorName;
        this.hospitalName = hospitalName;
        this.date = date;
        this.time = time;
        this.day = day;
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

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
