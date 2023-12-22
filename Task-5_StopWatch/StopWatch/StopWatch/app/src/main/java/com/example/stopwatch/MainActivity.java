package com.example.stopwatch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;


public class MainActivity extends AppCompatActivity {
  //init variables
    private int sec;
    private boolean go;
    private boolean wasrun;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null){
            savedInstanceState.getInt("seconds");
            savedInstanceState.getBoolean("running");
            savedInstanceState.getBoolean("wasrunning");
        }
        //calling the method
        letsgo();
    }

    public void onStart(View view){
        go =true;
    }
    public void onStop(View view){
        go = false;
    }
    public void onRestart(View view){
        go = false;
        sec =0;
    }

    @Override
    protected void onPause() {
        super.onPause();
        wasrun =go;
        go = false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(wasrun){
           go =true;
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        //state...
        outState.putInt("seconds",sec);
        outState.putBoolean("running",go);
        outState.putBoolean("wasrunning",wasrun);

    }

    private void letsgo() {
        TextView time = findViewById(R.id.textViewTimer);
        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                //logic of time dispaly
                int hrs = sec/3600;
                int min = (sec % 3600)/60;
                int secs = (sec%60);

                String waqt= String.format(Locale.getDefault(),"%d:%02d:%02d",hrs,min,secs);

                time.setText(waqt);

                if(go) {
                   sec++;
                }
                handler.postDelayed(this,1000);

            }
        });
    }
}