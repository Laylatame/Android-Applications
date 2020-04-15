package com.example.eventhandling;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);

        button.setOnClickListener(new Button.OnClickListener(){

            public void onClick (View view){

                TextView textView = findViewById(R.id.textView);
                textView.setText("Button clicked");
            }


        });


        button.setOnLongClickListener(new Button.OnLongClickListener(){

            public boolean onLongClick (View view){

                TextView textView = findViewById(R.id.textView);
                textView.setText("Button Long clicked");
                return true;
            }


        });



    }


}
