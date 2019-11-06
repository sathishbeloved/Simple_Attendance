package com.beloved.attendance;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Admin2 extends AppCompatActivity{
    TextView tv1,tv4;
    DBHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin2);
        Intent i = getIntent();
        String name = i.getStringExtra("name");
        tv1= findViewById(R.id.textView);
        tv1.setText("Welcome "+name);
       // tv4 = findViewById(R.id.textView4);
        mydb = new DBHelper(this);
        //tv4.setText("");

    }
    public void add(View view){
        Intent i = new Intent(this,AddAct.class);
        startActivity(i);

    }

    public void display(View view)
    {
        Cursor res = mydb.getAllData();
        if (res.getCount() == 0)
        {
            showmsg("Error","There is no existing data! Please add to view the infomation");
        }
        else {
            StringBuffer buff = new StringBuffer();
            while (res.moveToNext()){
                buff.append("Id         "+res.getString(0)+"\n");
                buff.append("Name       "+res.getString(1)+"\n");
                buff.append("Course     "+res.getString(2)+"\n");
                buff.append("Date       "+res.getString(3)+"\n");
                buff.append("Attendance "+res.getString(4)+"\n\n");


            }
            //show
            showmsg("Data",buff.toString());
        }
    }

    public void showmsg(String title,String msg){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.show();
    }

public void update(View view){

       Intent i = new Intent(this,UpdAct.class);
       startActivity(i);
}

public void clear(View view){
    Intent i = new Intent(this,Delete.class);
    startActivity(i);

}

    public void close(View view){

        finish();

    }
}
