package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SimpleFragment.OnFragmentInteractionListener{

    private Button mButton;
    private boolean isFragmentDisplayed = false;
    private int mRadioButtonChoice = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = findViewById(R.id.button);

        if (savedInstanceState != null){
            isFragmentDisplayed = savedInstanceState.getBoolean("state_of_fragment");
            if (isFragmentDisplayed){
                mButton.setText(R.string.close);
            }
        }


        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                if(!isFragmentDisplayed){
                    displayFragment();
                }
                else{
                    closeFragment();
                }
            }
        });
    }

    // Mostrar el fragment
    public void displayFragment(){

        SimpleFragment simpleFragment = SimpleFragment.newInstance();

        // Comenzar una transacción de fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Agregar simple fragment
        fragmentTransaction.add(R.id.fragment, simpleFragment).addToBackStack(null).commit();

        // Actualizar el boton
        mButton.setText(R.string.close);
        isFragmentDisplayed = true;


    }

    public void closeFragment(){

        FragmentManager fragmentManager = getSupportFragmentManager();

        // Checar si el fragment ya esta mostrando, está activo
        SimpleFragment simpleFragment = (SimpleFragment) fragmentManager.findFragmentById(R.id.fragment);

        if (simpleFragment != null){

            //Crear una transacción para eliminar el fragment
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(simpleFragment).commit();
        }

        // Si el fragment es nulo, actualizar el boton
        mButton.setText(R.string.open);
        isFragmentDisplayed = false;
    }

    public void onSaveInstanceState(Bundle savedInstanceState){

        savedInstanceState.putBoolean("state_of_fragment", isFragmentDisplayed);
        super.onSaveInstanceState(savedInstanceState);

    }

    @Override
    public void onRadioButtonChoice(int choice) {

        mRadioButtonChoice = choice;
        Toast.makeText(this, "Choice is " + Integer.toString(choice), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void mandoTexto(String texto) {

        Toast.makeText(this, "Choice is " + texto, Toast.LENGTH_SHORT).show();

    }
}
