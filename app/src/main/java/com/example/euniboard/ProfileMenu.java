package com.example.euniboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_menu);

        //EVENTS
        Button btnChangeEmail = findViewById(R.id.btnChangeEmail);
        btnChangeEmail.setOnClickListener(e -> changeEmail());

        Button btnChangePassword = findViewById(R.id.btnChangePassword);
        btnChangePassword.setOnClickListener(e -> changePassword());

        ImageView btnLogOut = findViewById(R.id.btnLogOut);
        btnLogOut.setOnClickListener(e -> userLogOut());
    }

}