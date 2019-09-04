package com.ozancanocak.catchthekenny;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Market extends AppCompatActivity {

    Button button, button2, button2Use, button3, button3Use, button4, button4Use, button5, button5Use;
    SharedPreferences sharedPref2,sharedPref3,sharedPref4,sharedPref5, sharedPrefCandysx;
    int i2,i3,i4,i5;
    TextView candyHave, scores2, scores3, scores4, scores5;
    int candyScore;
    ImageView candy2, candy3, candy4, candy5;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.unicornlogo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        candyHave = findViewById(R.id.candyHave);
        scores2 = findViewById(R.id.textView100);
        scores3 = findViewById(R.id.textView23);
        scores4 = findViewById(R.id.textView24);
        scores5 = findViewById(R.id.textView25);
        candy2 = findViewById(R.id.imageView26);
        candy3 =findViewById(R.id.imageView25);
        candy4 = findViewById(R.id.imageView28);
        candy5 = findViewById(R.id.imageView27);


        sharedPrefCandysx = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        candyScore = sharedPrefCandysx.getInt("candys",0);
        candyHave.setText("YOU HAVE : " + candyScore);

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button2Use = findViewById(R.id.button2Use);
        button3 = findViewById(R.id.button3);
        button3Use = findViewById(R.id.button3Use);
        button4 = findViewById(R.id.button4);
        button4Use = findViewById(R.id.button4Use);
        button5 = findViewById(R.id.button5);
        button5Use = findViewById(R.id.button5Use);
        button2Use.setVisibility(View.INVISIBLE);
        button3Use.setVisibility(View.INVISIBLE);
        button4Use.setVisibility(View.INVISIBLE);
        button5Use.setVisibility(View.INVISIBLE);

        sharedPref2 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        i2 = sharedPref2.getInt("i2",0);

        sharedPref3 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        i3 = sharedPref3.getInt("i3",0);

        sharedPref4 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        i4 = sharedPref4.getInt("i4",0);

        sharedPref5 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        i5 = sharedPref5.getInt("i5",0);


        if(i2==1){
            button2Use.setVisibility(View.VISIBLE);
            button2.setVisibility(View.INVISIBLE);
            candy2.setVisibility(View.INVISIBLE);
            scores2.setVisibility(View.INVISIBLE);
        }
        if(i3==1){
            button3Use.setVisibility(View.VISIBLE);
            button3.setVisibility(View.INVISIBLE);
            candy3.setVisibility(View.INVISIBLE);
            scores3.setVisibility(View.INVISIBLE);
        }
        if(i4==1){
            button4Use.setVisibility(View.VISIBLE);
            button4.setVisibility(View.INVISIBLE);
            candy4.setVisibility(View.INVISIBLE);
            scores4.setVisibility(View.INVISIBLE);
        }
        if(i5==1){
            button5Use.setVisibility(View.VISIBLE);
            button5.setVisibility(View.INVISIBLE);
            candy5.setVisibility(View.INVISIBLE);
            scores5.setVisibility(View.INVISIBLE);
        }






    }


    private void SavePreferences(String key, int value){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public void use2(View view){
        if(candyScore >= 100) {
            SavePreferences("i2",1);
            candyScore = candyScore - 100;
            SavePreferences("candys",candyScore);
            Intent intent = new Intent(Market.this,Market.class);
            startActivity(intent);

        }


    }
    public void use3(View view){
        if(candyScore >= 250) {
            SavePreferences("i3", 1);
            candyScore = candyScore - 250;
            SavePreferences("candys",candyScore);
            Intent intent = new Intent(Market.this,Market.class);
            startActivity(intent);
        }

    }
    public void use4(View view){
        if(candyScore >= 500) {
            SavePreferences("i4",1);
            candyScore = candyScore - 500;
            SavePreferences("candys",candyScore);
            Intent intent = new Intent(Market.this,Market.class);
            startActivity(intent);
        }

    }
    public void use5(View view){
        if(candyScore >= 1000) {
            SavePreferences("i5",1);
            candyScore = candyScore - 1000;
            SavePreferences("candys",candyScore);
            Intent intent = new Intent(Market.this,Market.class);
            startActivity(intent);
        }


    }
    public void useThis(View view){
        SavePreferences("k1",1);
        Intent intent = new Intent(Market.this,MainActivity.class);
        startActivity(intent);

    }

    public void useThis2(View view){
        SavePreferences("k1",2);
        Intent intent = new Intent(Market.this,MainActivity.class);
        startActivity(intent);

    }
    public void useThis3(View view){
        SavePreferences("k1",3);
        Intent intent = new Intent(Market.this,MainActivity.class);
        startActivity(intent);

    }
    public void useThis4(View view){
        SavePreferences("k1",4);
        Intent intent = new Intent(Market.this,MainActivity.class);
        startActivity(intent);

    }
    public void useThis5(View view){
        SavePreferences("k1",5);
        Intent intent = new Intent(Market.this,MainActivity.class);
        startActivity(intent);

    }

}
