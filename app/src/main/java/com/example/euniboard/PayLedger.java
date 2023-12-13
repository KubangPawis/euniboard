package com.example.euniboard;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PayLedger extends AppCompatActivity {

    StudentHandler transactionStudent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_ledger);

        transactionStudent = new StudentHandler(this);
        SQLiteDatabase db = transactionStudent.getReadableDatabase();

        //EVENTS
        showTransaction(db);

    }
    public void showTransaction(SQLiteDatabase db) {
        LinearLayout linearLedger = findViewById(R.id.linearLedger);
        linearLedger.removeAllViews(); //remove all exiting subject views on every button click, then repopulate

        Intent intent = getIntent();
        CurrentStudent loggedStudent = intent.getParcelableExtra("currently_enrolled_student");
        int studentID = loggedStudent.getStudentID();

        Cursor transactions = getTransactionHistory(db, studentID);

        //DIMENSION CONVERSION (dp to pixel)
        float widthDP = 410f;
        float heightDP = 60f;
        float scale = getResources().getDisplayMetrics().density;
        int widthPX = (int) (widthDP * scale + 0.5f);
        int heightPX = (int) (heightDP * scale + 0.5f);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(widthPX, heightPX);

        if(transactions != null && transactions.moveToFirst()) {
            do {
                int date_index = transactions.getColumnIndex("date_paid");
                int payment_index = transactions.getColumnIndex("amount_paid");
                int balance_index = transactions.getColumnIndex("remaining_balance");
                int remarks_index = transactions.getColumnIndex("payment_remarks");
                String date = transactions.getString(date_index);
                String payment = transactions.getString(payment_index);
                String balance = transactions.getString(balance_index);
                String remarks = transactions.getString(remarks_index);

                View itemView = getLayoutInflater().inflate(R.layout.layout_ledger_panel, null);

                TextView lblDate = itemView.findViewById(R.id.lblDate);
                TextView lblPaid = itemView.findViewById(R.id.lblPaid);
                TextView lblBalance = itemView.findViewById(R.id.lblBalance);
                TextView lblRemark = itemView.findViewById(R.id.lblPaymentRemark);

                lblDate.setText(date);
                lblPaid.setText(payment);
                lblBalance.setText(balance);
                lblRemark.setText(remarks);

                itemView.setLayoutParams(layoutParams);
                linearLedger.addView(itemView);
                transactions.moveToNext();
            } while (transactions.moveToNext());
            transactions.close();
        }
    }
    public Cursor getTransactionHistory(SQLiteDatabase db, int studentID) {
        String query = "SELECT * FROM Payments WHERE student_id = ?;";
        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(studentID)});
        if(cursor != null) {
            return cursor;
        }
        else {
            return null;
        }
    }
}