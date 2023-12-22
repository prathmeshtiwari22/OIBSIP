package com.example.unit_converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public Button bt;
    public TextView tv1,tv2,tv3,tv4;
    public EditText ed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      tv1 = findViewById(R.id.textViewPOUTPUT);
      tv2 = findViewById(R.id.textViewOUTPUTGRAMS);
      ed = findViewById(R.id.editTextKG);
      bt =findViewById(R.id.buttonClick);
      bt.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              // Calling function...
              Handlers();
          }

          private void Handlers() {
              //logic
              String InputKg = ed.getText().toString();
              double Kg = Double.parseDouble(InputKg);
              double pound = Kg * 2.2056;
              double grams = Kg * 1000;
              tv1.setText("" + pound);
              tv2.setText("" + grams);
          }
      });


    }
}