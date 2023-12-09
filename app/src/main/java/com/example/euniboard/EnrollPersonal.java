package com.example.euniboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EnrollPersonal extends AppCompatActivity {

    private String lastName, firstName, middleName, birthDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enroll_personal);

        //EVENTS
        Button btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(e -> goToEnrollAccount(e));

    }
    public void goToEnrollAccount(View v) {
        //EXTRACT INFO
        EditText txtLastName = findViewById(R.id.txtLastName);
        EditText txtFirstName = findViewById(R.id.txtFirstName);
        EditText txtMiddleName = findViewById(R.id.txtMiddleName);
        EditText txtBirthDate = findViewById(R.id.txtBirthDate);

        lastName = String.valueOf(txtLastName.getText());
        firstName = String.valueOf(txtFirstName.getText());
        middleName = String.valueOf(txtMiddleName.getText());
        birthDate = String.valueOf(txtBirthDate.getText());

        //PASS INFO TO NEXT ACTIVITY
        Intent intent = new Intent(this, EnrollAccount.class);
        intent.putExtra("last_name", lastName);
        intent.putExtra("first_name", firstName);
        intent.putExtra("middle_name", middleName);
        intent.putExtra("birth_date", birthDate);

        startActivity(intent);
    }
}