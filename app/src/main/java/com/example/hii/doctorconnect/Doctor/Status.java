package com.example.hii.doctorconnect.Doctor;

/**
 * Created by hii on 2/16/2017.
 */

public class Status {
    private String id;
    private String doctorName;
    private String hospitalName;
    private boolean status;

    public Status(String id, String doctorName, String hospitalName, boolean status) {
        this.id = id;
        this.doctorName = doctorName;
        this.hospitalName = hospitalName;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
