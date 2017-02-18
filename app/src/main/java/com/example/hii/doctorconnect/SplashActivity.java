package com.example.hii.doctorconnect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

import com.example.hii.doctorconnect.Doctor.DoctorHomeActivity;
import com.example.hii.doctorconnect.Patient.PatientHomeActivity;

public class SplashActivity extends AppCompatActivity implements ProgressBarSplash.LoadingTaskFinishedListener {
    private AppPreferences appPrefs;
    String userID,userType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        appPrefs = new AppPreferences(getApplicationContext());
        userID=appPrefs.getUserID();
        userType=appPrefs.getUserType();
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        new ProgressBarSplash(progressBar, this).execute();
    }
    @Override
    public void onTaskFinished(){
        completeSplash();
    }
    private void completeSplash(){
        startApp();
        finish(); // Don't forget to finish this Splash Activity so the user can't return to it!
    }

    private void startApp() {

        if(!(userID.equals(""))) {
            if ((userType.equals("patient"))){
                Intent openHomeActivity = new Intent(SplashActivity.this,PatientHomeActivity.class);
                startActivity(openHomeActivity);
            }
            else if((userType.equals("doctor"))){
                Intent openHomeActivity = new Intent(SplashActivity.this,DoctorHomeActivity.class);
                startActivity(openHomeActivity);
            }
        }
        else{
            Intent openLoginActivity = new Intent(SplashActivity.this,MainActivity.class);
            startActivity(openLoginActivity);
        }
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }

}

