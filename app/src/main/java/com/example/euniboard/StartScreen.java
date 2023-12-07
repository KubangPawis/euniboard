package com.example.euniboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        //EVENTS
        Button btnSignIn = findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(e -> goToSignIn(e));

        Button btnEnroll = findViewById(R.id.btnCreateAcc);
        btnEnroll.setOnClickListener(e -> goToEnrollMessage(e));
    }

    public void goToSignIn(View v) {
        Intent intent = new Intent(this, SignIn.class);
        startActivity(intent);
    }
    public void goToEnrollMessage(View v) {
        Intent intent = new Intent(this, EnrollMessage.class);
        startActivity(intent);
    }
}