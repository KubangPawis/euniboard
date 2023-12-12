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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Objects;

public class SubjectsFragment extends Fragment {
    public SubjectsFragment() {
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
        View rootView = inflater.inflate(R.layout.fragment_subjects, container, false);

        //EVENTS
        ImageView btnClose = rootView.findViewById(R.id.btnClose);
        Button btnViewSubjects = rootView.findViewById(R.id.btnViewSubjects);
        Button btnViewGrades = rootView.findViewById(R.id.btnViewGrades);

        Bundle args = getArguments();
        CurrentStudent loggedStudent = args.getParcelable("currently_logged_student"); //Pass in data to the current fragment

        btnClose.setOnClickListener(e -> exitFragment());
        btnViewSubjects.setOnClickListener(e -> goToViewSubjects(loggedStudent));
        btnViewGrades.setOnClickListener(e -> goToViewGrades(loggedStudent));

        return rootView;
    }
    public static Bitmap getScreenShot(View view) {
        view.setDrawingCacheEnabled(true);
        Bitmap screenshot = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        return screenshot;
    }

    public static Bitmap blurBitmap(Context context, Bitmap inputBitmap, float radius) {
        if (inputBitmap == null) return null;

        Bitmap outputBitmap = Bitmap.createBitmap(inputBitmap.getWidth(), inputBitmap.getHeight(), Bitmap.Config.ARGB_8888);

        RenderScript renderScript = RenderScript.create(context);
        ScriptIntrinsicBlur scriptIntrinsicBlur = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
        Allocation tmpIn = Allocation.createFromBitmap(renderScript, inputBitmap);
        Allocation tmpOut = Allocation.createFromBitmap(renderScript, outputBitmap);
        scriptIntrinsicBlur.setRadius(radius);
        scriptIntrinsicBlur.setInput(tmpIn);
        scriptIntrinsicBlur.forEach(tmpOut);
        tmpOut.copyTo(outputBitmap);

        renderScript.destroy();

        return outputBitmap;
    }
    public void goToViewSubjects(CurrentStudent loggedStudent) {
        Intent intent = new Intent(getActivity(), ViewSubjects.class);
        intent.putExtra("currently_logged_student", loggedStudent);
        startActivity(intent);
    }

    public void goToViewGrades(CurrentStudent loggedStudent) {
        Intent intent = new Intent(getActivity(), ViewGrades.class);
        intent.putExtra("currently_logged_student", loggedStudent);
        startActivity(intent);
    }

    public void exitFragment() {
        getActivity().onBackPressed();
    }
}