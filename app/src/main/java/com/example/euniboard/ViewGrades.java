package com.example.euniboard;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ViewGrades extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_grades);

        boolean isAvailable = false;

        if(isAvailable) {
            openGradesAvailable();
        }
        else {
            openGradesNotAvailable();
        }
    }

    public void openGradesAvailable() {
        GradesAvailableFragment frag = new GradesAvailableFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, frag)
                .commit();
    }
    public void openGradesNotAvailable() {
        GradesNA_Fragment frag = new GradesNA_Fragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, frag)
                .commit();
    }
}