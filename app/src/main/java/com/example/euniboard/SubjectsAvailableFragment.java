package com.example.euniboard;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class SubjectsAvailableFragment extends Fragment {
    StudentHandler showStudentSubject;
    public SubjectsAvailableFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_subjects_available, container, false);
        showStudentSubject = new StudentHandler(getActivity());
        SQLiteDatabase db = showStudentSubject.getReadableDatabase();

        //EVENTS
        Bundle args = getArguments(); //Pass in data to the current fragment
        int currentBlockCode = args.getInt("student_block_code");
        Log.d("BLOCK CODE", "Block Code: " + currentBlockCode);

        Cursor studentBlockSubjects = getAvailableSubjects(db, currentBlockCode);

        //DIMENSION CONVERSION (dp to pixel)
        float widthDP = 300f;
        float heightDP = 111f;
        float scale = getResources().getDisplayMetrics().density;
        int widthPX = (int) (widthDP * scale + 0.5f);
        int heightPX = (int) (heightDP * scale + 0.5f);

        LinearLayout linearSubjects = rootView.findViewById(R.id.linearSubjects);
        linearSubjects.removeAllViews(); //remove all exiting subject views on every button click, then repopulate
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(widthPX, heightPX);
        layoutParams.setMargins(0,0,0,60);

        if(studentBlockSubjects != null && studentBlockSubjects.moveToFirst()) {
            do {
                Log.d("SUBJECT CHECK", "One ping!");
                int subjectName_index = studentBlockSubjects.getColumnIndex("subject_name");
                int sectionCode_index = studentBlockSubjects.getColumnIndex("section_code");
                int subjectSchedule_index = studentBlockSubjects.getColumnIndex("subject_schedule");
                String subjectName = studentBlockSubjects.getString(subjectName_index);
                String sectionCode = studentBlockSubjects.getString(sectionCode_index);
                String subjectSchedule = studentBlockSubjects.getString(subjectSchedule_index);

                View itemView = getLayoutInflater().inflate(R.layout.layout_subject_panel, null);

                TextView lblSubjectName = itemView.findViewById(R.id.lblSubjectName);
                TextView lblSectionCode = itemView.findViewById(R.id.editableSectionCode);
                TextView lblSubjectSchedule = itemView.findViewById(R.id.editableSchedule);

                lblSubjectName.setText(subjectName);
                lblSectionCode.setText(sectionCode);
                lblSubjectSchedule.setText(subjectSchedule);

                itemView.setLayoutParams(layoutParams);
                linearSubjects.addView(itemView);
                studentBlockSubjects.moveToNext();
            } while (studentBlockSubjects.moveToNext());
        }
        if (studentBlockSubjects != null && !studentBlockSubjects.isClosed()) {
            studentBlockSubjects.close();
        }
        return rootView;
    }

    public Cursor getAvailableSubjects(SQLiteDatabase db, int blockCode) {
        String query = "SELECT * FROM Subjects WHERE block_code = ?;";
        return db.rawQuery(query, new String[]{String.valueOf(blockCode)});
    }
}