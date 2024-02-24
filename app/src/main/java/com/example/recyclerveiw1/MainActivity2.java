package com.example.recyclerveiw1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String name = getIntent().getStringExtra("NAME");
        String abbrBig = getIntent().getStringExtra("ABBR_BIG");
        String abbrSmall = getIntent().getStringExtra("ABBR_SMALL");
        String description = getIntent().getStringExtra("DESCRIPTION");
        int image = getIntent().getIntExtra("IMAGE",0);

        TextView nameTextView = findViewById(R.id.DBZ_Title);
        TextView DBZRaceTextView = findViewById(R.id.DBZ_Race);
        TextView DBZPowerTextView = findViewById(R.id.DBZ_Power);
        TextView descriptionTextView = findViewById(R.id.DBZ_Description);
        ImageView DBZ_Image = findViewById(R.id.DBZ_Image);

        nameTextView.setText(name);
        DBZRaceTextView.setText(abbrBig);
        DBZPowerTextView.setText(abbrSmall);
        descriptionTextView.setText(description);
        DBZ_Image.setImageResource(image);






    }

}