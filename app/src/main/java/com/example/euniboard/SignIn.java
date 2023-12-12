package com.example.euniboard;

import android.content.Intent;
import android.database.Cursor;
import android.database.CursorWindowAllocationException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SignIn extends AppCompatActivity {
    StudentHandler studentLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        studentLogin = new StudentHandler(this);
        SQLiteDatabase db = studentLogin.getReadableDatabase();

        //EVENTS
        EditText txtEmail = findViewById(R.id.txtEmail);
        EditText txtPassword = findViewById(R.id.txtPassword);
        Button btnSignIn = findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputEmail = String.valueOf(txtEmail.getText());
                String inputPassword = String.valueOf(txtPassword.getText());
                Cursor userChecker = authenticateUser(db, inputEmail, inputPassword);

                if(userChecker != null) {
                    int studentID_index = userChecker.getColumnIndex("student_id");
                    int lastName_index = userChecker.getColumnIndex("last_name");
                    int firstName_index = userChecker.getColumnIndex("first_name");
                    int middleName_index = userChecker.getColumnIndex("middle_name");
                    int birthDate_index = userChecker.getColumnIndex("birth_date");
                    int email_index = userChecker.getColumnIndex("email");
                    int password_index = userChecker.getColumnIndex("password");
                    int yearLevel_index = userChecker.getColumnIndex("year_level");
                    int semester_index = userChecker.getColumnIndex("semester");
                    int program_index = userChecker.getColumnIndex("program");
                    int specialization_index = userChecker.getColumnIndex("specialization");
                    int age_index = userChecker.getColumnIndex("age");
                    int sex_index = userChecker.getColumnIndex("sex");
                    int religion_index = userChecker.getColumnIndex("religion");
                    int citizenship_index = userChecker.getColumnIndex("citizenship");
                    int fullAddress_index = userChecker.getColumnIndex("full_address");
                    int zipCode_index = userChecker.getColumnIndex("zip_code");
                    int mobileNumber_index = userChecker.getColumnIndex("mobile_number");
                    int elemSchool_index = userChecker.getColumnIndex("elem_school");
                    int elemGWA_index = userChecker.getColumnIndex("elem_grade");
                    int jhSchool_index = userChecker.getColumnIndex("jhs_school");
                    int jhsGWA_index = userChecker.getColumnIndex("jhs_grade");
                    int shSchool_index = userChecker.getColumnIndex("shs_school");
                    int shsGWA_index = userChecker.getColumnIndex("shs_grade");

                    if(studentID_index != -1) {
                        int studentID = userChecker.getInt(studentID_index);
                        String lastName = userChecker.getString(lastName_index);
                        String firstName = userChecker.getString(firstName_index);
                        String middleName = userChecker.getString(middleName_index);
                        String birthDate = userChecker.getString(birthDate_index);
                        String email = userChecker.getString(email_index);
                        String password = userChecker.getString(password_index);
                        int yearLevel = userChecker.getInt(yearLevel_index);
                        int semester = userChecker.getInt(semester_index);
                        String program = userChecker.getString(program_index);
                        String specialization = userChecker.getString(specialization_index);
                        int age = userChecker.getInt(age_index);
                        String sex = userChecker.getString(sex_index);
                        String religion = userChecker.getString(religion_index);
                        String citizenship = userChecker.getString(citizenship_index);
                        String fullAddress = userChecker.getString(fullAddress_index);
                        String zipCode = userChecker.getString(zipCode_index);
                        String mobileNumber = userChecker.getString(mobileNumber_index);
                        String elemSchool = userChecker.getString(elemSchool_index);
                        double elemGrade = userChecker.getDouble(elemGWA_index);
                        String jhSchool = userChecker.getString(jhSchool_index);
                        double jhsGrade = userChecker.getDouble(jhsGWA_index);
                        String shSchool = userChecker.getString(shSchool_index);
                        double shsGrade = userChecker.getDouble(shsGWA_index);

                        CurrentStudent loggedStudent = new CurrentStudent(studentID, lastName, firstName, middleName, birthDate, email, password, yearLevel, semester,program, specialization, age, sex, religion, citizenship, fullAddress, zipCode, mobileNumber, elemSchool, elemGrade, jhSchool, jhsGrade, shSchool, shsGrade);
                        userChecker.close();
                        goToMainMenu(v, loggedStudent);
                    }
                }
                else {
                    //SHOW ERROR MESSAGE
                    Log.d("ERROR!!!", "User was not found!!");
                }
            }
        });
    }
    public Cursor getUserData(SQLiteDatabase db, String inputEmail, String inputPassword) {
        String query = "SELECT * FROM StudentInfo WHERE email = ? AND password = ?";
        String[] selectionArgs = {inputEmail, inputPassword};

        return db.rawQuery(query, selectionArgs);

    }

    public Cursor authenticateUser(SQLiteDatabase db, String inputEmail, String inputPassword) {
        Cursor userCursor = getUserData(db, inputEmail, inputPassword); //get email and password matches from database
        boolean isAuthenticated = userCursor.moveToFirst(); // Move to the first row and this will return TRUE if the cursor has data
        if(isAuthenticated) {
            return userCursor; //if it authenticates, return the userCursor with the user's data list!
        }
        else {
            //RETURN ERROR MESSAGE
            return null;
        }
    }
    public void goToMainMenu(View v, CurrentStudent student) {
        Intent intent = new Intent(this, MainMenu.class);
        intent.putExtra("currently_logged_student", student);
        startActivity(intent);
    }
}