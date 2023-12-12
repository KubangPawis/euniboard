package com.example.euniboard;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ViewSubjects extends AppCompatActivity {
    StudentHandler viewSubjectsStudent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_subjects);

        viewSubjectsStudent = new StudentHandler(this);
        SQLiteDatabase db = viewSubjectsStudent.getReadableDatabase();

        Intent intent = getIntent();
        CurrentStudent loggedStudent = intent.getParcelableExtra("currently_logged_student");
        int studentID = loggedStudent.getStudentID();

        //ENROLLMENT CHECK -> if student is enrolled, allow display of grades!
        boolean enrollmentChecker = isCurrentlyEnrolled(db, studentID);
        if(enrollmentChecker) {
            int currentStudentBlock = getStudentBlockCode(db, studentID);
            openSubjectsAvailable(loggedStudent, currentStudentBlock);
        }
        else {
            openSubjectsNotAvailable();
        }

        //EVENTS
        ImageView btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(e -> goToRegisterSubjects(e, loggedStudent));
    }

    public void openSubjectsAvailable(CurrentStudent loggedStudent, int blockCode) {
        SubjectsAvailableFragment frag = new SubjectsAvailableFragment();
        Bundle studentBundle = new Bundle();
        studentBundle.putParcelable("currently_logged_student", loggedStudent);
        studentBundle.putInt("student_block_code", blockCode);
        frag.setArguments(studentBundle);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, frag)
                .commit();
    }
    public void openSubjectsNotAvailable() {
        SubjectsNA_Fragment frag = new SubjectsNA_Fragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, frag)
                .commit();
    }
    public boolean isCurrentlyEnrolled(SQLiteDatabase db, int studentID) {
        String query = "SELECT COUNT(*) FROM Enrollments WHERE student_id = ?";
        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(studentID)});

        if(cursor != null && cursor.moveToFirst()) {
            int count = cursor.getInt(0);
            cursor.close();
            return count > 0;
        }
        return false;
    }
    public int getStudentBlockCode(SQLiteDatabase db, int studentID) {
        String query = "SELECT block_code FROM Enrollments WHERE student_id = ?";
        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(studentID)});

        if(cursor != null && cursor.moveToFirst()) {
            int blockCode_index = cursor.getColumnIndex("block_code");
            int blockCode = cursor.getInt(blockCode_index);
            cursor.close();
            return blockCode;
        }
        return -1;
    }
    public void goToRegisterSubjects(View v, CurrentStudent loggedStudent) {
        Intent intent = new Intent(this, RegisterSubject.class);
        intent.putExtra("currently_logged_student", loggedStudent);
        startActivity(intent);
    }
}