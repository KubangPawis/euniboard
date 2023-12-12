package com.example.euniboard;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
        Intent intent = getIntent();
        String menuGreeting = "";
        CurrentStudent loggedStudent = intent.getParcelableExtra("currently_logged_student");
        if(loggedStudent != null) {
            menuGreeting = "Hi " + loggedStudent.getFirstName();
            Log.d("GREETING CHECK", "First Name: " + loggedStudent.getFirstName());
        }


        TextView lblNameGreeting = findViewById(R.id.lblNameGreeting);
        lblNameGreeting.setText(menuGreeting);

        FrameLayout btnSubjects = findViewById(R.id.btnSubjects);
        FrameLayout btnFaculty = findViewById(R.id.btnFaculty);
        FrameLayout btnPayment = findViewById(R.id.btnPayment);
        FrameLayout btnOSAS = findViewById(R.id.btnOSAS);
        TextView boxSubj = findViewById(R.id.boxSubj);
        TextView boxFaculty = findViewById(R.id.boxFaculty);
        TextView boxPay = findViewById(R.id.boxPay);
        TextView boxOSAS = findViewById(R.id.boxOSAS);
        TextView lblSubj = findViewById(R.id.lblSubjects);
        TextView lblFaculty = findViewById(R.id.lblFaculty);
        TextView lblPayment = findViewById(R.id.lblPayment);
        TextView lblOSAS = findViewById(R.id.lblOSAS);
        ImageView imgSubj = findViewById(R.id.imgSubj);
        ImageView imgFaculty = findViewById(R.id.imgFaculty);
        ImageView imgPay = findViewById(R.id.imgPay);
        ImageView imgOSAS = findViewById(R.id.imgOSAS);

        btnSubjects.setOnClickListener(e -> openSubjects(e, loggedStudent));
        btnFaculty.setOnClickListener(e -> openFaculty(e, loggedStudent));
        btnPayment.setOnClickListener(e -> openPayment(e, loggedStudent));
        btnOSAS.setOnClickListener(e -> openOSAS(e, loggedStudent));
        boxSubj.setOnClickListener(e -> openSubjects(e, loggedStudent));
        boxFaculty.setOnClickListener(e -> openFaculty(e, loggedStudent));
        boxPay.setOnClickListener(e -> openPayment(e, loggedStudent));
        boxOSAS.setOnClickListener(e -> openOSAS(e, loggedStudent));
        lblSubj.setOnClickListener(e -> openSubjects(e, loggedStudent));
        lblFaculty.setOnClickListener(e -> openFaculty(e, loggedStudent));
        lblPayment.setOnClickListener(e -> openPayment(e, loggedStudent));
        lblOSAS.setOnClickListener(e -> openOSAS(e, loggedStudent));
        imgSubj.setOnClickListener(e -> openSubjects(e, loggedStudent));
        imgFaculty.setOnClickListener(e -> openFaculty(e, loggedStudent));
        imgPay.setOnClickListener(e -> openPayment(e, loggedStudent));
        imgOSAS.setOnClickListener(e -> openOSAS(e, loggedStudent));
    }

    public void openSubjects(View v, CurrentStudent loggedStudent) {
        SubjectsFragment subjectFragment = new SubjectsFragment();
        Bundle studentBundle = new Bundle();
        studentBundle.putParcelable("currently_logged_student", loggedStudent);
        subjectFragment.setArguments(studentBundle);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.screenLayout, subjectFragment)
                .addToBackStack(null)
                .commit();
    }
    public void openFaculty(View v, CurrentStudent loggedStudent) {
        FacultyFragment facultyFragment = new FacultyFragment();
        Bundle studentBundle = new Bundle();
        studentBundle.putParcelable("currently_logged_student", loggedStudent);
        facultyFragment.setArguments(studentBundle);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.screenLayout, facultyFragment)
                .addToBackStack(null)
                .commit();
    }
    public void openPayment(View v, CurrentStudent loggedStudent) {
        PaymentFragment paymentFragment = new PaymentFragment();
        Bundle studentBundle = new Bundle();
        studentBundle.putParcelable("currently_logged_student", loggedStudent);
        paymentFragment.setArguments(studentBundle);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.screenLayout, paymentFragment)
                .addToBackStack(null)
                .commit();
    }
    public void openOSAS(View v, CurrentStudent loggedStudent) {
        OsasFragment osasFragment = new OsasFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.screenLayout, osasFragment)
                .addToBackStack(null)
                .commit();
    }
}