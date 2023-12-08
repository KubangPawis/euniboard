package com.example.euniboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class SubjectsAvailableFragment extends Fragment {
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

        //BLUR BG METHOD
        View rootView = inflater.inflate(R.layout.fragment_subjects_available, container, false);
        LinearLayout linearSubjects = rootView.findViewById(R.id.linearFaculty);

        String[] subjectList = {"OOP", "Art Appreciation", "Swimming"};

        //DIMENSION CONVERSION (dp to pixel)
        float widthDP = 300f;
        float heightDP = 111f;
        float scale = getResources().getDisplayMetrics().density;
        int widthPX = (int) (widthDP * scale + 0.5f);
        int heightPX = (int) (heightDP * scale + 0.5f);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                widthPX, // Width
                heightPX// Height
        );

        for (String subject : subjectList) { // Assuming 'dataList' contains your items
            View itemView = getLayoutInflater().inflate(R.layout.layout_subject_panel, null);
            TextView titleTextView = itemView.findViewById(R.id.lblSubject);

            // Set data to TextViews or views in the item layout
            titleTextView.setText(subject); // Replace with actual data retrieval

            itemView.setLayoutParams(layoutParams);
            linearSubjects.addView(itemView);
        }
        return rootView;
    }
}