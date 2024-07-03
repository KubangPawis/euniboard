package com.example.euniboard;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public abstract class DBHandler extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "EnvergaInfo.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TB_STUDENT_INFO = "StudentInfo";
    private static final String TB_BLOCK_SECTION = "BlockSection";
    private static final String TB_FACULTY = "Faculty";
    private static final String TB_SUBJECTS = "Subjects";
    private static final String TB_ENROLLMENTS = "Enrollments";
    private static final String TB_GRADES = "Grades";
    private static final String TB_PAYMENTS = "Payments";
    private static final String COLUMN_STUDENT_ID = "student_id";
    private static final String COLUMN_LAST_NAME = "last_name";
    private static final String COLUMN_FIRST_NAME = "first_name";
    private static final String COLUMN_MIDDLE_NAME = "middle_name";
    private static final String COLUMN_BIRTH_DATE = "birth_date";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_YEAR_LEVEL = "year_level";
    private static final String COLUMN_PROGRAM = "program";
    private static final String COLUMN_SPECIALIZATION = "specialization";
    private static final String COLUMN_AGE = "age";
    private static final String COLUMN_SEX = "sex";
    private static final String COLUMN_RELIGION = "religion";
    private static final String COLUMN_CITIZENSHIP = "citizenship";
    private static final String COLUMN_FULL_ADDRESS = "full_address";
    private static final String COLUMN_ZIP_CODE = "zip_code";
    private static final String COLUMN_MOBILE_NUMBER = "mobile_number";
    private static final String COLUMN_ELEM_SCHOOL = "elem_school";
    private static final String COLUMN_ELEM_GRADE = "elem_grade";
    private static final String COLUMN_JHS_SCHOOL = "jhs_school";
    private static final String COLUMN_JHS_GRADE = "jhs_grade";
    private static final String COLUMN_SHS_SCHOOL = "shs_school";
    private static final String COLUMN_SHS_GRADE = "shs_grade";
    private static final String COLUMN_BLOCK_CODE = "block_code";
    private static final String COLUMN_BLOCK_NAME = "block_name";
    private static final String COLUMN_SEMESTER = "semester";
    private static final String COLUMN_FACULTY_ID = "faculty_id";
    private static final String COLUMN_FACULTY_NAME = "faculty_name";
    private static final String COLUMN_SUBJECT_ID = "subject_id";
    private static final String COLUMN_SUBJECT_CODE = "subject_code";
    private static final String COLUMN_SUBJECT_NAME = "subject_name";
    private static final String COLUMN_SUBJECT_SCHEDULE = "subject_schedule";
    private static final String COLUMN_SECTION_CODE = "section_code";
    private static final String COLUMN_ENROLLMENT_ID = "enrollment_id";
    private static final String COLUMN_GRADE_ID = "grade_id";
    private static final String COLUMN_GRADE = "grade";
    private static final String COLUMN_PAYMENT_ID = "payment_id";
    private static final String COLUMN_DATE_PAID = "date_paid";
    private static final String COLUMN_BALANCE = "remaining_balance";
    private static final String COLUMN_AMOUNT_PAID = "amount_paid";
    private static final String COLUMN_PAYMENT_REMARKS = "payment_remarks";

    private String[] blockNames = {"Block 1", "Block 2"};
    private String[] subjectCodes = {"CP100", "CP101", "CSMAT100", "CSPY100", "ENG100", "EU111", "MAMW100", "NROTC1", "NSTP1",
            "PE01", "SOC100", "COM100", "CP102", "CSDS101", "CSMAT101", "EU112", "NROTC2", "NSTP2",
            "PE02", "SOC101", "CP103", "CSDS102", "CSMAT102", "CSNC101", "CSOP01", "HUM100", "PE03", "SOC102"};
    private String[] subjectNames = {"Introduction to Computing", "Computer Programming 1",
            "Pre-Calculus for Non STEM", "General Physics for Non STEM", "English Enhancement Course", "The University and I",
            "Mathematics in the Modern World", "Naval Res Officer Trng Course 1", "National Service Training Program 1",
            "Physical Activities Toward Health", "Understanding the Self", "Purposive Communication", "Computer Programming 2",
            "Discrete Structures 1", "College Algebra", "The Family", "Naval Res Officer Trng Course 2", "National Service Training Program 2",
            "Physical Activities Toward Health", "Readings in Philippine History", "Data Structures and Algorithm", "Discrete Structures 1", "Calculus", "Network and Communication",
            "Object-Oriented Programming", "Art Appreciation", "Physical Activities Toward Health", "The Contemporary World"};
    private String[] facultyList = {"Rodrigo Belleza Jr.", "Jose Tan Jr.", "Susan De Castro", "Donna Hernandez", "Cheeky Rose Villamarzo", "Alexander Maralit II",
            "Joshua Michael Saberon", "Ashiel Bagnes", "Diane Matira", "Josephine Belen", "Victor Oribe", "Marie Grace Jasolin", "Cresencio Jaballa",
            "Decca Patricia Driz", "Hubert Loresto", "Macaulay Bagnate", "John Kristoffer Tibor", "Joel Rex Villasin", "Frisian Cruz"};
    private int years = 4;
    protected DBHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        createStudentInfoTable(db);
        createBlockSection(db);
        createFaculty(db);
        createSubject(db);
        createEnrollments(db);
        createGrades(db);
        createPayments(db);
    }
    public void createStudentInfoTable(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TB_STUDENT_INFO
                + " (" + COLUMN_STUDENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_LAST_NAME + " TEXT, "
                + COLUMN_FIRST_NAME + " TEXT, "
                + COLUMN_MIDDLE_NAME + " TEXT, "
                + COLUMN_BIRTH_DATE + " TEXT, "
                + COLUMN_EMAIL + " TEXT UNIQUE, "
                + COLUMN_PASSWORD + " TEXT, "
                + COLUMN_YEAR_LEVEL + " INTEGER, "
                + COLUMN_SEMESTER + " INTEGER, "
                + COLUMN_PROGRAM + " TEXT, "
                + COLUMN_SPECIALIZATION + " TEXT, "
                + COLUMN_AGE + " INTEGER, "
                + COLUMN_SEX + " TEXT, "
                + COLUMN_RELIGION + " TEXT, "
                + COLUMN_CITIZENSHIP + " TEXT, "
                + COLUMN_FULL_ADDRESS + " TEXT, "
                + COLUMN_ZIP_CODE + " TEXT, "
                + COLUMN_MOBILE_NUMBER + " TEXT, "
                + COLUMN_ELEM_SCHOOL + " TEXT, "
                + COLUMN_ELEM_GRADE + " DOUBLE, "
                + COLUMN_JHS_SCHOOL + " TEXT, "
                + COLUMN_JHS_GRADE + " DOUBLE, "
                + COLUMN_SHS_SCHOOL + " TEXT, "
                + COLUMN_SHS_GRADE + " DOUBLE)";
        db.execSQL(query);
    }
    public void createBlockSection(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TB_BLOCK_SECTION
                + " (" + COLUMN_BLOCK_CODE + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_BLOCK_NAME + " TEXT, "
                + COLUMN_SEMESTER + " INTEGER, "
                + COLUMN_YEAR_LEVEL + " INTEGER) ";
        db.execSQL(query);
    }
    public void createFaculty(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TB_FACULTY
                + " (" + COLUMN_FACULTY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_FACULTY_NAME + " TEXT)";
        db.execSQL(query);
    }
    public void createSubject(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TB_SUBJECTS
                + " (" + COLUMN_SUBJECT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_SUBJECT_CODE + " TEXT, "
                + COLUMN_SUBJECT_NAME + " TEXT, "
                + COLUMN_SEMESTER + " INTEGER, "
                + COLUMN_BLOCK_CODE + " INTEGER, "
                + COLUMN_SUBJECT_SCHEDULE + " TEXT, "
                + COLUMN_FACULTY_ID + " INTEGER, "
                + COLUMN_SECTION_CODE + " TEXT, "
                + "FOREIGN KEY (block_code) REFERENCES BlockSection(block_code),"
                + "FOREIGN KEY (faculty_id) REFERENCES Faculty(faculty_id)"
                + ") ";
        db.execSQL(query);
    }
    public void createEnrollments(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TB_ENROLLMENTS
                + " (" + COLUMN_ENROLLMENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_STUDENT_ID + " INTEGER, "
                + COLUMN_BLOCK_CODE + " INTEGER, "
                + "FOREIGN KEY (student_id) REFERENCES StudentInfo(student_id),"
                + "FOREIGN KEY (block_code) REFERENCES BlockSection(block_code)"
                + " )";
        db.execSQL(query);
    }
    public void createGrades(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TB_GRADES
                + " (" + COLUMN_GRADE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_STUDENT_ID + " INTEGER, "
                + COLUMN_SUBJECT_ID + " INTEGER, "
                + COLUMN_GRADE + " REAL, "
                + COLUMN_SEMESTER + " INTEGER, "
                + "FOREIGN KEY (student_id) REFERENCES StudentInfo(student_id),"
                + "FOREIGN KEY (subject_id) REFERENCES Subjects(subject_id) )";
        db.execSQL(query);
    }
    public void createPayments(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TB_PAYMENTS
                + " (" + COLUMN_PAYMENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_STUDENT_ID + " INTEGER, "
                + COLUMN_DATE_PAID + " TEXT, "
                + COLUMN_AMOUNT_PAID + " REAL, "
                + COLUMN_BALANCE + " REAL, "
                + COLUMN_PAYMENT_REMARKS + " TEXT, "
                + COLUMN_SEMESTER + " INTEGER)";
        db.execSQL(query);
    }
    public void inputBlockValues(SQLiteDatabase db) {
        for(int i=0; i<years; i++) {
            for (String block : blockNames) {
                String query = "INSERT INTO " + TB_BLOCK_SECTION
                        + " (" + COLUMN_BLOCK_NAME + ", " + COLUMN_YEAR_LEVEL + ") VALUES"
                        + " ('" + block + "', " + (i+1) + "); ";
                db.execSQL(query);
            }
        }
    }
    public void inputFacultyValues(SQLiteDatabase db) {
        for (String faculty : facultyList) {
            String query = "INSERT INTO " + TB_FACULTY
                    + " (" + COLUMN_FACULTY_NAME + ") VALUES"
                    + " ('" + faculty + "');";
            db.execSQL(query);
        }
    }
    public void inputSubjectValues(SQLiteDatabase db, String inputSubjCode, String inputSubjName, int inputBlockCode, String inputSubjSched, int facultyId, String inputSectionCode) {
        String query = "INSERT INTO " + TB_SUBJECTS
                + " (" + COLUMN_SUBJECT_CODE + ", " + COLUMN_SUBJECT_NAME + ", "
                + COLUMN_BLOCK_CODE + ", " + COLUMN_SUBJECT_SCHEDULE + ", "
                + COLUMN_FACULTY_ID + ", " + COLUMN_SECTION_CODE + ") VALUES"
                + " (" + inputSubjCode + ", " + inputSubjName + ", "
                + inputBlockCode + ", " + inputSubjSched + ", "
                + facultyId + ", " + inputSectionCode + ");";
        db.execSQL(query);
    }
    public void inputEnrollmentValues(SQLiteDatabase db, int inputStudentId, int inputBlockCode) {
        String query = "INSERT INTO " + TB_ENROLLMENTS
                + " (" + COLUMN_STUDENT_ID + ", " + COLUMN_BLOCK_CODE + ") VALUES"
                + " (" + inputStudentId + ", " + inputBlockCode + ");";
        db.execSQL(query);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}