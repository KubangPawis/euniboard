package com.example.euniboard;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class Student extends DBHandler {


    //CONSTRUCTOR FOR INSERTING STUDENT DATA TO DATABASE
    public Student(@Nullable Context context, String lastName, String firstName, String middleName, String birthDate, String email, String password, int yearLevel, String program, String specialization, int age, String sex, String religion, String citizenship, String fullAddress, String zipCode, String mobileNumber, String elemSchool, double elemGWA, String jhSchool, double jhsGWA, String shSchool, double shsGWA) {
        super(context);
        addStudent(lastName, firstName, middleName, birthDate, email, password, yearLevel, program, specialization, age, sex, religion, citizenship, fullAddress, zipCode, mobileNumber, elemSchool, elemGWA, jhSchool, jhsGWA, shSchool, shsGWA);
    }

    protected void addStudent(String lastName, String firstName, String middleName, String birthDate, String email, String password, int yearLevel, String program, String specialization, int age, String sex, String religion, String citizenship, String fullAddress, String zipCode, String mobileNumber, String elemSchool, double elemGWA, String jhSchool, double jhsGWA, String shSchool, double shsGWA) {
        ContentValues studentInfo = new ContentValues();
        studentInfo.put("last_name", lastName);
        studentInfo.put("first_name", firstName);
        studentInfo.put("middle_name", middleName);
        studentInfo.put("birth_date", birthDate);
        studentInfo.put("email", email);
        studentInfo.put("password", password);
        studentInfo.put("year_level", yearLevel);
        studentInfo.put("program", program);
        studentInfo.put("specialization", specialization);
        studentInfo.put("age", age);
        studentInfo.put("sex", sex);
        studentInfo.put("religion", religion);
        studentInfo.put("citizenship", citizenship);
        studentInfo.put("full_address", fullAddress);
        studentInfo.put("zip_code", zipCode);
        studentInfo.put("mobile_number", mobileNumber);
        studentInfo.put("elementary_school", elemSchool);
        studentInfo.put("elem_gwa", elemGWA);
        studentInfo.put("jh_school", jhSchool);
        studentInfo.put("jhs_gwa", jhsGWA);
        studentInfo.put("sh_school", shSchool);
        studentInfo.put("shs_gwa", shsGWA);

        SQLiteDatabase db = this.getWritableDatabase();
        long newStudentId = db.insert("StudentInfo", null, studentInfo);

        if (newStudentId != -1) {
            // Insertion successful
        } else {
            // Insertion failed
        }
    }
}
