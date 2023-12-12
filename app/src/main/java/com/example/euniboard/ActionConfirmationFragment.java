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
import androidx.fragment.app.FragmentManager;

public class ActionConfirmationFragment extends Fragment {
    public ActionConfirmationFragment() {
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
        View rootView = inflater.inflate(R.layout.fragment_action_confirmation, container, false);

        // Get the main activity's content as a bitmap
        Bitmap backgroundBitmap = getScreenShot(getActivity().getWindow().getDecorView().getRootView());

        // Apply blur effect to the captured bitmap
        Bitmap blurredBitmap = blurBitmap(getContext(), backgroundBitmap, 20); // Adjust blur radius as needed

        // Create a layer drawable with the blurred bitmap and semi-transparent color
        Drawable[] layers = new Drawable[2];
        layers[0] = new BitmapDrawable(getResources(), blurredBitmap);
        layers[1] = new ColorDrawable(Color.parseColor("#F4F4F4"));
        LayerDrawable layerDrawable = new LayerDrawable(layers);
        layerDrawable.setAlpha(230);
        rootView.setBackground(layerDrawable);

        //EVENTS
        Button btnYes = rootView.findViewById(R.id.btnYes);
        Button btnNo = rootView.findViewById(R.id.btnNo);

//        btnYes.setOnClickListener(this::goToViewSubjects);
//        btnNo.setOnClickListener(this::goToViewGrades);

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

        Bitmap outputBitmap = Bitmap.createBitmap(
                inputBitmap.getWidth(), inputBitmap.getHeight(), Bitmap.Config.ARGB_8888);

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
//    public void confirmAction(View v) {
//        FragmentManager fragmentManager = getParentFragmentManager();
//        fragmentManager.beginTransaction()
//                .replace(R.id.fragment_container_view, fragment)
//                .addToBackStack(null)
//                .commit();
//    }

    public void goBack(View v) {
        getActivity().onBackPressed();
    }
}