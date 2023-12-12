package com.example.euniboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class EnrollEducation extends AppCompatActivity {
    private String lastName, firstName, middleName, birthDate, email, password, program, specialization, sex, religion, citizenship, fullAddress, zipCode, mobileNumber;
    private int yearLevel, semester, age;
    private String elemSchool, jhSchool, shSchool;
    private double elemGrade, juniorGrade, seniorGrade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enroll_education);

        //EVENTS
        Button btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(e -> goToCongratulations(e));

        Intent intent = getIntent();
        if (intent != null) {
            lastName = intent.getStringExtra("last_name");
            firstName = intent.getStringExtra("first_name");
            middleName = intent.getStringExtra("middle_name");
            birthDate = intent.getStringExtra("birth_date");
            email = intent.getStringExtra("email");
            password = intent.getStringExtra("password");
            yearLevel = intent.getIntExtra("year_level", 0);
            semester = intent.getIntExtra("semester", 0);
            program = intent.getStringExtra("program");
            specialization = intent.getStringExtra("specialization");
            age = intent.getIntExtra("age", 0);
            sex = intent.getStringExtra("sex");
            religion = intent.getStringExtra("religion");
            citizenship = intent.getStringExtra("citizenship");
            fullAddress = intent.getStringExtra("full_address");
            zipCode = intent.getStringExtra("zip_code");
            mobileNumber = intent.getStringExtra("mobile_number");
        }
    }
    public void goToCongratulations(View v) {
        EditText txtElemSchool = findViewById(R.id.txtElemSchool);
        EditText txtElemGrade = findViewById(R.id.txtElemGrade);
        EditText txtJuniorHS = findViewById(R.id.txtJuniorHS);
        EditText txtJuniorGrade = findViewById(R.id.txtJuniorGrade);
        EditText txtSeniorHS = findViewById(R.id.txtSeniorHS);
        EditText txtSeniorGrade = findViewById(R.id.txtSeniorGrade);

        elemSchool = String.valueOf(txtElemSchool.getText());
        elemGrade = Double.parseDouble(String.valueOf(txtElemGrade.getText()));
        jhSchool = String.valueOf(txtJuniorHS.getText());
        juniorGrade = Double.parseDouble(String.valueOf(txtJuniorGrade.getText()));
        shSchool = String.valueOf(txtSeniorHS.getText());
        seniorGrade = Double.parseDouble(String.valueOf(txtSeniorGrade.getText()));

        Intent intent = new Intent(this, EnrollCongratulations.class);
        intent.putExtra("last_name", lastName);
        intent.putExtra("first_name", firstName);
        intent.putExtra("middle_name", middleName);
        intent.putExtra("birth_date", birthDate);
        intent.putExtra("email", email);
        intent.putExtra("password", password);
        intent.putExtra("year_level", yearLevel);
        intent.putExtra("semester", semester);
        intent.putExtra("program", program);
        intent.putExtra("specialization", specialization);
        intent.putExtra("age", age);
        intent.putExtra("sex", sex);
        intent.putExtra("religion", religion);
        intent.putExtra("citizenship", citizenship);
        intent.putExtra("full_address", fullAddress);
        intent.putExtra("zip_code", zipCode);
        intent.putExtra("mobile_number", mobileNumber);
        intent.putExtra("elem_school", elemSchool);
        intent.putExtra("elem_grade", elemGrade);
        intent.putExtra("jhs_school", jhSchool);
        intent.putExtra("jhs_grade", juniorGrade);
        intent.putExtra("shs_school", shSchool);
        intent.putExtra("shs_grade", seniorGrade);

        startActivity(intent);
    }
}