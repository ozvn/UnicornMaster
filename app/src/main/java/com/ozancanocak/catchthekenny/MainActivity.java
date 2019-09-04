package com.ozancanocak.catchthekenny;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.util.Random;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {

    Button tryX;
    Button market;
    TextView scoreText;
    TextView timeText;
    TextView lastSC;
    TextView bestSC;
    int Score;
    ImageView imageView;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView[] imageArray;
    Handler handler;
    Runnable runnable;
    SharedPreferences sharedPref;
    SharedPreferences sharedPrefDif;
    SharedPreferences sharedPrefName;
    SharedPreferences sharedPrefSkin;
    int savedIntL;
    int savedIntB;
    MediaPlayer mp;
    int candyScore;
    TextView CandyTextView;
    TextView levelSystem;
    TextView levelNumber;


 //   SQLiteDatabase mydatabase;





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater getMenuInflater = getMenuInflater();
        getMenuInflater.inflate(R.menu.difficulty,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.difficulty) {

            Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
            startActivity(intent);
        }

        if (item.getItemId() == R.id.levelSystem) {

            Intent intent2 = new Intent(getApplicationContext(),levelUp.class);
            startActivity(intent2);
        }

        if (item.getItemId() == R.id.market) {

            Intent intent3 = new Intent(getApplicationContext(),Market.class);
            startActivity(intent3);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.unicornlogo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        timeText = findViewById(R.id.timeText);
        scoreText = findViewById(R.id.scoreText);
        imageView = findViewById(R.id.imageView);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        imageArray = new ImageView[]{imageView, imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8};
        tryX = findViewById(R.id.tryXButton);
        market = findViewById(R.id.tryXButton2);
        tryX.setVisibility(View.INVISIBLE);
        market.setVisibility(View.INVISIBLE);
        lastSC = findViewById(R.id.lastSC);
        bestSC = findViewById(R.id.bestSC);
        CandyTextView = findViewById(R.id.CandyText);
        levelSystem = findViewById(R.id.level);
        levelNumber = findViewById(R.id.level1);



        SharedPreferences sharedPrefCandy;
        sharedPrefCandy = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());


        candyScore = sharedPrefCandy.getInt("candys",0);
        CandyTextView.setText(" : " + candyScore);


        if(candyScore>=100 && candyScore<200) {
            levelSystem.setText("BABY UNICORN MASTER");
            levelNumber.setText("LEVEL 2");
        }
        if(candyScore>=200 && candyScore<300) {
            levelSystem.setText("STUDENT UNICORN MASTER");
            levelNumber.setText("LEVEL 3");
        }
        if(candyScore>=300 && candyScore<400) {
            levelSystem.setText("LEGENDARY UNICORN MASTER");
            levelNumber.setText("LEVEL 4");
        }
        if(candyScore>=400 && candyScore<500) {
            levelSystem.setText("FANTASTIC UNICORN MASTER");
            levelNumber.setText("LEVEL 5");
        }
        if(candyScore>=500 && candyScore<600) {
            levelSystem.setText("MYSTIC UNIRCORN MASTER");
            levelNumber.setText("LEVEL 6");
        }
        if(candyScore>=600 && candyScore<700) {
            levelSystem.setText("PROFESSOR UNIRCORN MASTER");
            levelNumber.setText("LEVEL 7");
        }

        //SKİN CODES

        sharedPrefSkin = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        int skin = sharedPrefSkin.getInt("k1",1);

        switch (skin) {
            case 1:
                for (ImageView image: imageArray) {
                    image.setImageResource(R.drawable.unic);
                }
                break;

            case 2:
                for (ImageView image: imageArray) {
                    image.setImageResource(R.drawable.uni2corn);
                }
                break;
            case 3:
                for (ImageView image: imageArray) {
                    image.setImageResource(R.drawable.uni3corn);
                }
                break;
            case 4:
                for (ImageView image: imageArray) {
                    image.setImageResource(R.drawable.uni4corn);
                }
                break;
            case 5:
                for (ImageView image: imageArray) {
                    image.setImageResource(R.drawable.uni5corn);
                }
                break;

        }












        sharedPref = getPreferences(Context.MODE_PRIVATE);
        savedIntL = sharedPref.getInt("score",5);
        savedIntB = sharedPref.getInt("best_score",4);


        lastSC.setText("Last Score: " + savedIntL);
        bestSC.setText("Best Score: " + savedIntB);


        Log.i("firat",savedIntB+"<-best");



        hideImages();

        Score = 0;


        new CountDownTimer(10000, 1000) {


            @Override
            public void onTick(long l) {
                timeText.setText("Time: " + l / 1000);
            }

            @Override
            public void onFinish() {


                timeText.setText("Time Off");
                handler.removeCallbacks(runnable);
                for (ImageView image : imageArray) {
                    image.setVisibility(View.INVISIBLE);

                }


                try {
                    sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);

                sharedPrefName = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                String username = sharedPrefName.getString("userInput", "") ;


                if(candyScore>=0 && candyScore < 100){
                    alert.setTitle("Unicorn Master "+username);
                }
                if(candyScore>=100 && candyScore < 200){
                    alert.setTitle("Baby Unicorn Master "+username);
                }
                if(candyScore>=200 && candyScore < 300){
                    alert.setTitle("Student Unicorn Master "+username);
                }
                if(candyScore>=300 && candyScore < 400){
                    alert.setTitle("Legandary Unicorn Master "+username);
                }
                if(candyScore>=400 && candyScore < 500){
                    alert.setTitle("Fantastic Unicorn Master "+username);
                }
                if(candyScore>=500 && candyScore < 600){
                    alert.setTitle("Mystic Unicorn Master "+username);
                }
                if(candyScore>=600){
                    alert.setTitle("Professor Unicorn Master "+username);
                }


                alert.setMessage("Do You Want To Play Again");
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //restart
                        restartGame();
                    }
                });


                tryX.setVisibility(View.VISIBLE);
                market.setVisibility(View.VISIBLE);
                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Game Over!", Toast.LENGTH_SHORT).show();
                    }

                });

                alert.show();

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("score",Score);



                int s = sharedPref.getInt("best_score",0);
                if (Score > s){
                    editor.putInt("best_score",Score);
                }
                editor.commit();



            }
        }.start();

    }



    public void increaseScore(View view) throws InterruptedException {

        Score++;
        //stopPlaying();
        mp = MediaPlayer.create(this,R.raw.sound);

        scoreText.setText("Score :" + Score);
        sleep(0b110010);

        if(Score%5==0) {
            mp.start();
    }

        if(Score%10==0) {
            candyScore++;
            SavePreferences("candys",candyScore);
        }

    }



    public void hideImages() {

        handler = new Handler();

        runnable = new Runnable() {



            @Override
            public void run() {

                sharedPrefDif = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                int diffi = sharedPrefDif.getInt("difes",2);

                switch (diffi) {
                    case 1:
                        for (ImageView image: imageArray) {
                            image.setVisibility(View.INVISIBLE);
                        }
                        Random random = new Random();
                        int i = random.nextInt(9);
                        imageArray[i].setVisibility(View.VISIBLE);
                        handler.postDelayed(this,1300);
                        break;

                    case 2:
                        for (ImageView image: imageArray) {
                            image.setVisibility(View.INVISIBLE);
                        }
                        Random random2 = new Random();
                        int i1 = random2.nextInt(9);
                        imageArray[i1].setVisibility(View.VISIBLE);
                        handler.postDelayed(this,900);
                        break;
                    case 3:
                        for (ImageView image: imageArray) {
                            image.setVisibility(View.INVISIBLE);
                        }
                        Random random3 = new Random();
                        int i2 = random3.nextInt(9);
                        imageArray[i2].setVisibility(View.VISIBLE);
                        handler.postDelayed(this,475);
                        break;

                }

            }
        };
        handler.post(runnable);

    }

    public void tryA(View view) {
        restartGame();

    }

    public void marketGo(View view) {

        Intent goMarket = new Intent(MainActivity.this,Market.class);
        startActivity(goMarket);

    }

    public void restartGame() {
        Intent intent = getIntent();
        finish();
        startActivity(intent);


        if(Score>savedIntL) {
            bestSC.setText("Best Sc"+savedIntB);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt("bestscore",Score);
            editor.commit();

            }

        }


    private void SavePreferences(String key, int value){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.commit();

    }





        //seslerin üst üste gelmesini engeller

//    private void stopPlaying() {
//        if (mp != null) {
//            mp.stop();
//            mp.release();
//            mp = null;
//        }
//    }











    //Reklam





    }


