package com.example.caculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView result,solution;
    MaterialButton C,R,open,close;
    MaterialButton B9,B8,B7,Mul;
    MaterialButton B6,B5,B4,Div;
    MaterialButton B3,B2,B1,plus;
    MaterialButton B0,dot,minus,equal;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void onClick(View v) {

    }
}