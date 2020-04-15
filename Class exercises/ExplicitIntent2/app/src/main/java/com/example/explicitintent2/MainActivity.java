package com.example.explicitintent2;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int request_code = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){

        Intent i = new Intent(this,ActivityB.class);

        final EditText editText = findViewById(R.id.editText);
        String pregunta = editText.getText().toString();
        i.putExtra("pregunta",pregunta);
        //startActivity(i);
        startActivityForResult(i,request_code);
    }

    protected void onActivityResult(int request_code,int resultcode,Intent data) {

        //   super.onActivityResult(request_code, resultcode, data);

        super.onActivityResult(request_code, resultcode, data);

        if ((request_code == this.request_code) && (resultcode == RESULT_OK)) {

            TextView textview = findViewById(R.id.textView);

            String returnString = data.getExtras().getString("returnData");
            textview.setText(returnString);
        }

    }
}
