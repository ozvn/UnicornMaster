package com.ozancanocak.catchthekenny;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {

    Button tryX;
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
    int savedIntL;
    int savedIntB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        tryX.setVisibility(View.INVISIBLE);
        lastSC = findViewById(R.id.lastSC);
        bestSC = findViewById(R.id.bestSC);



        sharedPref = getPreferences(Context.MODE_PRIVATE);
        savedIntL = sharedPref.getInt("score",5);
        savedIntB = sharedPref.getInt("best_score",4);

        lastSC.setText("Last Sc: "+savedIntL);
        bestSC.setText("Best Sc:" + savedIntB);


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

                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);

                alert.setTitle("Restart?");
                alert.setMessage("Are you sure to restart game?");
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        //restart

                        restartGame();

                    }

                });


                tryX.setVisibility(View.VISIBLE);

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
        scoreText.setText("Score :" + Score);
        sleep(0b110010);

    }



    public void hideImages() {

        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {

                for (ImageView image: imageArray) {

                    image.setVisibility(View.INVISIBLE);

                }
                Random random = new Random();
                int i = random.nextInt(9);
                imageArray[i].setVisibility(View.VISIBLE);

                handler.postDelayed(this,500);

            }
        };
        handler.post(runnable);

    }

    public void tryA(View view) {
        restartGame();

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

    }


