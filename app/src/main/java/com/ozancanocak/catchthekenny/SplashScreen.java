package com.ozancanocak.catchthekenny;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SplashScreen extends AppCompatActivity {

    TextView welcome;
    SharedPreferences sharedPref;
    TextView showCandys;
    SharedPreferences sharedPrefCandys;
    TextView accFor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        welcome = findViewById(R.id.welcome);
        sharedPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String username = sharedPref.getString("userInput", "") ;
        welcome.setText(username);

        showCandys = findViewById(R.id.textViewCandys);
        sharedPrefCandys = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        int candyScore = sharedPrefCandys.getInt("candys",0);
        showCandys.setText(" : " + candyScore);
        accFor = findViewById(R.id.acc);

        if(candyScore>=0 && candyScore < 100){
            accFor.setText("Unicorn Master");
        }
        if(candyScore>=100 && candyScore < 200){
            accFor.setText("Baby Unicorn Master");
        }
        if(candyScore>=200 && candyScore < 300){
            accFor.setText("Student Unicorn Master");
        }
        if(candyScore>=300 && candyScore < 400){
            accFor.setText("Legandary Unicorn Master");
        }
        if(candyScore>=400 && candyScore < 500){
            accFor.setText("Fantastic Unicorn Master");
        }
        if(candyScore>=500 && candyScore < 600){
            accFor.setText("Mystic Unicorn Master");
        }
        if(candyScore>=600){
            accFor.setText("Professor Unicorn Master");
        }



        Thread myThread = new Thread() {

            @Override
            public void run() {
                try {
                    sleep(4000);
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        myThread.start();

    }
}
