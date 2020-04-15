package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private EditText mEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //Show activity_main layout on load

        mTrueButton = findViewById(R.id.true_button);

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                //Toast.makeText(MainActivity.this, R.string.true_toast, Toast.LENGTH_SHORT).show();

                mEditText = findViewById(R.id.editText);

                String extra = "Hello ";

                extra += extra + mEditText.getText();

                Toast.makeText(MainActivity.this, extra, Toast.LENGTH_SHORT).show();

            }
        });

        mFalseButton = findViewById(R.id.false_button);

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                Toast.makeText(MainActivity.this, R.string.false_toast, Toast.LENGTH_SHORT).show();

            }
        });



    }
}
