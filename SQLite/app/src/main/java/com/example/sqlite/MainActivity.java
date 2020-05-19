package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;


public class MainActivity extends AppCompatActivity {

    TextView fechaNota;
    EditText nota;
    Button buttonGuardar;
    Button buttonEliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fechaNota = findViewById(R.id.fechaUltimaActualizacion);
        nota = findViewById(R.id.editTextNotas);
        buttonGuardar = findViewById(R.id.buttonGuardar);
        buttonEliminar = findViewById(R.id.buttonEliminar);
        final MyDBHandler dbHandler = new MyDBHandler(this,null,null,1);


        Notes notes = dbHandler.findNotes(1);

        if (notes != null){

            int fechaUnix = notes.getFecha();
            Date date = new java.util.Date(fechaUnix*1000L);
            SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
            String formattedDate = sdf.format(date);

            nota.setText(String.valueOf(notes.getNota()));
            fechaNota.setText(formattedDate);

        }


        buttonGuardar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String textNota = nota.getText().toString();
                long fechaLong = System.currentTimeMillis()/1000;
                int fecha = (int) fechaLong;

                Date date = new java.util.Date(fechaLong*1000L);
                SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
                String formattedDate = sdf.format(date);

                if(dbHandler.findNotes(1) != null){

                    dbHandler.updateNotes(1, textNota, fecha);
                    fechaNota.setText(formattedDate);

                } else{

                    Notes notes = new Notes(1, textNota,fecha);

                    dbHandler.addNotes(notes);
                    fechaNota.setText(formattedDate);

                }
            }
        });

        buttonEliminar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                boolean result = dbHandler.deleteNotes(1);

                if (result){

                    fechaNota.setText("");
                    nota.setText("");

                }
            }
        });
    }

}
