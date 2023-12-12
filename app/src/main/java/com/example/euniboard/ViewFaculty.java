package com.example.euniboard;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class ViewFaculty extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_faculty);

        boolean isAvailable = false;

        if(isAvailable) {
            openFacultyAvailable();
        }
        else {
            openFacultyNotAvailable();
        }
    }

    public void openFacultyAvailable() {
        FacultyAvailableFragment frag = new FacultyAvailableFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, frag)
                .commit();
    }
    public void openFacultyNotAvailable() {
        FacultyNA_Fragment frag = new FacultyNA_Fragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, frag)
                .commit();
    }
}