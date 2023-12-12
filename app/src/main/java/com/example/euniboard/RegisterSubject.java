package com.example.euniboard;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class RegisterSubject extends AppCompatActivity {
    StudentHandler enrollStudent;
    int selectedBlockCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_subjects);

        //LOAD DATABASE
        enrollStudent = new StudentHandler(this);
        SQLiteDatabase db = enrollStudent.getReadableDatabase();
        SQLiteDatabase writable_db = enrollStudent.getWritableDatabase();
        Log.d("ERROR CHECK", "ERROR CHECK #1");

        //LOAD CURRENT STUDENT CLASS and STUDENT'S YEAR LEVEL
        Intent intent = getIntent();
        CurrentStudent loggedStudent = intent.getParcelableExtra("currently_logged_student");
        int studentID = loggedStudent.getStudentID();
        int yearLevel = loggedStudent.getYearLevel();
        int semester = loggedStudent.getSemester();

        Log.d("ERROR CHECK", "ERROR CHECK #2");

        //CHANGE DISPLAYED CURRENT YEAR AND SEM
        TextView lblCurrentYear = findViewById(R.id.lblCurrentYear);
        String semesterLbl = "";
        String newYearLbl = "";
        switch(semester) {
            case 1:
                semesterLbl = " (1st Sem)";
                break;
            case 2:
                semesterLbl = " (2nd Sem)";
                break;
        }
        switch(yearLevel) {
            case 1:
                newYearLbl = "Year: 1st Year" + semesterLbl;
                break;
            case 2:
                newYearLbl = "Year: 2nd Year" + semesterLbl;
                break;
            case 3:
                newYearLbl = "Year: 3rd Year" + semesterLbl;
                break;
            case 4:
                newYearLbl = "Year: 4th Year" + semesterLbl;
                break;
        }
        lblCurrentYear.setText(newYearLbl);

        Log.d("ERROR CHECK", "ERROR CHECK #3");

        //CHECK AVAILABLE BLOCKS FOR CURRENT YEAR
        ArrayList<Integer> availableBlockList = getAvailableBlocks(db, yearLevel, semester);


        //EVENTS
        Button btnRegister = findViewById(R.id.btnRegister);
        FrameLayout btnBlock1 = findViewById(R.id.btnBlock1);
        ImageView iconBlock1 = findViewById(R.id.iconBlock1);
        TextView lblBlock1 = findViewById(R.id.lblBlock1);
        FrameLayout btnBlock2 = findViewById(R.id.btnBlock2);
        ImageView iconBlock2 = findViewById(R.id.iconBlock2);
        TextView lblBlock2 = findViewById(R.id.lblBlock2);

        btnBlock1.setOnClickListener(e -> showBlockSubject(db, availableBlockList.get(0)));
        iconBlock1.setOnClickListener(e -> showBlockSubject(db, availableBlockList.get(0)));
        lblBlock1.setOnClickListener(e -> showBlockSubject(db, availableBlockList.get(0)));
        btnBlock2.setOnClickListener(e -> showBlockSubject(db, availableBlockList.get(1)));
        iconBlock2.setOnClickListener(e -> showBlockSubject(db, availableBlockList.get(1)));
        lblBlock2.setOnClickListener(e -> showBlockSubject(db, availableBlockList.get(1)));
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("I GOT HERE!!", "I got here");
                addToEnrollment(writable_db, studentID, selectedBlockCode);
            }
        });
    }

    public ArrayList<Integer> getAvailableBlocks(SQLiteDatabase db, int currentYearLvl, int currentSemester) {
        ArrayList <Integer> availableBlockList = new ArrayList<>();
        String query = "SELECT block_code FROM BlockSection WHERE year_level = ? AND semester = ?;";
        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(currentYearLvl), String.valueOf(currentSemester)});

        if(cursor != null && cursor.moveToFirst()) {
            do {
                int blockCode_index = cursor.getColumnIndex("block_code");
                int blockCode = cursor.getInt(blockCode_index);
                availableBlockList.add(blockCode);
            } while(cursor.moveToNext());

            cursor.close();
            return availableBlockList;
        }
        else {
            return null;
        }
    }
    public Cursor getAvailableSubjects(SQLiteDatabase db, int blockCode) {
        String query = "SELECT * FROM Subjects WHERE block_code = ?;";
        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(blockCode)});
        if(cursor != null) {
            return cursor;
        }
        else {
            return null;
        }
    }
    public void showBlockSubject(SQLiteDatabase db, int blockCode) {
        LinearLayout linearSubjectShow = findViewById(R.id.linearSubjectShow);
        linearSubjectShow.removeAllViews(); //remove all exiting subject views on every button click, then repopulate
        Cursor availableSubjects = getAvailableSubjects(db, blockCode);
        selectedBlockCode = blockCode;

        Button btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setVisibility(View.VISIBLE);

        //DIMENSION CONVERSION (dp to pixel)
        float widthDP = 150f;
        float heightDP = 40f;
        float scale = getResources().getDisplayMetrics().density;
        int widthPX = (int) (widthDP * scale + 0.5f);
        int heightPX = (int) (heightDP * scale + 0.5f);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(widthPX, heightPX);

<<<<<<< HEAD
        if(availableSubjects != null && availableSubjects.moveToFirst()) {
            do {
                int subjectCode_index = availableSubjects.getColumnIndex("subject_code");
                int subjectName_index = availableSubjects.getColumnIndex("subject_name");
                int sectionCode_index = availableSubjects.getColumnIndex("section_code");
                int subjectSchedule_index = availableSubjects.getColumnIndex("subject_schedule");
                String subjectCode = availableSubjects.getString(subjectCode_index);
                String subjectName = availableSubjects.getString(subjectName_index);
                String sectionCode = availableSubjects.getString(sectionCode_index);
                String subjectSchedule = availableSubjects.getString(subjectSchedule_index);
=======
        for (String subject : subjectList) {
            View itemView = getLayoutInflater().inflate(R.layout.layout_grade_panel, null);
            TextView titleTextView = itemView.findViewById(R.id.lblSubject);
>>>>>>> b5d2dc3 (malapit na q mamatai)

                View itemView = getLayoutInflater().inflate(R.layout.layout_subject_register, null);

                TextView lblSubjectCode = itemView.findViewById(R.id.lblSubjectCodePlaceholder);
                TextView lblSubjectName = itemView.findViewById(R.id.lblSubjectNamePlaceholder);
                TextView lblSectionCode = itemView.findViewById(R.id.lblSubjectSectionPlaceholder);
                TextView lblSubjectSched = itemView.findViewById(R.id.lblSubjectSchedulePlaceholder);

                lblSubjectCode.setText(subjectCode);
                lblSubjectName.setText(subjectName);
                lblSectionCode.setText(sectionCode);
                lblSubjectSched.setText(subjectSchedule);

                itemView.setLayoutParams(layoutParams);
                linearSubjectShow.addView(itemView);
                availableSubjects.moveToNext();
            } while (availableSubjects.moveToNext());
            availableSubjects.close();
        }
    }
    public void addToEnrollment(SQLiteDatabase db, int studentID, int blockCode) {
        ContentValues values = new ContentValues();
        values.put("student_id", studentID);
        values.put("block_code", blockCode);
        long newStudentId = db.insert("Enrollments", null, values);
        if (newStudentId != -1) {
            Log.d("ENROLLMENT SUCCESSFUL", "Enrollment successful!");
        } else {
            Log.d("ENROLLMENT FAILED", "Enrollment failed.");
        }
    }
    public void goBackToMainMenu(View v) {
        //IMPORTANT: This clears all of the previous activities from the stack so that you can't go back to the enrollment pages
        Intent intent = new Intent(this, MainMenu.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}