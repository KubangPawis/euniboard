package com.example.euniboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class EnrollAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enroll_account);

        Button btnNext = findViewById(R.id.btnNext);

        //EVENTS
        btnNext.setOnClickListener(e -> goToEnrollProgram(e));
    }

    public void goToEnrollProgram(View v) {
        Intent intent = new Intent(this, EnrollProgram.class);
        startActivity(intent);
    }
}