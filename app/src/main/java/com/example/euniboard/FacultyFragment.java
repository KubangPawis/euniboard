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

import androidx.fragment.app.Fragment;

public class FacultyFragment extends Fragment {
    public FacultyFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_faculty, container, false);

        //EVENTS
        ImageView btnClose = rootView.findViewById(R.id.btnClose);
        Button btnViewFaculty = rootView.findViewById(R.id.btnViewFaculty);

        Bundle args = getArguments();
        CurrentStudent loggedStudent = args.getParcelable("currently_logged_student"); //Pass in data to the current fragment

        btnClose.setOnClickListener(e -> exitFragment());
        btnViewFaculty.setOnClickListener(e -> goToViewFaculty(e, loggedStudent));

        return rootView;
    }
    public void goToViewFaculty(View v, CurrentStudent loggedStudent) {
        Intent intent = new Intent(getActivity(), ViewFaculty.class);
        intent.putExtra("currently_logged_student", loggedStudent);
        startActivity(intent);
    }

    public void exitFragment() {
        getActivity().onBackPressed();
    }
}