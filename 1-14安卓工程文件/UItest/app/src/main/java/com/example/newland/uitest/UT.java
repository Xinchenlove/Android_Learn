package com.example.newland.uitest;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;


public class UT extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private static  int Sex = 10;
    private int BT_S = 0;
    private TextView TV1;
private int len = 0;

private EditText EditText1,EditText4;
private Button BT_One,BT_Two,BT_Thire,Course;
private RadioButton Boy ,Gril;
private CheckBox Math,Chinese,English,IT;
private ToggleButton ToggleBT1;
private Switch SW1;
private ImageView Lamp;
private ProgressBar PBL,SPBL;
private SeekBar SBR;
private RatingBar Start;

    public   int i =0;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut);


        TV1 = findViewById(R.id.TV1);
        EditText1 = findViewById(R.id.EditText1);
        EditText4 = findViewById(R.id.EditText4);

        BT_One = findViewById(R.id.Button_One);
        BT_Two = findViewById(R.id.Button_Two);
        BT_Thire = findViewById(R.id.Button_Thire);
        Boy = findViewById(R.id.boy);
        Gril = findViewById(R.id.girl);

        Lamp = findViewById(R.id.Lamp);

        ToggleBT1 = findViewById(R.id.ToggleBu);
        SW1 = findViewById(R.id.SwitchT);

        PBL = findViewById(R.id.ProgressBar_L);



        Math = findViewById(R.id.Math);
        Chinese = findViewById(R.id.Chinese);
        English = findViewById(R.id.English);
        IT = findViewById(R.id.IT);
        Course = findViewById(R.id.course);




        //BT_Two.setText("按钮可用");
        BT_One.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(BT_Two.getText().equals("按钮不可用")){
                    BT_Two.setEnabled(true);
                    BT_Two.setText("按钮可用");
                    Toast.makeText(UT.this, "可用", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    BT_Two.setEnabled(false);
                    BT_Two.setText("按钮不可用");
                    Toast.makeText(UT.this, "不可用", Toast.LENGTH_SHORT).show();
                }

            }


        });

        BT_Two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(UT.this, "BT_Two按下", Toast.LENGTH_SHORT).show();
            }
        });

        BT_Thire.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
            i++;
                switch (i){
                    case 1: BT_Thire.setBackgroundColor(Color.parseColor("#FFff00"));
                        break;
                    case 2: BT_Thire.setBackgroundColor(Color.parseColor("#00ff00"));
                        break;

                    case 3: BT_Thire.setBackgroundColor(Color.parseColor("#00ffFF"));
                        break;

                    case 4: BT_Thire.setBackgroundColor(Color.parseColor("#0000ff"));
                        break;

                    case 5: BT_Thire.setBackgroundColor(Color.parseColor("#ff0000"));
                        break;

                    case 6: BT_Thire.setBackgroundColor(Color.parseColor("#0ff0ff0"));
                        break;

                    case 7: BT_Thire.setBackgroundColor(Color.parseColor("#f0f00f"));
                        break;
                    case 8: BT_Thire.setBackgroundColor(Color.parseColor("#ffffff"));
                        break;
                    case 9:i = 1;
                        break;

                }
            }
        });
                Boy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Toast.makeText(UT.this, "Now Chose Boy", Toast.LENGTH_SHORT).show();
                        Sex = 0;

                    }
                });


        Gril.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(UT.this, "Now Chose Girl", Toast.LENGTH_SHORT).show();
                Sex = 1;

            }
        });

        Math.setOnCheckedChangeListener(this);
        Chinese.setOnCheckedChangeListener(this);
        English.setOnCheckedChangeListener(this);
        IT.setOnCheckedChangeListener(this);




        Course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String S = "";
                if(Math.isChecked()){
                    S+=Math.getText().toString()+" ";
                }
                if(Chinese.isChecked()){
                    S+=Chinese.getText().toString()+" ";
                }
                if(English.isChecked()){
                    S+=English.getText().toString()+" ";
                }
                if(IT.isChecked()){
                    S+=IT.getText().toString()+" ";
                }
                Toast.makeText(UT.this, S, Toast.LENGTH_SHORT).show();


            }
        });


        ToggleBT1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                if(ToggleBT1.isChecked()){
                   Lamp.setImageResource(R.drawable.lamp_on);

                }else
                    Lamp.setImageResource(R.drawable.lamp_off);


            }
        });


        SW1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(SW1.isChecked()){
                    ToggleBT1.setEnabled(true);
                }else
                    ToggleBT1.setEnabled(false);

            }
        });


            SeekBar_View();
            Start_View();






    }



    private void Start_View() {
        Start = findViewById(R.id.Start10);
        Start.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                SPBL.setProgress((int)Start.getRating()*10);

            }
        });
    }

    private void SeekBar_View() {
        SBR = findViewById(R.id.SeekBarFF);
        SPBL = findViewById(R.id.ProgressBarFF);
            SBR.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                    SPBL.setProgress(SBR.getProgress());
                    //Start.setNumStars(SBR.getProgress());
                    Start.setRating((float)SBR.getProgress()/10f);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                    //SPBL.setProgress(SBR.getProgress());
                    Toast.makeText(UT.this, "按下了哦", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    Toast.makeText(UT.this, "拜拜", Toast.LENGTH_SHORT).show();
                    //SPBL.setProgress(SBR.getProgress());
                }
            });


    }




    public void bt1(View view) {

        TV1.setText(Integer.toString(EditText1.getSelectionStart()));

    }


    public void bt2(View view) {
        EditText4.setText("");
    }

    public void Sex_OK(View view) {
        if(Sex == 0)
        Toast.makeText(this, "Yor Chose is Boy", Toast.LENGTH_SHORT).show();
        else if(Sex == 1)
         Toast.makeText(this, "Yor Chose is Girl", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "PlaseChose", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

        if(compoundButton.isChecked()){
            Toast.makeText(this, compoundButton.getText().toString(), Toast.LENGTH_SHORT).show();
        }

    }

    public void add(View view) {
len++;
        PBL.setProgress(len);
    }
}


