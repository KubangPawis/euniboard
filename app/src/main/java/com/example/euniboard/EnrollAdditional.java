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

import java.util.Objects;

public class EnrollAdditional extends AppCompatActivity {
    private String lastName, firstName, middleName, birthDate, email, password, program, specialization;
    private int yearLevel;
    private String sex, religion, citizenship, fullAddress, zipCode, mobileNumber;
    private int age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enroll_additional);

        setSpinSex();

        //EVENTS
        Button btnNext = findViewById(R.id.btnNext);
        Spinner spinSex = findViewById(R.id.spinSex);

        btnNext.setOnClickListener(e -> goToEnrollEducation(e));
        spinSex.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                 sex = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Intent intent = getIntent();
        if (intent != null) {
            lastName = intent.getStringExtra("last_name");
            firstName = intent.getStringExtra("first_name");
            middleName = intent.getStringExtra("middle_name");
            birthDate = intent.getStringExtra("birth_date");
            email = intent.getStringExtra("email");
            password = intent.getStringExtra("password");
            yearLevel = intent.getIntExtra("year_level", 0);
            program = intent.getStringExtra("program");
            specialization = intent.getStringExtra("specialization");
        }
    }

    public void goToEnrollEducation(View v) {
        EditText txtAge = findViewById(R.id.txtAge);
        EditText txtReligion = findViewById(R.id.txtReligion);
        EditText txtCitizenship = findViewById(R.id.txtCitizenship);
        EditText txtFullAddress = findViewById(R.id.txtFullAddress);
        EditText txtZipCode = findViewById(R.id.txtZipCode);
        EditText txtMobileNumber = findViewById(R.id.txtMobileNumber);

        age = Integer.parseInt(String.valueOf(txtAge.getText()));
        religion = String.valueOf(txtReligion.getText());
        citizenship = String.valueOf(txtCitizenship.getText());
        fullAddress = String.valueOf(txtFullAddress.getText());
        zipCode = String.valueOf(txtZipCode.getText());
        mobileNumber = String.valueOf(txtMobileNumber.getText());

        Log.d("ERROR CHECK", "Sex: " + sex);

        Intent intent = new Intent(this, EnrollEducation.class);
        intent.putExtra("last_name", lastName);
        intent.putExtra("first_name", firstName);
        intent.putExtra("middle_name", middleName);
        intent.putExtra("birth_date", birthDate);
        intent.putExtra("email", email);
        intent.putExtra("password", password);
        intent.putExtra("year_level", yearLevel);
        intent.putExtra("program", program);
        intent.putExtra("specialization", specialization);
        intent.putExtra("age", age);
        intent.putExtra("sex", sex);
        intent.putExtra("religion", religion);
        intent.putExtra("citizenship", citizenship);
        intent.putExtra("full_address", fullAddress);
        intent.putExtra("zip_code", zipCode);
        intent.putExtra("mobile_number", mobileNumber);

        startActivity(intent);
    }
    public void setSpinSex() {
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
}