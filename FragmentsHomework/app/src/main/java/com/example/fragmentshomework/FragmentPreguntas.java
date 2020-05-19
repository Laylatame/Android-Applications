package com.example.fragmentshomework;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static android.icu.text.Normalizer.YES;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentPreguntas extends Fragment {

    Preguntas preguntas = new Preguntas();
    int size;
    int index = 0;

    private static final int TRUE = 0;
    private static final int FALSE = 1 ;

    String chosenRadioButton;

    public FragmentPreguntas() {
        // Required empty public constructor
    }

    public static FragmentPreguntas newInstance(){
        return new FragmentPreguntas();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View preguntasView = inflater.inflate(R.layout.fragment_preguntas, container, false);

        //Get elements from fragment view
        final TextView preguntaTextView = preguntasView.findViewById(R.id.questionTextView);
        final Button buttonPrev = preguntasView.findViewById(R.id.buttonPrev);
        final Button buttonNext = preguntasView.findViewById(R.id.buttonNext);
        final RadioGroup radioGroup = preguntasView.findViewById(R.id.radio_group);
        final RadioButton buttonTrue = preguntasView.findViewById(R.id.radio_button_true);
        final RadioButton buttonFalse = preguntasView.findViewById(R.id.radio_button_false);
        final TextView questionIndex = preguntasView.findViewById(R.id.questionIndex);
        final Button checkAnswerButton = preguntasView.findViewById(R.id.buttonCheckAnswer);

        //Get chosen questionnaire
        MainActivity activity = (MainActivity) getActivity();
        String cuestionario = activity.getCuestionario();
        createArrayList(cuestionario);

        setViewInfo(preguntaTextView, questionIndex, buttonPrev, buttonNext, buttonTrue, buttonFalse, checkAnswerButton);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                View radioButton = radioGroup.findViewById(checkedId);
                int index1 = radioGroup.indexOfChild(radioButton);

                switch (index1){

                    case TRUE:
                        chosenRadioButton = "true";
                        checkAnswerButton.setVisibility(View.VISIBLE);
                        break;

                    case FALSE:
                        chosenRadioButton = "false";
                        checkAnswerButton.setVisibility(View.VISIBLE);
                        break;

                    default: break;
                }
            }
        });



        buttonPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index -= 1;
                setViewInfo(preguntaTextView, questionIndex, buttonPrev, buttonNext, buttonTrue, buttonFalse, checkAnswerButton);
            }
        });

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index += 1;
                setViewInfo(preguntaTextView, questionIndex, buttonPrev, buttonNext, buttonTrue, buttonFalse, checkAnswerButton);
            }
        });

        checkAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chosenRadioButton == preguntas.getBool(index)){
                    Toast.makeText(getContext(), "CORRECT!", Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(getContext(), "INCORRECT", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return preguntasView;
    }

    public void createArrayList(String cuestionario){

        if(cuestionario == "A"){
            preguntas.createPreguntasA();
        }
        if(cuestionario == "B"){
            preguntas.createPreguntasB();
        }
        size = preguntas.getLength();


    }

    void setViewInfo(TextView preguntaTextView, TextView questionIndex, Button buttonPrev, Button buttonNext, RadioButton buttonTrue, RadioButton buttonFalse, Button checkAnswer){
        String pregunta = preguntas.getPregunta(index);
        preguntaTextView.setText(pregunta);
        questionIndex.setText(index+1+"/"+size);

        buttonTrue.setChecked(false);
        buttonFalse.setChecked(false);
        checkAnswer.setVisibility(View.GONE);

        if(index == 0) {
            buttonPrev.setEnabled(false);
        }else{
            buttonPrev.setEnabled(true);
        }

        if(index == 4) {
            buttonNext.setEnabled(false);
        }else{
            buttonNext.setEnabled(true);
        }

    }



}
