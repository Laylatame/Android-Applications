package com.example.examenparcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ChangeMyName extends AppCompatActivity {

    private EditText mEditName;
    private Button mEditNameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_my_name);

        mEditName = findViewById(R.id.editNewName);
        mEditNameButton = findViewById(R.id.newNameButton);

        mEditNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String newName = mEditName.getText().toString();
                Intent returnIntent = new Intent();
                returnIntent.putExtra("newName", newName);
                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }
        });
    }
}
