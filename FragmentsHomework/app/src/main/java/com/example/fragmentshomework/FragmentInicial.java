package com.example.fragmentshomework;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentInicial extends Fragment {

    OnFragmentInteractionListener mListener;

    public FragmentInicial() {
        // Required empty public constructor
    }

    public static FragmentInicial newInstance(){
        return new FragmentInicial();
    }

    interface OnFragmentInteractionListener{
        String mandoButton(String button);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        final View initialView = inflater.inflate(R.layout.fragment_inicial, container, false);

        final Button buttonA = initialView.findViewById(R.id.buttonEncuestaA);
        final Button buttonB = initialView.findViewById(R.id.buttonEncuestaB);

        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mListener.mandoButton("A");
                //Toast.makeText(getContext(), "Hello A!", Toast.LENGTH_SHORT).show();

            }
        });

        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mListener.mandoButton("B");
                //Toast.makeText(getContext(), "Hello B!", Toast.LENGTH_SHORT).show();

            }
        });



        return initialView;
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        if (context instanceof OnFragmentInteractionListener){
            mListener = (OnFragmentInteractionListener)context;
        }
        else {
            throw new ClassCastException(context.toString() + "Interface no a sido implementada");
        }
    }

}
