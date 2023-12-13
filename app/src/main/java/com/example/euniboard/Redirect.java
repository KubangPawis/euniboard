package com.example.euniboard;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Redirect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redirect);

        //EVENTS
        Button btnYes = findViewById(R.id.btnYes);
        btnYes.setOnClickListener(this::onYes);

        Button btnNo = findViewById(R.id.btnNo);
        btnNo.setOnClickListener(this::onNo);
    }

    public void onYes(View v) {
        Intent intent = getIntent();
        String selected = intent.getStringExtra("selection");
        String url = "";
        switch (selected) {
            case "Counseling":
                url = "https://docs.google.com/forms/d/e/1FAIpQLSdwLYrVS9U-eBHQWhKpipSZLIBm49UoG0vp9uDxuLF7UrmT8g/viewform";
                break;
            case "Student Records":
                url = "https://docs.google.com/forms/d/e/1FAIpQLScSFmwxKEZu9EwJRHJRuhMDz8m1pDawPMGrxyi-m6qEHzoC_g/viewform";
                break;
            case "Psychological Test":
                url = "https://linktr.ee/osasmseuf";
                break;
            case "Exit Interview":
                url = "https://docs.google.com/forms/d/e/1FAIpQLSdsrhV0VF12eg_7LNFx98RYqItr256zZycimtACOrLjhF9zjQ/viewform";
                break;
            case "SPS Evaluation":
                url = "https://docs.google.com/forms/d/e/1FAIpQLSetijiBrQLHteQCzGP_Maa8S-DDPhWGdI_Rw3mnqoalDq6jAA/viewform";
                break;
        }
        Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent1);
    }
    public void onNo(View v) {
        finish();
    }
}