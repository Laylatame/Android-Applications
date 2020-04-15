package com.example.examenparcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calculadora2 extends AppCompatActivity {

    private Button mCalcCurrButton;
    private EditText mEditTipoCambio;
    private EditText mEditMXNinput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        mCalcCurrButton = findViewById(R.id.calcCurrButton);

/*
        mCalcCurrButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                TextView mShowResult;

                mEditTipoCambio = findViewById(R.id.editTipoCambio);
                mEditMXNinput = findViewById(R.id.editMXNinput);
                mShowResult = findViewById(R.id.textShowCalcCurr);

                float mTipoCambio = Float.valueOf(mEditTipoCambio.getText().toString());
                float mMXNinput = Float.valueOf(mEditMXNinput.getText().toString());
                float resp = mMXNinput / mTipoCambio;

                String message = String.valueOf(resp);
                mShowResult.setText(message);
            }
        });
        */

    }
}
