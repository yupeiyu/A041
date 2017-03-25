package com.example.administrator.a041;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    Spinner     sp, sp2, sp3;
    int         wyear;
    Context     context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        context=this;

        //Spinner
        sp=(Spinner) findViewById(R.id.spinner);
        sp2=(Spinner) findViewById(R.id.spinner2);
        sp3=(Spinner) findViewById(R.id.spinner3);

        Log.d("Spinner", "Step1");
        //set data
        List<Integer>   ll=new ArrayList<Integer>();

        Calendar        cc=Calendar.getInstance();
        wyear=cc.get(Calendar.YEAR);

        for (int  a=wyear; a >= 1905; a--)
        {
            ll.add(a);
        }

        ArrayAdapter<Integer>       aa=new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, ll);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(aa);

        Log.d("Spinner", "Step2");

        //event, 事件
        //inner class
        //anynomous class
        sp.setOnItemSelectedListener(new  Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                int      yy=Integer.parseInt(parent.getSelectedItem().toString());
                Toast.makeText(context, yy+", "+isLeapYear(yy), Toast.LENGTH_LONG).show();

                Log.d("Spinner", "Step3");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    String      isLeapYear(int  yy)
    {
        //short cut
        if ( ! ((yy % 4 == 0 & yy % 100 != 0) | (yy % 400 == 0)) )
        {
            return  "不是閏年";
        }

        return  "是閏年";
    }
}
