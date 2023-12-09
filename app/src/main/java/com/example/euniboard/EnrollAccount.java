package com.example.euniboard;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EnrollAccount extends AppCompatActivity {
    private String lastName, firstName, middleName, birthDate;
    private String email, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enroll_account);

        Button btnNext = findViewById(R.id.btnNext);
        Intent intent = getIntent();
        if (intent != null) {
            lastName = intent.getStringExtra("last_name");
            firstName = intent.getStringExtra("first_name");
            middleName = intent.getStringExtra("middle_name");
            birthDate = intent.getStringExtra("birth_date");
        }

        //EVENTS
        btnNext.setOnClickListener(e -> goToEnrollProgram(e));
    }

    public void goToEnrollProgram(View v) {
        //EXTRACT INFO
        EditText txtEmail = findViewById(R.id.txtEmail);
        EditText txtPassword = findViewById(R.id.txtPassword);

        email = String.valueOf(txtEmail.getText());
        password = String.valueOf(txtPassword.getText());

        //PASS INFO TO NEXT ACTIVITY
        Intent intent = new Intent(this, EnrollProgram.class);
        intent.putExtra("last_name", lastName);
        intent.putExtra("first_name", firstName);
        intent.putExtra("middle_name", middleName);
        intent.putExtra("birth_date", birthDate);
        intent.putExtra("email", email);
        intent.putExtra("password", password);

        startActivity(intent);
    }
}