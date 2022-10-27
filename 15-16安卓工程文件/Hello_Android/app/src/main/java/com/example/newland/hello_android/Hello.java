package com.example.newland.hello_android;

import android.annotation.SuppressLint;
import android.os.SystemClock;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.ListView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.time.Month;
import java.time.Year;


public class Hello extends AppCompatActivity implements View.OnClickListener, Chronometer.OnChronometerTickListener {

    private Button Bt1,Bt2,Bt3;
    private Chronometer Chron1;

    private ListView List;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);

        //计时器

        Timer();

        Adapter_test();




    }

    private void Adapter_test() {

        String[] Class = {"Chinese","Math","English","IT"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,Class);


         List = findViewById(R.id.ListView);
         List.setAdapter(adapter);

    }


    private void Timer() {


        Bt1 = findViewById(R.id.Ch_Bt1);
        Bt2 = findViewById(R.id.Ch_Bt2);
        Bt3 = findViewById(R.id.Ch_Bt3);
        Chron1 = findViewById(R.id.chronometer);

        Chron1.setOnChronometerTickListener(this);
        Bt1.setOnClickListener(this);
        Bt2.setOnClickListener(this);
        Bt3.setOnClickListener(this);




    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.Ch_Bt1:
                Chron1.start();
                break;
            case R.id.Ch_Bt2:
                Chron1.stop();
                break;
            case R.id.Ch_Bt3:
                Chron1.setBase(SystemClock.elapsedRealtime());
                break;

        }


    }

    @Override
    public void onChronometerTick(Chronometer chronometer) {

        String time = Chron1.getText().toString();
        if(time.equals("00:30")){
            Toast.makeText(this, "时间到", Toast.LENGTH_SHORT).show();

        }
    }
}
