package com.example.euniboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EnrollEducation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enroll_education);

        //EVENTS
        Button btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(e -> goToCongratulations(e));
    }
    public void goToCongratulations(View v) {
        Intent intent = new Intent(this, EnrollCongratulations.class);
        startActivity(intent);
    }
}