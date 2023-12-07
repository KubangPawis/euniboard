package com.example.euniboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class EnrollPersonal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enroll_personal);

        //EVENTS
        Button btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(e -> goToEnrollAccount(e));

    }
    public void goToEnrollAccount(View v) {
        Intent intent = new Intent(this, EnrollAccount.class);
        startActivity(intent);
    }
}