package com.example.euniboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class EnrollPersonal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enroll_personal);
    }
    public void goToEnrollAccount(View v) {
        Intent intent = new Intent(this, EnrollAccount.class);
        startActivity(intent);
    }
}