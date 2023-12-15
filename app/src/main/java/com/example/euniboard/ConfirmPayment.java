package com.example.euniboard;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ConfirmPayment extends AppCompatActivity {

    private String studentName, contactNumber, currentDate, schoolYear, semesterStr, paymentType, paymentFor;
    private int studentID, semesterInt;
    private double balance, payment, remainingBalance;
    StudentHandler payStudent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_payment);

        payStudent = new StudentHandler(this);
        SQLiteDatabase db = payStudent.getWritableDatabase();

        //EVENTS
        Intent intent = getIntent();
        CurrentStudent loggedStudent = intent.getParcelableExtra("currently_logged_student");
        int studentID = intent.getIntExtra("student_id", 0);
        studentName = intent.getStringExtra("student_name");
        contactNumber = intent.getStringExtra("student_contact_number");
        currentDate = intent.getStringExtra("current_date");
        semesterStr = intent.getStringExtra("semester");
        semesterInt = loggedStudent.getSemester();
        schoolYear = "2023-2024";
        paymentType = "Tuition";
        paymentFor = "Down Payment";
        balance = intent.getDoubleExtra("balance", 0);
        String balanceLbl = "₱" + String.format("₱%,.2f", balance);

        Log.d("ERROR CHECK", "It got here!");

        Log.d("VALUE CHECK", String.valueOf(studentID));
        Log.d("VALUE CHECK", studentName);
        Log.d("VALUE CHECK", contactNumber);
        Log.d("VALUE CHECK", currentDate);
        Log.d("VALUE CHECK", schoolYear);
        Log.d("VALUE CHECK", paymentType);
        Log.d("VALUE CHECK", paymentFor);
        Log.d("VALUE CHECK", String.valueOf(balance));

        TextView lblStudentNumber = findViewById(R.id.lbl_student_number);
        TextView lblStudentName = findViewById(R.id.lbl_student_name);
        TextView lblContactNumber = findViewById(R.id.lbl_contact_number);
        TextView title_schoolYear = findViewById(R.id.title_schoolYear);
        TextView lblPaymentType = findViewById(R.id.lblPaymentType);
        TextView lblPaymentFor = findViewById(R.id.lblPaymentFor);
        TextView lblPaymentDate = findViewById(R.id.lblPaymentDate);
        TextView lblAmountPayable = findViewById(R.id.lblAmountPayable);

        Log.d("ERROR CHECK", "It got here!");

        payment = 4000;
        remainingBalance = balance - payment;

        Log.d("ERROR CHECK", "Payment: " + payment);
        Log.d("ERROR CHECK", "Balance: " + remainingBalance);


        lblStudentNumber.setText(String.valueOf(studentID));
        lblStudentName.setText(studentName);
        lblContactNumber.setText(contactNumber);
        title_schoolYear.setText(schoolYear);
        lblPaymentType.setText(paymentType);
        lblPaymentFor.setText(paymentFor);

        lblPaymentDate.setText(currentDate);
        lblAmountPayable.setText(balanceLbl);

        Log.d("ERROR CHECK", "It got here!");

        Button btnPay = findViewById(R.id.btnPay);
        Button btnCancel = findViewById(R.id.btnCancel);
        btnPay.setOnClickListener(e -> payRecord(db));
        btnCancel.setOnClickListener(e -> finish());
    }
    public void payRecord(SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        values.put("student_id", studentID);
        values.put("date_paid", currentDate);
        values.put("amount_paid", payment);
        values.put("remaining_balance", remainingBalance);
        values.put("payment_remarks", paymentFor);
        values.put("semester", semesterInt);
        long newStudentId = db.insert("Payments", null, values);
        if (newStudentId != -1) {
            Log.d("PAYMENT SUCCESSFUL", "Enrollment successful!");
        } else {
            Log.d("PAYMENT FAILED", "Enrollment failed.");
        }
    }
}