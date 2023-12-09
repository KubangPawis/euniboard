package com.example.euniboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class EnrollCongratulations extends AppCompatActivity {
    private String lastName, firstName, middleName, birthDate, email, password, program, specialization, sex, religion, citizenship, fullAddress, zipCode, mobileNumber, elemSchool, jhSchool, shSchool;
    private int yearLevel, age;
    private double elemGrade, juniorGrade, seniorGrade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enroll_congratulations);

        Button btnContinue = findViewById(R.id.btnContinue);

        //EVENTS
        btnContinue.setOnClickListener(e -> goHome(e));

        Intent intent = getIntent();
        if (intent != null) {
            lastName = intent.getStringExtra("last_name");
            firstName = intent.getStringExtra("first_name");
            middleName = intent.getStringExtra("middle_name");
            birthDate = intent.getStringExtra("birth_date");
            email = intent.getStringExtra("email");
            password = intent.getStringExtra("password");
            yearLevel = Integer.parseInt(Objects.requireNonNull(intent.getStringExtra("year_level")));
            program = intent.getStringExtra("program");
            specialization = intent.getStringExtra("specialization");
            age = Integer.parseInt(Objects.requireNonNull(intent.getStringExtra("age")));
            sex = intent.getStringExtra("sex");
            religion = intent.getStringExtra("religion");
            citizenship = intent.getStringExtra("citizenship");
            fullAddress = intent.getStringExtra("full_address");
            zipCode = intent.getStringExtra("zip_code");
            mobileNumber = intent.getStringExtra("mobile_number");
            elemSchool = intent.getStringExtra("elem_school");
            elemGrade = Double.parseDouble(Objects.requireNonNull(intent.getStringExtra("elem_grade")));
            jhSchool = intent.getStringExtra("jhs_school");
            juniorGrade = Double.parseDouble(Objects.requireNonNull(intent.getStringExtra("jhs_grade")));
            shSchool = intent.getStringExtra("shs_school");
            seniorGrade = Double.parseDouble(Objects.requireNonNull(intent.getStringExtra("shs_grade")));
        }
    }

    public void goHome(View v) {
        Student studentHelper = new Student(this,lastName, firstName, middleName, birthDate, email, password, yearLevel, program, specialization, age, sex, religion, citizenship, fullAddress, zipCode, mobileNumber, elemSchool, elemGrade, jhSchool, juniorGrade, shSchool, seniorGrade);

        //IMPORTANT: This clears all of the previous activities from the stack so that you can't go back to the enrollment pages
        Intent intent = new Intent(this, StartScreen.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}