package com.example.euniboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class EnrollCongratulations extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enroll_congratulations);

        Button btnContinue = findViewById(R.id.btnContinue);

        //EVENTS
        btnContinue.setOnClickListener(e -> goHome(e));
    }

    public void goHome(View v) {
        //IMPORTANT: This clears all of the previous activities from the stack so that you can't go back to the enrollment pages
        Intent intent = new Intent(this, StartScreen.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}