package com.londonappbrewery.climapm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class ChangeCityController extends AppCompatActivity {

    EditText changeCity;
    ImageButton back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_city_layout);

        changeCity = (EditText) findViewById(R.id.queryET);
        back = (ImageButton) findViewById(R.id.backButton);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBack();
            }
        });
    }

    public void goBack(){
        Intent intent = new Intent(this, WeatherController.class);
        startActivity(intent);
    }

}
