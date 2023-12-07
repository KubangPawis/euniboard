package com.example.euniboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class EnrollAdditional extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enroll_additional);

        //EVENTS
        Button btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(e -> goToEnrollEducation(e));

        //SEX
        Spinner spinSex = findViewById(R.id.spinSex);
        ArrayAdapter<CharSequence> sexAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.enrollment_sex,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
        );
        sexAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinSex.setBackground(ContextCompat.getDrawable(this, R.drawable.spinner_arrow));
        spinSex.setAdapter(sexAdapter);
    }

    public void goToEnrollEducation(View v) {
        Intent intent = new Intent(this, EnrollEducation.class);
        startActivity(intent);
    }
}