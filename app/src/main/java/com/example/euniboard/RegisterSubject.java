package com.example.euniboard;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterSubject extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_subjects);

        //EVENTS
        Button btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(this::showConfirmation);
    }
    public void showConfirmation(View v) {
        ActionConfirmationFragment confirmationFrag = new ActionConfirmationFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.screenLayout, confirmationFrag)
                .addToBackStack(null)
                .commit();
    }
}