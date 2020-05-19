package com.example.fragmentshomework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FragmentInicial.OnFragmentInteractionListener{

    private boolean fragmentInitialDisplayed = false;
    private boolean fragmentPreguntasDisplayed = false;
    public String cuestionario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayFragmentInicial();

        //replaceFragment1by2();


    }

    public void displayFragmentInicial(){

        FragmentInicial fragmentInicial = FragmentInicial.newInstance();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.fragment1, fragmentInicial).addToBackStack(null).commit();

    }

    public void replaceFragment1by2(){
        FragmentPreguntas fragmentPreguntas = FragmentPreguntas.newInstance();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment1, fragmentPreguntas).commit();

    }

    @Override
    public String mandoButton(String button) {


        if(button == "A"){

            cuestionario = "A";
            replaceFragment1by2();
        }

        if(button == "B"){
            cuestionario = "B";
            replaceFragment1by2();
        }

        return button;

    }

    public String getCuestionario(){
        return cuestionario;
    }

}
