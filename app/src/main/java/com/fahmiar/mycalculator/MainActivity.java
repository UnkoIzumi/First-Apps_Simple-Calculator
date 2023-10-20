package com.fahmiar.mycalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Typeface;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText Text_lcd;
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    Button btntambah, btnsama, btnkali, btnbagi, btnkurang;
    Button btnc;

    public static double now_value = 0;
    public static String now_operasi = "";
    public static double hasil = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Typeface tf = Typeface.createFromAsset(getAssets(),
                "font/Witha Sign II.ttf");
        TextView tv = findViewById(R.id.textView2);
        tv.setTypeface(tf);

        init();
    }

    void init(){
    //number
        Text_lcd = findViewById(R.id.Text_lcd);
        btn0 = findViewById(R.id.btn0);
        btn0.setOnClickListener(this);
        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
        btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(this);
        btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(this);
        btn4 = findViewById(R.id.btn4);
        btn4.setOnClickListener(this);
        btn5 = findViewById(R.id.btn5);
        btn5.setOnClickListener(this);
        btn6 = findViewById(R.id.btn6);
        btn6.setOnClickListener(this);
        btn7 = findViewById(R.id.btn7);
        btn7.setOnClickListener(this);
        btn8 = findViewById(R.id.btn8);
        btn8.setOnClickListener(this);
        btn9 = findViewById(R.id.btn9);
        btn9.setOnClickListener(this);
    //operasi
        btntambah =(Button) findViewById(R.id.btntambah);
        btntambah.setOnClickListener(this);
        btnkurang =(Button) findViewById(R.id.btnkurang);
        btnkurang.setOnClickListener(this);
        btnkali =(Button) findViewById(R.id.btnkali);
        btnkali.setOnClickListener(this);
        btnbagi =(Button) findViewById(R.id.btnbagi);
        btnbagi.setOnClickListener(this);
        btnsama =(Button) findViewById(R.id.btnsama);
        btnsama.setOnClickListener(this);
    //clear
        btnc =(Button) findViewById(R.id.btnc);
        btnc.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //number btn
            case R.id.btn0:
                Text_lcd.setText(Text_lcd.getText().toString().trim()+"0");
                break;
            case R.id.btn1:
                Text_lcd.setText(Text_lcd.getText().toString().trim()+"1");
                break;
            case R.id.btn2:
                Text_lcd.setText(Text_lcd.getText().toString().trim()+"2");
                break;
            case R.id.btn3:
                Text_lcd.setText(Text_lcd.getText().toString().trim()+"3");
                break;
            case R.id.btn4:
                Text_lcd.setText(Text_lcd.getText().toString().trim()+"4");
                break;
            case R.id.btn5:
                Text_lcd.setText(Text_lcd.getText().toString().trim()+"5");
                break;
            case R.id.btn6:
                Text_lcd.setText(Text_lcd.getText().toString().trim()+"6");
                break;
            case R.id.btn7:
                Text_lcd.setText(Text_lcd.getText().toString().trim()+"7");
                break;
            case R.id.btn8:
                Text_lcd.setText(Text_lcd.getText().toString().trim()+"8");
                break;
            case R.id.btn9:
                Text_lcd.setText(Text_lcd.getText().toString().trim()+"9");
                break;
            //operasi
            case R.id.btntambah:
                if(Text_lcd.getText().toString().trim().equals("")){
                    Toast.makeText(MainActivity.this, "Angka diisi !", Toast.LENGTH_SHORT).show();
                    return;
                }

                now_operasi = "tambah";
                now_value = Double.parseDouble(Text_lcd.getText().toString());
                Text_lcd.setText("");
                break;
            case R.id.btnkurang:
                if(Text_lcd.getText().toString().trim().equals("")){
                    Toast.makeText(MainActivity.this, "Angka diisi !", Toast.LENGTH_SHORT).show();
                    return;
                }
                now_operasi = "kurang";
                now_value = Double.parseDouble(Text_lcd.getText().toString());
                Text_lcd.setText("");
                break;
            case R.id.btnkali:
                if(Text_lcd.getText().toString().trim().equals("")){
                    Toast.makeText(MainActivity.this, "Angka diisi !", Toast.LENGTH_SHORT).show();
                    return;
                }
                now_operasi = "kali";
                now_value = Double.parseDouble(Text_lcd.getText().toString());
                Text_lcd.setText("");
                break;
            case R.id.btnbagi:
                if(Text_lcd.getText().toString().trim().equals("")){
                    Toast.makeText(MainActivity.this, "Angka diisi !", Toast.LENGTH_SHORT).show();
                    return;
                }
                now_operasi = "bagi";
                now_value = Double.parseDouble(Text_lcd.getText().toString());
                Text_lcd.setText("");
                break;
            // option
            case R.id.btnc:
                now_value = 0;
                Text_lcd.setText("");
                break;
            case R.id.btnsama:
                if(now_operasi.equals("tambah")) {
                   hasil = now_value + Double.parseDouble(Text_lcd.getText().toString().trim());
                }if(now_operasi.equals("kurang")) {
                hasil = now_value - Double.parseDouble(Text_lcd.getText().toString().trim());
                }if(now_operasi.equals("kali")) {
                hasil = now_value * Double.parseDouble(Text_lcd.getText().toString().trim());
                }if(now_operasi.equals("bagi")) {
                hasil = now_value / Double.parseDouble(Text_lcd.getText().toString().trim());
                }

                //jika hasil sama
                int nilaitemp = (int) hasil;
                if(nilaitemp == hasil){
                    Text_lcd.setText(String.valueOf((int)hasil));
                }else{
                    Text_lcd.setText(String.valueOf(hasil));
                }
                break;
        }
    }
}