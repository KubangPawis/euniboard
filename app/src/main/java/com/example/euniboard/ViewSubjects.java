package com.example.euniboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ViewSubjects extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_subjects);

        boolean isAvailable = false;

        if(isAvailable) {
            openSubjectsAvailable();
        }
        else {
            openSubjectsNotAvailable();
        }

        //EVENTS
        ImageView btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(e -> goToRegisterSubjects());
    }

    public void openSubjectsAvailable() {
        SubjectsAvailableFragment frag = new SubjectsAvailableFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, frag)
                .commit();
    }
    public void openSubjectsNotAvailable() {
        SubjectsNA_Fragment frag = new SubjectsNA_Fragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, frag)
                .commit();
    }
    public void goToRegisterSubjects() {
        Intent intent = new Intent(this, RegisterSubject.class);
        startActivity(intent);
    }
}