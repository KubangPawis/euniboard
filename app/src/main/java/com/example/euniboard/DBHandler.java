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
    private static final String COLUMN_FACULTY_ID = "faculty_id";
    private static final String COLUMN_FACULTY_FIRSTNAME = "faculty_firstName";
    private static final String COLUMN_FACULTY_LASTNAME = "faculty_lastName";
    private static final String COLUMN_SUBJECT_ID = "subject_id";
    private static final String COLUMN_SUBJECT_NAME = "subject_name";
    private static final String COLUMN_SUBJECT_SCHEDULE = "subject_schedule";
    private static final String COLUMN_SECTION_CODE = "section_code";
    private static final String COLUMN_ENROLLMENT_ID = "enrollment_id";


    protected DBHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        createStudentInfoTable(db);
<<<<<<< HEAD
        createBlockSection(db);
        createFaculty(db);
        createSubject(db);
        createEnrollments(db);
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
=======
>>>>>>> 77beac9 (wutdahel omahgad nowayay~)
    }
    public void createBlockSection(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TB_BLOCK_SECTION
                + " (" + COLUMN_BLOCK_CODE + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_BLOCK_NAME + " TEXT, "
                + COLUMN_YEAR_LEVEL + " INTEGER)";
    }
    public void createFaculty(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TB_FACULTY
                + " (" + COLUMN_FACULTY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_FACULTY_FIRSTNAME + " TEXT, "
                + COLUMN_FACULTY_LASTNAME + " TEXT)";
    }
    public void createSubject(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TB_SUBJECTS
                + " (" + COLUMN_SUBJECT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_SUBJECT_NAME + " TEXT, "
                + COLUMN_BLOCK_CODE + " INTEGER, "
                + COLUMN_SUBJECT_SCHEDULE + " TEXT, "
                + COLUMN_FACULTY_ID + "INTEGER, "
                + COLUMN_SECTION_CODE + " TEXT, "
                + "FOREIGN KEY (block_code) REFERENCES BlockSection(block_code),"
                + "FOREIGN KEY (faculty_id) REFERENCES Faculty(faculty_id)"
                + ") ";
    }
    public void createEnrollments(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TB_ENROLLMENTS
                + " (" + COLUMN_ENROLLMENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_STUDENT_ID + " INTEGER, "
                + COLUMN_BLOCK_CODE + " INTEGER, "
                + "FOREIGN KEY (student_id) REFERENCES StudentInfo(student_id),"
                + "FOREIGN KEY (block_code) REFERENCES BlockSection(block_code)"
                + " )";
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void createStudentInfoTable(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_LAST_NAME + " TEXT, " +
                COLUMN_FIRST_NAME + " TEXT, " +
                COLUMN_MIDDLE_NAME + " TEXT, " +
                COLUMN_BIRTH_DATE + " TEXT, " +
                COLUMN_EMAIL + " TEXT UNIQUE, " +
                COLUMN_PASSWORD + " TEXT, " +
                COLUMN_YEAR_LEVEL + " INTEGER, " +
                COLUMN_PROGRAM + " TEXT, " +
                COLUMN_SPECIALIZATION + " TEXT, " +
                COLUMN_AGE + " INTEGER, " +
                COLUMN_SEX + " TEXT, " +
                COLUMN_RELIGION + " TEXT, " +
                COLUMN_CITIZENSHIP + " TEXT, " +
                COLUMN_FULL_ADDRESS + " TEXT, " +
                COLUMN_ZIP_CODE + " TEXT, " +
                COLUMN_MOBILE_NUMBER + " TEXT, " +
                COLUMN_ELEM_SCHOOL + " TEXT, " +
                COLUMN_ELEM_GRADE + " DOUBLE, " +
                COLUMN_JHS_SCHOOL + " TEXT, " +
                COLUMN_JHS_GRADE + " DOUBLE, " +
                COLUMN_SHS_SCHOOL + " TEXT, " +
                COLUMN_SHS_GRADE + " DOUBLE" +
                ")";
        db.execSQL(query);
    }
    private void createSubjectBlockTable(SQLiteDatabase db) {
        String createTableSQL = "CREATE TABLE SubjectBlock (" +
                "BlockID INTEGER PRIMARY KEY," +
                "BlockName TEXT" +
                ")";
        db.execSQL(createTableSQL);
    }
    private void createSubjectEnrollmentTable(SQLiteDatabase db) {
        String createTableSQL = "CREATE TABLE SubjectEnrollment (" +
                "EnrollmentID INTEGER PRIMARY KEY," +
                "Email TEXT," +
                "BlockID INTEGER," +
                "SubjectName TEXT," +
                "FOREIGN KEY (Email) REFERENCES StudentInfo(Email)," +
                "FOREIGN KEY (BlockID) REFERENCES SubjectBlock(BlockID)" +
                ")";
        db.execSQL(createTableSQL);
    }
    private void createScheduleTable(SQLiteDatabase db) {
        String createTableSQL = "CREATE TABLE Schedule (" +
                "ScheduleID INTEGER PRIMARY KEY," +
                "BlockID INTEGER," +
                "SubjectName TEXT," +
                "DayOfWeek TEXT," +
                "StartTime TEXT," +
                "EndTime TEXT," +
                // Other schedule details
                "FOREIGN KEY (BlockID) REFERENCES SubjectBlock(BlockID)" +
                ")";
        db.execSQL(createTableSQL);
    }

    private void createProfessorTable(SQLiteDatabase db) {
        String createTableSQL = "CREATE TABLE Professor (" +
                "ProfessorID INTEGER PRIMARY KEY," +
                "ProfessorName TEXT" +
                ")";
        db.execSQL(createTableSQL);
    }



    public void exportDatabase(@Nullable Context context) {
        try {
            File dbFile = context.getDatabasePath("EnvergaInfo.db"); // Replace with your database name
            FileInputStream fis = new FileInputStream(dbFile);

            String exportDir = Environment.getExternalStorageDirectory() + File.separator + "YourAppFolder"; // Replace with your folder name
            File directory = new File(exportDir);

            if (!directory.exists()) {
                directory.mkdirs();
            }

            String backupPath = exportDir + File.separator + "exported_database.db"; // Replace with the desired exported database file name
            FileOutputStream fos = new FileOutputStream(backupPath);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }

            fos.flush();
            fos.close();
            fis.close();

            // Show a message or log indicating successful export
            Toast.makeText(context, "Database exported to: " + backupPath, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception
        }
    }
}
