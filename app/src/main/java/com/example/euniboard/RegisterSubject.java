package com.example.euniboard;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterSubject extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_subjects);

        //EVENTS
        ImageView btnNotif = findViewById(R.id.btnNotif);
        btnNotif.setOnClickListener(e -> goToDevAddSubjects());
    }

    public void goToDevAddSubjects() {
        Intent intent = new Intent(this, DEV_AddSubject.class);
        startActivity(intent);
    }
}