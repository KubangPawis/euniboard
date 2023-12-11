package com.example.euniboard;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

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
        TextView boxSubj = findViewById(R.id.boxSubj);
        TextView boxPay = findViewById(R.id.boxPay);
        TextView boxOSAS = findViewById(R.id.boxOSAS);
        TextView lblSubj = findViewById(R.id.lblSubjects);
        TextView lblPayment = findViewById(R.id.lblPayment);
        TextView lblOSAS = findViewById(R.id.lblOSAS);
        ImageView imgSubj = findViewById(R.id.imgSubj);
        ImageView imgPay = findViewById(R.id.imgPay);
        ImageView imgOSAS = findViewById(R.id.imgOSAS);

        btnSubjects.setOnClickListener(this::openSubjects);
        btnPayment.setOnClickListener(this::openPayment);
        btnOSAS.setOnClickListener(this::openOSAS);
        boxSubj.setOnClickListener(this::openSubjects);
        boxPay.setOnClickListener(this::openPayment);
        boxOSAS.setOnClickListener(this::openOSAS);
        lblSubj.setOnClickListener(this::openSubjects);
        lblPayment.setOnClickListener(this::openPayment);
        lblOSAS.setOnClickListener(this::openOSAS);
        imgSubj.setOnClickListener(this::openSubjects);
        imgPay.setOnClickListener(this::openPayment);
        imgOSAS.setOnClickListener(this::openOSAS);
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