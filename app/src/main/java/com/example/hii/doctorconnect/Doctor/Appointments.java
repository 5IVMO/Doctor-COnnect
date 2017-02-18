package com.example.hii.doctorconnect.Doctor;

/**
 * Created by hii on 2/16/2017.
 */

public class Appointments {
    private String id;
    private String doctorName;
    private String hospitalNname;
    private String appointments;

    public Appointments(String id, String doctorName, String hospitalNname, String appointments) {
        this.id = id;
        this.doctorName = doctorName;
        this.hospitalNname = hospitalNname;
        this.appointments = appointments;
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

    public String getHospitalNname() {
        return hospitalNname;
    }

    public void setHospitalNname(String hospitalNname) {
        this.hospitalNname = hospitalNname;
    }

    public String getAppointments() {
        return appointments;
    }

    public void setAppointments(String appointments) {
        this.appointments = appointments;
    }
}
