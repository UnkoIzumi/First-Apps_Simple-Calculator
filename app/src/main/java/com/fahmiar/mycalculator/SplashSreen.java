package com.fahmiar.mycalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

public class SplashSreen extends AppCompatActivity {
    public int time_cd=4000;

    //4000=4 detik
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_sreen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //setelah loading maka akan langsung berpindah ke home activity
                Intent MainActivity=new Intent(SplashSreen.this, MainActivity.class);
                startActivity(MainActivity);
                finish();

            }
        },time_cd);

    }
}