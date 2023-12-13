package com.example.euniboard;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class PayTuition extends AppCompatActivity {
    private String studentName, contactNumber, currentDate, schoolYear, semester, paymentType, paymentFor;
    private int studentID;
    private double amounts_payable;
    private StudentHandler payStudent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_payment);

        //EVENTS
        payStudent = new StudentHandler(this);
        SQLiteDatabase readable_db = payStudent.getReadableDatabase();

        Log.d("ERROR CHECK", "CHECK #1");

        Intent intent = getIntent();
        CurrentStudent loggedStudent = intent.getParcelableExtra("currently_logged_student");
        studentID = loggedStudent.getStudentID();
        studentName = loggedStudent.getFirstName() + " " + loggedStudent.getMiddleName() + " " + loggedStudent.getLastName();
        contactNumber = loggedStudent.getMobileNumber();

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        currentDate = dateFormat.format(calendar.getTime());

        Log.d("ERROR CHECK", "CHECK #2");


        Spinner cmbSY = findViewById(R.id.cmbSY);
        Spinner cmbSem = findViewById(R.id.cmbSem);
        Spinner cmbPaymentType = findViewById(R.id.cmbPaymentType);
        Spinner cmbPaymentFor = findViewById(R.id.cmbPaymentFor);
        TextView txtStudentNumber = findViewById(R.id.txtStudentNumber);
        TextView txtStudentName = findViewById(R.id.txtStudentName);
        TextView txtContactNumber = findViewById(R.id.txtContactNumber);
        TextView txtPaymentDate = findViewById(R.id.txtPaymentDate);
        Button btnPay = findViewById(R.id.btnPayTuition);
        setAmountsPayable(readable_db, studentID);

        Log.d("ERROR CHECK", "CHECK #3");
        txtStudentNumber.setText(String.valueOf(studentID));
        txtStudentName.setText(studentName);
        txtContactNumber.setText(contactNumber);
        txtPaymentDate.setText(currentDate);

        setSpinSY();
        setSpinSem();
        setSpinPaymentType();
        setSpinPaymentFor();

        btnPay.setOnClickListener(e -> goToConfirmPayment(loggedStudent));
        cmbSY.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                schoolYear = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        cmbSem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                semester = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        cmbPaymentType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                paymentType = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        cmbPaymentFor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                paymentFor = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
    public void setAmountsPayable(SQLiteDatabase db, int studentID) {
        double balance = 0;
        TextView txtPayable = findViewById(R.id.lblPayable);
        String query = "SELECT remaining_balance FROM Payments WHERE student_id = ?;";
        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(studentID)});
        if(cursor!=null && cursor.moveToLast()) {
            int balance_index = cursor.getColumnIndex("remaining_balance");
            balance = cursor.getDouble(balance_index);
        }
        cursor.close();
        amounts_payable = balance;
        String payableText = String.format("₱%,.2f", balance);
        txtPayable.setText(payableText);
    }

    public void setSpinSY() {
        Spinner spinYear = findViewById(R.id.cmbSY);
        ArrayAdapter<CharSequence> yearAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.payment_sy,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
        );
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinYear.setBackground(ContextCompat.getDrawable(this, R.drawable.spinner_arrow));
        spinYear.setAdapter(yearAdapter);
    }
    public void setSpinSem() {
        Spinner spinYear = findViewById(R.id.cmbSem);
        ArrayAdapter<CharSequence> yearAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.payment_sem,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
        );
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinYear.setBackground(ContextCompat.getDrawable(this, R.drawable.spinner_arrow));
        spinYear.setAdapter(yearAdapter);
    }
    public void setSpinPaymentType() {
        Spinner spinYear = findViewById(R.id.cmbPaymentType);
        ArrayAdapter<CharSequence> yearAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.payment_type,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
        );
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinYear.setBackground(ContextCompat.getDrawable(this, R.drawable.spinner_arrow));
        spinYear.setAdapter(yearAdapter);
    }
    public void setSpinPaymentFor() {
        Spinner spinYear = findViewById(R.id.cmbPaymentFor);
        ArrayAdapter<CharSequence> yearAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.payment_for,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
        );
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinYear.setBackground(ContextCompat.getDrawable(this, R.drawable.spinner_arrow));
        spinYear.setAdapter(yearAdapter);
    }
    public void goToConfirmPayment(CurrentStudent loggedStudent) {
        Intent intent = new Intent(this, ConfirmPayment.class);
        intent.putExtra("currently_logged_student", loggedStudent);
        intent.putExtra("student_id", studentID);
        intent.putExtra("student_name", studentName);
        intent.putExtra("student_contact_number", contactNumber);
        intent.putExtra("current_date", currentDate);
        intent.putExtra("school_year", schoolYear);
        intent.putExtra("semester", semester);
        intent.putExtra("payment_type", paymentType);
        intent.putExtra("payment_for", paymentFor);
        intent.putExtra("balance", amounts_payable);
        startActivity(intent);
    }

}