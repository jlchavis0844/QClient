package com.example.james.qclient;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity implements  View.OnClickListener{

    //for use in register fields
    Button bRegister;//register buttom
    EditText etUsername, etFname, etLname, etEmail, etPassword, etAge;//register info

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //fields being imported from registration activity.
        etUsername = (EditText) findViewById(R.id.etUsername);
        etFname = (EditText) findViewById(R.id.etFname);
        etLname = (EditText) findViewById(R.id.etLname);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etAge = (EditText) findViewById(R.id.etAge);
        bRegister = (Button) findViewById(R.id.bRegister);
        bRegister.setOnClickListener(this);//start listener
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bRegister:

                break;
        }
    }
}
