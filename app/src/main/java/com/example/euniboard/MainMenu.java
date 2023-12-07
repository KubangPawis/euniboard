package com.example.euniboard;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //EVENTS
        FrameLayout btnSubjects = findViewById(R.id.btnSubjects);
        FrameLayout btnPayment = findViewById(R.id.btnPayment);
        FrameLayout btnOSAS = findViewById(R.id.btnOSAS);
        btnSubjects.setOnClickListener(e -> openSubjects(e));
        btnPayment.setOnClickListener(e -> openPayment(e));
        btnOSAS.setOnClickListener(e -> openOSAS(e));
    }

    public void openSubjects(View v) {
        SubjectsFragment subjectFragment = new SubjectsFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.screenLayout, subjectFragment)
                .addToBackStack(null)
                .commit();
    }
    public void openPayment(View v) {
        PaymentFragment paymentFragment = new PaymentFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.screenLayout, paymentFragment)
                .addToBackStack(null)
                .commit();
    }
    public void openOSAS(View v) {
        OsasFragment osasFragment = new OsasFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.screenLayout, osasFragment)
                .addToBackStack(null)
                .commit();
    }
}