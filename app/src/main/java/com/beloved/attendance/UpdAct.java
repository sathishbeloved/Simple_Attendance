package com.beloved.attendance;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class UpdAct extends AppCompatActivity {
    DBHelper mydb;
    EditText e1,e2,e;
    RadioButton r1,r2;
    RadioGroup rg1,rg2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upd);
        mydb = new DBHelper(this);
        e = findViewById(R.id.id);
        e1 = findViewById(R.id.editText3);
        e2 = findViewById(R.id.editText5);

    }

    public void submit(View view){

        int radio1,radio2;
        rg1 = findViewById(R.id.Radiogr1);
        rg2 = findViewById(R.id.Radiogr2);

        radio1 = rg1.getCheckedRadioButtonId();
        radio2 = rg2.getCheckedRadioButtonId();
        r1 = findViewById(radio1);
        r2 = findViewById(radio2);
        String s,s1,s2,s3,s4;
        s = e.getText().toString();
        s1 = e1.getText().toString();
        s2 = r1.getText().toString();
        s3 = e2.getText().toString();
        s4 = r2.getText().toString();
        boolean r = mydb.uplateData(s,s1,s2,s3,s4);

        if (r){
            Toast.makeText(getApplicationContext(),"Sucessfull",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"Failed",Toast.LENGTH_SHORT).show();

        }

    }
    public void close(View view){

        finish();

    }
}
