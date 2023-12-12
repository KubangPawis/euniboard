package com.example.euniboard;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class EnrollProgram extends AppCompatActivity {
    private String lastName, firstName, middleName, birthDate, email, password;
    private int yearLevel, semester;
    private String program, specialization;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enroll_program);

        setSpinYear();
        setSpinSemester();
        setSpinProgram();
        setSpinSpecialization();

        //EVENTS
        Button btnNext = findViewById(R.id.btnNext);
        Spinner spinYearLevel = findViewById(R.id.spinYearLvl);
        Spinner spinSemester = findViewById(R.id.spinSemester);
        Spinner spinProgram = findViewById(R.id.spinProgram);
        Spinner spinSpecialization = findViewById(R.id.spinSpecialization);

        spinYearLevel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String yearTemp = parent.getItemAtPosition(position).toString();
                switch(yearTemp) {
                    case "1st Year":
                        yearLevel = 1;
                        break;
                    case "2nd Year":
                        yearLevel = 2;
                        break;
                    case "3rd Year":
                        yearLevel = 3;
                        break;
                    case "4th Year":
                        yearLevel = 4;
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinSemester.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String semesterStr = parent.getItemAtPosition(position).toString();
                switch(semesterStr) {
                    case "1st Semester":
                        semester = 1;
                        break;
                    case "2nd Semester":
                        semester = 2;
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinProgram.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                program = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinSpecialization.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                specialization = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnNext.setOnClickListener(e -> goToEnrollAdd(e));

        Intent intent = getIntent();
        if (intent != null) {
            lastName = intent.getStringExtra("last_name");
            firstName = intent.getStringExtra("first_name");
            middleName = intent.getStringExtra("middle_name");
            birthDate = intent.getStringExtra("birth_date");
            email = intent.getStringExtra("email");
            password = intent.getStringExtra("password");
        }
    }
    public void goToEnrollAdd(View v) {
        Intent intent = new Intent(this, EnrollAdditional.class);
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

        startActivity(intent);
    }
    public void setSpinYear() {
        Spinner spinYear = findViewById(R.id.spinYearLvl);
        ArrayAdapter<CharSequence> yearAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.enrollment_year_level,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
        );
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinYear.setBackground(ContextCompat.getDrawable(this, R.drawable.spinner_arrow));
        spinYear.setAdapter(yearAdapter);
    }
    public void setSpinSemester() {
        Spinner spinSemester = findViewById(R.id.spinSemester);
        ArrayAdapter<CharSequence> yearAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.enrollment_semester,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
        );
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinSemester.setBackground(ContextCompat.getDrawable(this, R.drawable.spinner_arrow));
        spinSemester.setAdapter(yearAdapter);
    }
    public void setSpinProgram() {
        Spinner spinProgram = findViewById(R.id.spinProgram);
        ArrayAdapter<CharSequence> programAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.enrollment_program,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
        );
        programAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinProgram.setBackground(ContextCompat.getDrawable(this, R.drawable.spinner_arrow));
        spinProgram.setAdapter(programAdapter);
    }
    public void setSpinSpecialization() {
        Spinner spinSpecialization = findViewById(R.id.spinSpecialization);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.enrollment_specializations,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinSpecialization.setBackground(ContextCompat.getDrawable(this, R.drawable.spinner_arrow));
        spinSpecialization.setAdapter(adapter);
    }
}