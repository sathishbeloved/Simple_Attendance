package com.beloved.attendance;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class AddAct extends AppCompatActivity {
    EditText e1,e2,e;
    RadioButton r1,r2;
    RadioGroup rg1,rg2;
    DBHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        e = findViewById(R.id.editText4);
        e1 = findViewById(R.id.editText3);
        e2 = findViewById(R.id.editText5);
        mydb = new DBHelper(this);


        }



public void submit(View view){
    int radi1,radi2;
    rg1 = findViewById(R.id.Radiogr1);
    rg2 = findViewById(R.id.Radiogr2);

    radi1 = rg1.getCheckedRadioButtonId();
    radi2 = rg2.getCheckedRadioButtonId();
    r1 = findViewById(radi1);
    r2 = findViewById(radi2);
    String s,s1,s2,s3,s4;
    s = e.getText().toString();
    s1 = e1.getText().toString();
    s2 = r1.getText().toString();
    s3 = e2.getText().toString();
    s4 = r2.getText().toString();
    boolean r = mydb.insert_data(s,s1,s2,s3,s4);
    if (r){
        Toast.makeText(getApplicationContext(),"Sucessfull",Toast.LENGTH_SHORT).show();
    }
    else {
        Toast.makeText(getApplicationContext(),"Failed",Toast.LENGTH_SHORT).show();

    }

}


   // public void dispAll()

    public void close(View view){

        finish();

    }
}
