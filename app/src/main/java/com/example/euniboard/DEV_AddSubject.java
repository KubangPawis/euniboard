package com.example.euniboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DEV_AddSubject extends AppCompatActivity {
    Student addSubject = new Student(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dev_activity_input_subjects);

        //EVENTS
        Button btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(e -> addSubject());
    }

    public void addSubject() {
    }
}