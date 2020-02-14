package com.siddharth.weather.Activites;


import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.siddharth.weather.R;

public class City extends AppCompatActivity {

    EditText cityname;
    ImageButton home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);

        cityname = findViewById(R.id.cityname);
        home = findViewById(R.id.home);


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go back and destroy the MainActivity..
                finish();
            }
        });


        // Using Soft Keyboard not hard keys...
        cityname.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                String newCity = cityname.getText().toString();
                Intent intent = new Intent(City.this, MainActivity.class);

                // Adds what was entered in the EditText as an extra to the intent.
                intent.putExtra("City", newCity);

                // We started this activity for a result, so now we are setting the result.
                setResult(Activity.RESULT_OK, intent);

                // This destroys the MainActivity..
                finish();
                return true;
            }
        });

    }
}
