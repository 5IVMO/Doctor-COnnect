package com.example.hii.doctorconnect.Patient;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hii.doctorconnect.AppPreferences;
import com.example.hii.doctorconnect.Doctor.DoctorFavouriteFragment;
import com.example.hii.doctorconnect.MainActivity;
import com.example.hii.doctorconnect.R;

public class PatientHomeActivity extends AppCompatActivity {

    //Defining Variables
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private AppPreferences appPrefs;
    TextView nameTextView,emailTextView;
    ImageView imageView;
    private String userID,imageFile,userType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_home);
        appPrefs = new AppPreferences(getApplicationContext());
        userID = appPrefs.getUserID();
        userType=appPrefs.getUserType();
        // Initializing Drawer Layout and ActionBarToggle
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);

        // Initializing Toolbar and setting it as the actionbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Initializing NavigationView
        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        View headerView= navigationView.getHeaderView(0);
        // RelativeLayout headerView= (RelativeLayout) findViewById(R.id.header);
        nameTextView= (TextView) headerView.findViewById(R.id.username);
        emailTextView=(TextView) headerView.findViewById(R.id.email);
        imageView= (ImageView) headerView.findViewById(R.id.profile_image);
        loadHeaderData();
        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {


                //Checking if the item is in checked state or not, if not make it in checked state
                if(menuItem.isChecked())
                    menuItem.setChecked(false);
                else
                    menuItem.setChecked(true);

                //Closing patient_drawer on item click
                drawerLayout.closeDrawers();

                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()){


                    //Replacing the main content with ContentFragment Which is our Inbox View;
                    case R.id.Home:
                        Toast.makeText(getApplicationContext(),"Home Selected",Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frame,new PatientHomeFragment()).commit();
                        return true;
                    case R.id.Profile:
                        Toast.makeText(getApplicationContext(),"Profile Selected",Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frame,new PatientProfileFragment()).commit();
                        return true;

                    case R.id.Appointment:
                        Toast.makeText(getApplicationContext(),"Appointment Selected",Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frame,new PatientAppointmentFragment()).commit();
                        return true;
                    case R.id.Search:
                        Toast.makeText(getApplicationContext(),"Search Selected",Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frame,new PatientSearchFragment()).commit();
                        return true;
                    case R.id.Favourite:
                        Toast.makeText(getApplicationContext(),"Favourite Selected",Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frame,new DoctorFavouriteFragment()).commit();
                        return true;
                    case R.id.Diagnose:
                        Toast.makeText(getApplicationContext(),"Diagnose Selected",Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frame,new PatientDiagnoseFragment()).commit();
                        return true;
                    case R.id.Schedule:
                        Toast.makeText(getApplicationContext(),"Schedule Selected",Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frame,new PatientScheduleFragment()).commit();
                        return true;
                    case R.id.signOut:
                        appPrefs.signOutUser();
                        Toast.makeText(getApplicationContext(),"User SignOut",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(PatientHomeActivity.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                        return true;
                    default:
                        Toast.makeText(getApplicationContext(),"Somethings Wrong",Toast.LENGTH_SHORT).show();
                        return true;

                }
            }
        });

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.openDrawer, R.string.closeDrawer){

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the patient_drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the patient_drawer open as we dont want anything to happen so we leave this blank

                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to patient_drawer layout
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessay or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();

        getSupportFragmentManager().
                beginTransaction().
                add(R.id.frame, new PatientHomeFragment()).commit();

    }
    public void loadHeaderData(){
        emailTextView.setText(userID);
        nameTextView.setText(userType);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
