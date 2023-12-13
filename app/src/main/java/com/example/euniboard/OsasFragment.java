package com.example.euniboard;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
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

public class OsasFragment extends Fragment {
    public OsasFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_osas, container, false);

        //EVENTS
        ImageView btnClose = rootView.findViewById(R.id.btnClose);
        Button btnCounseling = rootView.findViewById(R.id.btnCounseling);
        Button btnRecords = rootView.findViewById(R.id.btnRecords);
        Button btnPsych = rootView.findViewById(R.id.btnPsych);
        Button btnExitInterview = rootView.findViewById(R.id.btnExitInterview);
        Button btnSPS = rootView.findViewById(R.id.btnSPS);

        btnClose.setOnClickListener(e -> exitFragment());
        btnCounseling.setOnClickListener(e -> goToRedirect(e, "Counseling"));
        btnRecords.setOnClickListener(e -> goToRedirect(e, "Student Records"));
        btnPsych.setOnClickListener(e -> goToRedirect(e, "Psychological Test"));
        btnExitInterview.setOnClickListener(e -> goToRedirect(e, "Exit Interview"));
        btnSPS.setOnClickListener(e -> goToRedirect(e, "SPS Evaluation"));

        return rootView;
    }
    public void exitFragment() {
        getActivity().onBackPressed();
    }
    public void goToRedirect(View v, String selection) {
        Intent intent = new Intent(getActivity(), Redirect.class);
        intent.putExtra("selection", selection);
        startActivity(intent);
    }
}