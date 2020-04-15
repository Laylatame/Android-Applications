package com.example.dice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView mImageView;
    private Random rng = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = findViewById(R.id.imageView);

        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollDice();
            }
        });

    }

    public void rollDice(){
        int randomNumber = rng.nextInt(6)+1;

        switch (randomNumber){

            case 1:
                mImageView.setImageResource(R.drawable.dice1);
                break;
            case 2:
                mImageView.setImageResource(R.drawable.dice2);
                break;
            case 3:
                mImageView.setImageResource(R.drawable.dice3);
                break;
            case 4:
                mImageView.setImageResource(R.drawable.dice4);
                break;
            case 5:
                mImageView.setImageResource(R.drawable.dice5);
                break;
            case 6:
                mImageView.setImageResource(R.drawable.dice6);
                break;



        }
    }
}
