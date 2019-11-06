package com.beloved.attendance;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Delete extends AppCompatActivity {
    DBHelper mydb;
    EditText e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        mydb = new DBHelper(this);
        e = findViewById(R.id.editText1116);

    }
    public void submit(View view)
    {
        int rowsdel = mydb.delete_data(e.getText().toString());

        if (rowsdel >0){
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
