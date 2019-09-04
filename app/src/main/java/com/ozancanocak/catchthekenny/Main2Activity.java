package com.ozancanocak.catchthekenny;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    EditText idNameText;
    String idName;

    RadioGroup RG;
    RadioButton hard,normal,easy;
    SharedPreferences sharedPrefUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.unicornlogo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        RG= findViewById(R.id.radioGroup);

        idNameText = findViewById(R.id.idNameText);


        sharedPrefUser = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String username = sharedPrefUser.getString("userInput", "") ;
        idNameText.setText(username);

        hard = findViewById(R.id.hard);
        normal = findViewById(R.id.normal);
        easy = findViewById(R.id.easy);

        SharedPreferences sharedPrefLook;
        sharedPrefLook = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        int Look = sharedPrefLook.getInt("difes",2);
        if(Look == 1) {
            easy.setChecked(true);
        } else if(Look == 3) {
            hard.setChecked(true);
        } else {
            normal.setChecked(true);
        }

    }


    public void imOkey(View view){

        idName = idNameText.getText().toString();
        SavePreferencesSt("userInput",idName);

        int secilenHangiRadio=RG.getCheckedRadioButtonId();

        switch (secilenHangiRadio){
            case R.id.easy:
                    SavePreferences("difes",1);
                break;
            case R.id.normal:
                    SavePreferences("difes",2);
                break;
            case R.id.hard:
                    SavePreferences("difes",3);
                break;
        }
    }




    private void SavePreferences(String key, int value){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.commit();
        Intent sd=new Intent(this,MainActivity.class);
        startActivity(sd);
    }

    private void SavePreferencesSt(String key, String value){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
        Intent sd=new Intent(this,MainActivity.class);
        startActivity(sd);
    }
}
