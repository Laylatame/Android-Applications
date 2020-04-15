package com.example.examenparcial1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.util.Log;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "StateChanged";
    private int counter = 0;
    private ImageView mCalculadoraImg;
    private ImageView mCambioCurrencyImg;
    private TextView mTextViewName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counter += 1;
        Log.i(TAG,"onCreate: " + counter);

        mCalculadoraImg = findViewById(R.id.imgCalculadora);
        mCambioCurrencyImg = findViewById(R.id.imgCambioCurr);
        mTextViewName = findViewById(R.id.textViewName);

        mCalculadoraImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i = new Intent(v.getContext(), Calculadora.class);
                startActivity(i);
            }
        });

        mCambioCurrencyImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i = new Intent(v.getContext(), Currency.class);
                startActivity(i);
            }
        });

        mTextViewName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i = new Intent(v.getContext(), ChangeMyName.class);
                startActivityForResult(i, 100);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        counter += 1;
        Log.i(TAG,"onStart: " + counter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        counter += 1;
        Log.i(TAG,"onResume: " + counter);
    }

    @Override
    protected void onPause() {
        super.onPause();

        counter += 1;
        Log.i(TAG,"onPause: " + counter);
    }

    @Override
    protected void onStop() {
        super.onStop();

        counter += 1;
        Log.i(TAG,"onStop: " + counter);
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        counter += 1;
        Log.i(TAG,"onRestart: " + counter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        counter += 1;
        Log.i(TAG,"onDestroy: " + counter);
    }


    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        counter += 1;
        Log.i(TAG,"onConfigurationChanged: " + counter);
    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);

        counter += 1;
        Log.i(TAG,"onSaveInstancestate: " + counter);
    }




    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);

        counter += 1;
        Log.i(TAG,"onRestoreInstanceState" + counter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        mTextViewName = findViewById(R.id.textViewName);


        if (requestCode == 100) {
            if(resultCode == Activity.RESULT_OK){
                String newName = data.getStringExtra("newName");
                mTextViewName.setText(newName);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //No action needed
            }
        }
    }
}