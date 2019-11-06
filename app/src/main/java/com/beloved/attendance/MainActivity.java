package com.beloved.attendance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et1,et2;
    RadioGroup rg;
    RadioButton radioButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.editText);
        et2 = findViewById(R.id.editText2);

    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(),"Exiting the app!!!",Toast.LENGTH_SHORT).show();
        super.onBackPressed();
    }

    public void close(View view){

        Toast.makeText(getApplicationContext(),"Exiting the app!!!",Toast.LENGTH_SHORT).show();

        finish();

    }
    public void check(View view){
        rg = findViewById(R.id.radiogrp);
        int rb = rg.getCheckedRadioButtonId();
        radioButton = findViewById(rb);
        String radio = radioButton.getText().toString();
        int j=0;


        if (radio.contains("Admin")) {

            if ((et1.getText().toString()).equals("admin") && (et2.getText().toString()).equals("pass")) {


                Intent i = new Intent(this, Admin2.class);
                String g = et1.getText().toString();
                i.putExtra("name", g);
                startActivity(i);
            }
            else {
                j++;
                }
        }
        else {

            if ((et1.getText().toString()).equals("user") && (et2.getText().toString()).equals("pass")) {

                Intent i = new Intent(this, User.class);
                String g = et1.getText().toString();
                i.putExtra("name", g);
                startActivity(i);
            }
            else {
                j++;
            }
        }




        if (j>0){
            Toast.makeText(getApplicationContext(),"Invalid ID or Password",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"Sucessfull",Toast.LENGTH_LONG).show();

        }



    }
}
