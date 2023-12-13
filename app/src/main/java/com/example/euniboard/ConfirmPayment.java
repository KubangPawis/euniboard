package com.example.euniboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ConfirmPayment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_payment);

        //EVENTS
        Intent intent = getIntent();
        CurrentStudent loggedStudent = intent.getParcelableExtra("currently_logged_student");
        int studentID = intent.getIntExtra("student_id", 0);
        String studentName = intent.getStringExtra("student_name");
        String contactNumber = intent.getStringExtra("student_contact_number");
        String currentDate = intent.getStringExtra("current_date");
        String schoolYear = intent.getStringExtra("school_year");
        String semesterStr = intent.getStringExtra("semester");
        int semesterInt = loggedStudent.getSemester();
        String paymentType = intent.getStringExtra("payment_type");
        String paymentFor = intent.getStringExtra("payment_for");
        double balance = intent.getDoubleExtra("balance", 0);
        String balanceLbl = "₱" + String.format("₱%,.2f", balance);

        TextView lblStudentNumber = findViewById(R.id.lbl_student_number);
        TextView lblStudentName = findViewById(R.id.lbl_student_name);
        TextView lblContactNumber = findViewById(R.id.lbl_contact_number);
        TextView title_schoolYear = findViewById(R.id.title_schoolYear);
        TextView lblPaymentType = findViewById(R.id.lblPaymentType);
        TextView lblPaymentFor = findViewById(R.id.lblPaymentFor);
        TextView lblPaymentDate = findViewById(R.id.lblPaymentDate);
        TextView lblAmountPayable = findViewById(R.id.lblAmountPayable);

        lblStudentNumber.setText(String.valueOf(studentID));
        lblStudentName.setText(studentName);
        lblContactNumber.setText(contactNumber);
        title_schoolYear.setText(schoolYear);
        lblPaymentType.setText(paymentType);
        lblPaymentFor.setText(paymentFor);
        lblPaymentDate.setText(currentDate);
        lblAmountPayable.setText(balanceLbl);

        Button btnCancel = findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(e -> finish());
    }
}