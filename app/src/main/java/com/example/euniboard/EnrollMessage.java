package com.example.euniboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class EnrollMessage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enroll_message);

        //EVENTS
        Button btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(e -> goToEnrollPersonal(e));
    }
    public void goToEnrollPersonal(View v) {
        Intent intent = new Intent(this, EnrollPersonal.class);
        startActivity(intent);
    }
}