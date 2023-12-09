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
    private static final String TABLE_NAME = "StudentInfo";
    private static final String COLUMN_ID = "user_id";
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

    protected DBHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME
                + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
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
                + COLUMN_MOBILE_NUMBER + " TEXT)";
        db.execSQL(query);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
//        onCreate(db);
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
