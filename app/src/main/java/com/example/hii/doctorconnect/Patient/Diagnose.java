package com.example.hii.doctorconnect.Patient;

/**
 * Created by hii on 1/8/2017.
 */

public class Diagnose {
    private String medicineName;
    private  String medicineCategory;

    public Diagnose(String medicineName, String medicineCategory) {
        this.medicineName = medicineName;
        this.medicineCategory = medicineCategory;
    }

    public String getMedicineCategory() {
        return medicineCategory;
    }

    public void setMedicineCategory(String medicineCategory) {
        this.medicineCategory = medicineCategory;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }


}
