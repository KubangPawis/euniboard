package com.example.euniboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StartScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
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