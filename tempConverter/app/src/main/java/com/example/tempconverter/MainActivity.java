package com.example.tempconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mConvertButton;
    private EditText mInputTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mConvertButton = findViewById(R.id.convert_button);

         mConvertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                mInputTemp = findViewById(R.id.inpTemp);

                String messg = "Temperature in Celcius: ";

                double faren = Double.parseDouble(mInputTemp.getText().toString());
                double celcius = (faren - 32) * 5/9;

                messg = messg + celcius;

                Toast.makeText(MainActivity.this, messg, Toast.LENGTH_SHORT).show();

            }
        });

    }
}
