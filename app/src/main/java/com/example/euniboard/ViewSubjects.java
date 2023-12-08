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

        ImageView btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(e -> openSubjects(e));

    }

    public void openSubjects(View v) {
        SubjectsAvailableFragment subjectsAvailFragment = new SubjectsAvailableFragment();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, subjectsAvailFragment)
                .addToBackStack(null)
                .commit();
    }
}