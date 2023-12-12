package com.example.euniboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Redirect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redirect);

        //EVENTS
        Button btnSignIn = findViewById(R.id.btnNo);
        btnSignIn.setOnClickListener(this::goBack);
    }

    public void goBack(View v) {

    }
}