package com.example.euniboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class EnrollProgram extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enroll_program);

        //EVENTS
        Button btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(e -> goToEnrollAdd(e));

        //YEAR LEVEL
        Spinner spinYear = findViewById(R.id.spinYearLvl);
        ArrayAdapter<CharSequence> yearAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.enrollment_year_level,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
        );
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinYear.setBackground(ContextCompat.getDrawable(this, R.drawable.spinner_arrow));
        spinYear.setAdapter(yearAdapter);

        //PROGRAM
        Spinner spinProgram = findViewById(R.id.spinProgram);
        ArrayAdapter<CharSequence> programAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.enrollment_program,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
        );
        programAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinProgram.setBackground(ContextCompat.getDrawable(this, R.drawable.spinner_arrow));
        spinProgram.setAdapter(programAdapter);

        //SPECIALIZATION
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

    public void goToEnrollAdd(View v) {
        Intent intent = new Intent(this, EnrollAdditional.class);
        startActivity(intent);
    }
}