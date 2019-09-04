package com.ozancanocak.catchthekenny;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class levelUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_up);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.unicornlogo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);


    }
}
