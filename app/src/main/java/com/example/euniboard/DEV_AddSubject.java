package com.example.euniboard;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class DEV_AddSubject extends AppCompatActivity {
    Student addSubject = new Student(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dev_activity_input_subjects);

        //EVENTS
        Button btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(e -> addSubject());
    }

    public void addSubject() {
        SQLiteDatabase db = addSubject.getWritableDatabase();

        EditText txtSubjectName = findViewById(R.id.txtSubjectName);
        EditText txtSubjectCode = findViewById(R.id.txtSubjectCode);
        EditText txtBlockCode = findViewById(R.id.txtBlockCode);
        EditText txtSubjectSchedule = findViewById(R.id.txtSubjectSchedule);
        EditText txtFacultyID = findViewById(R.id.txtFacultyID);
        EditText txtSectionCode = findViewById(R.id.txtSectionCode);

        String subjectName = "'" + txtSubjectName.getText() + "'";
        String subjectCode = "'" + txtSubjectCode.getText() + "'";
        int blockCode = Integer.parseInt(String.valueOf(txtBlockCode.getText()));
        String subjectSchedule = "'" + txtSubjectSchedule.getText() + "'";
        int facultyID = Integer.parseInt(String.valueOf(txtFacultyID.getText()));
        String sectionCode = "'" + txtSectionCode.getText() + "'";

        addSubject.inputSubjectValues(db, subjectCode, subjectName, blockCode, subjectSchedule, facultyID, sectionCode);
        Log.d("SUBJECT ADDED", "Subject was added to the database!");
    }
}