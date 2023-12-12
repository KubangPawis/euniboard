package com.example.euniboard;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class CurrentStudent implements Parcelable {
    private String lastName, firstName, middleName, birthDate, email, password, program, specialization, sex, religion, citizenship, fullAddress, zipCode, mobileNumber, elemSchool, jhSchool, shSchool;
    private int studentID, yearLevel, semester, age;
    private double elemGWA, jhsGWA, shsGWA;
    CurrentStudent(int studentID, String lastName, String firstName, String middleName, String birthDate, String email, String password, int yearLevel, int semester, String program, String specialization, int age, String sex, String religion, String citizenship, String fullAddress, String zipCode, String mobileNumber, String elemSchool, double elemGWA, String jhSchool, double jhsGWA, String shSchool, double shsGWA) {
        this.studentID = studentID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
        this.yearLevel = yearLevel;
        this.semester = semester;
        this.program = program;
        this.specialization = specialization;
        this.age = age;
        this.sex = sex;
        this.religion = religion;
        this.citizenship = citizenship;
        this.fullAddress = fullAddress;
        this.zipCode = zipCode;
        this.mobileNumber = mobileNumber;
        this.elemSchool = elemSchool;
        this.elemGWA = elemGWA;
        this.jhSchool = jhSchool;
        this.jhsGWA = jhsGWA;
        this.shSchool = shSchool;
        this.shsGWA = shsGWA;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getElemSchool() {
        return elemSchool;
    }

    public void setElemSchool(String elemSchool) {
        this.elemSchool = elemSchool;
    }

    public String getJhSchool() {
        return jhSchool;
    }

    public void setJhSchool(String jhSchool) {
        this.jhSchool = jhSchool;
    }

    public String getShSchool() {
        return shSchool;
    }

    public void setShSchool(String shSchool) {
        this.shSchool = shSchool;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getYearLevel() {
        return yearLevel;
    }

    public void setYearLevel(int yearLevel) {
        this.yearLevel = yearLevel;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getElemGWA() {
        return elemGWA;
    }

    public void setElemGWA(double elemGWA) {
        this.elemGWA = elemGWA;
    }

    public double getJhsGWA() {
        return jhsGWA;
    }

    public void setJhsGWA(double jhsGWA) {
        this.jhsGWA = jhsGWA;
    }

    public double getShsGWA() {
        return shsGWA;
    }

    public void setShsGWA(double shsGWA) {
        this.shsGWA = shsGWA;
    }

    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(this.studentID);
        dest.writeString(this.lastName);
        dest.writeString(this.firstName);
        dest.writeString(this.middleName);
        dest.writeString(this.birthDate);
        dest.writeString(this.email);
        dest.writeString(this.password);
        dest.writeInt(this.yearLevel);
        dest.writeInt(this.semester);
        dest.writeString(this.program);
        dest.writeString(this.specialization);
        dest.writeInt(this.age);
        dest.writeString(this.sex);
        dest.writeString(this.religion);
        dest.writeString(this.citizenship);
        dest.writeString(this.fullAddress);
        dest.writeString(this.zipCode);
        dest.writeString(this.mobileNumber);
        dest.writeString(this.elemSchool);
        dest.writeDouble(this.elemGWA);
        dest.writeString(this.jhSchool);
        dest.writeDouble(this.jhsGWA);
        dest.writeString(this.shSchool);
        dest.writeDouble(this.shsGWA);
    }
    public static final Parcelable.Creator<CurrentStudent> CREATOR = new Parcelable.Creator<CurrentStudent>() {
        @Override
        public CurrentStudent createFromParcel(Parcel in) {
            return new CurrentStudent(in);
        }

        @Override
        public CurrentStudent[] newArray(int size) {
            return new CurrentStudent[size];
        }
    };
    protected CurrentStudent(Parcel in) {
        this.studentID = in.readInt();
        this.lastName = in.readString();
        this.firstName = in.readString();
        this.middleName = in.readString();
        this.birthDate = in.readString();
        this.email = in.readString();
        this.password = in.readString();
        this.yearLevel = in.readInt();
        this.semester = in.readInt();
        this.program = in.readString();
        this.specialization = in.readString();
        this.age = in.readInt();
        this.sex = in.readString();
        this.religion = in.readString();
        this.citizenship = in.readString();
        this.fullAddress = in.readString();
        this.zipCode = in.readString();
        this.mobileNumber = in.readString();
        this.elemSchool = in.readString();
        this.elemGWA = in.readDouble();
        this.jhSchool = in.readString();
        this.jhsGWA = in.readDouble();
        this.shSchool = in.readString();
        this.shsGWA = in.readDouble();
    }
}
