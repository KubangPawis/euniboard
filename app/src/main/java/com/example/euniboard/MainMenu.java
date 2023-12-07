package com.example.euniboard;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //EVENTS
        FrameLayout btnSubjects = findViewById(R.id.btnSubjects);
        btnSubjects.setOnClickListener(e -> openSubjects(e));
    }

    public void openSubjects(View v) {
        SubjectsFragment yourFragment = new SubjectsFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.screenLayout, yourFragment) // R.id.fragment_container is the ID of your container
                .addToBackStack(null) // Optional: Add fragment transaction to back stack
                .commit();
    }
}