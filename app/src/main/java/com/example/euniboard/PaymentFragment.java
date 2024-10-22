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

public class PaymentFragment extends Fragment {
    public PaymentFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_payment, container, false);

        //EVENTS
        ImageView btnClose = rootView.findViewById(R.id.btnClose);
        Bundle args = getArguments();
        CurrentStudent loggedStudent = args.getParcelable("currently_logged_student"); //Pass in data to the current fragment

        Button btnPayTuition = rootView.findViewById(R.id.btnPayTuition);
        Button btnLedger = rootView.findViewById(R.id.btnLedger);
        btnLedger.setOnClickListener(e -> goToLedger(loggedStudent));
        btnPayTuition.setOnClickListener(e -> goToPayment(loggedStudent));
        btnClose.setOnClickListener(e -> exitFragment());

        return rootView;
    }
    public void goToPayment(CurrentStudent loggedStudent) {
        Intent intent = new Intent(getActivity(), PayTuition.class);
        intent.putExtra("currently_logged_student", loggedStudent);
        startActivity(intent);
    }
    public void goToLedger(CurrentStudent loggedStudent) {
        Intent intent = new Intent(getActivity(), PayLedger.class);
        intent.putExtra("currently_logged_student", loggedStudent);
        startActivity(intent);
    }
    public void exitFragment() {
        getActivity().onBackPressed();
    }
}