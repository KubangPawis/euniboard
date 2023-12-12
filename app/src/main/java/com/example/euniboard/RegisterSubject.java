package com.example.euniboard;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterSubject extends AppCompatActivity {
    StudentHandler newStudent = new StudentHandler(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_subjects);

        LinearLayout linearBlockSelect = findViewById(R.id.linearBlockSelect);
        SQLiteDatabase db = newStudent.getReadableDatabase();

        String[] subjectList = {"OOP", "Art Appreciation", "Swimming"};

        //DIMENSION CONVERSION (dp to pixel)
        float widthDP = 300f;
        float heightDP = 111f;
        float scale = getResources().getDisplayMetrics().density;
        int widthPX = (int) (widthDP * scale + 0.5f);
        int heightPX = (int) (heightDP * scale + 0.5f);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                widthPX, // Width
                heightPX// Height
        );

        for (String subject : subjectList) {
            View itemView = getLayoutInflater().inflate(R.layout.layout_subject_panel, null);
            TextView titleTextView = itemView.findViewById(R.id.lblSubject);

            // Set data to TextViews or views in the item layout
            titleTextView.setText(subject); // Replace with actual data retrieval

            itemView.setLayoutParams(layoutParams);
            linearBlockSelect.addView(itemView);
        }

        //EVENTS
        Button btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(this::showConfirmation);
    }
    public void showConfirmation(View v) {
        ActionConfirmationFragment confirmationFrag = new ActionConfirmationFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.screenLayout, confirmationFrag)
                .addToBackStack(null)
                .commit();
    }
}