package com.example.euniboard;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

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
        LinearLayout linearSubjects = rootView.findViewById(R.id.linearSubjects);

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