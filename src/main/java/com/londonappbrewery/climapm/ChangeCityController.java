package com.londonappbrewery.climapm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;


public class ChangeCityController extends AppCompatActivity {

    EditText changeCity;
    EditText changeCountry;
    String countryName;
    String cityName;
    ImageButton back;
    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_city_layout);

        final Intent newCityIntent = new Intent(ChangeCityController.this, WeatherController.class);

        changeCity = (EditText) findViewById(R.id.queryET);
        changeCountry = (EditText) findViewById(R.id.queryCountry);
        back = (ImageButton) findViewById(R.id.backButton);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBack();
            }
        });

        String json = null;
        try{
            InputStream is = this.getAssets().open("city.list.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            json = new String(buffer, "UTF-8");
        }catch(IOException ex){
            ex.printStackTrace();
        }

        changeCity.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                cityName = changeCity.getText().toString();
                return false;
            }
        });

        changeCountry.setOnEditorActionListener(new TextView.OnEditorActionListener(){
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event){
                countryName = changeCountry.getText().toString();
                Log.d("Clima", cityName);
                newCityIntent.putExtra("City", cityName);
                newCityIntent.putExtra("Country", countryName);

                startActivity(newCityIntent);

                return false;
            }
        });
    }

    public void goBack(){
        Intent intent = new Intent(this, WeatherController.class);
        startActivity(intent);
    }

}
