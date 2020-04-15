package com.example.explicitintent2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        // Paso #1 obtener los extras
        Bundle extras = getIntent().getExtras();

        // 1.2 Validar que no se encuentren nulos
        if (extras == null){

            return;
        }
        // Paso # 3 Obtener cada dato necesario.
        String qString = extras.getString("pregunta");
       final TextView textView = findViewById(R.id.textView2);
       textView.setText(qString);



    }

    public void onClick(View view){
        finish();
    }




    public void finish(){

        Intent data = new Intent();

        EditText editText = findViewById(R.id.editText2);

        String returnString = editText.getText().toString();
        data.putExtra("returnData",returnString);

        setResult(RESULT_OK,data);
        super.finish();
    }
}
