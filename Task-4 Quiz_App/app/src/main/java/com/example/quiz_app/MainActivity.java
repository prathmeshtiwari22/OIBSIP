package com.example.quiz_app;

import static android.graphics.Color.MAGENTA;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView TQ;
    Button O1,O2,O3,O4;
    Button doneBtn;
    TextView Qn;
    int level=0;
    int TQ1 = JawabandSawaal.Sawaal.length;
    int cureentQ = 0;
    String selected = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Mapping of xml objects

        TQ = findViewById(R.id.totalq);
        Qn = findViewById(R.id.question);
        O1 = findViewById(R.id.optionA);
        O2 = findViewById(R.id.optionB);
        O3 = findViewById(R.id.optionC);
        O4 = findViewById(R.id.optionD);
        doneBtn = findViewById(R.id.done);

        //Action
        O1.setOnClickListener(this);
        O2.setOnClickListener(this);
        O3.setOnClickListener(this);
        O4.setOnClickListener(this);
        doneBtn.setOnClickListener(this);

        //logic
        TQ.setText("Total Questions:"+TQ1);

        //calling new Method...
        Nextone();

    }

    private void Nextone() {

        if(cureentQ == TQ1){
            okaydone();
            return;
        }
        Qn.setText(JawabandSawaal.Sawaal[cureentQ]);
        O1.setText(JawabandSawaal.optionss[cureentQ][0]);
        O2.setText(JawabandSawaal.optionss[cureentQ][1]);
        O3.setText(JawabandSawaal.optionss[cureentQ][2]);
        O4.setText(JawabandSawaal.optionss[cureentQ][3]);

    }

    private void okaydone() {
        String cash = "";
        if(level > TQ1*0.60){
            cash = "10";
        }
        else {
            cash = "Nothing";
        }
        //restartlogic
        new AlertDialog.Builder(this).setTitle(cash).
                setMessage("Your Cash is"+cash+"out of "+TQ1)
                        .setPositiveButton("Restart",(dialogInterface,i) -> restart())
                      .setCancelable(false).show();
    }

    //inbuild function
    @Override
    public void onClick(View v) {
        //colors of button
        O1.setBackgroundColor(Color.WHITE);
        O2.setBackgroundColor(Color.WHITE);
        O3.setBackgroundColor(Color.WHITE);
        O4.setBackgroundColor(Color.WHITE);

        //button clicking logic
        Button clickb = (Button) v;
        if (clickb.getId()==R.id.done){
            if(selected.equals(JawabandSawaal.jawaab[cureentQ])){
                level++;
            }
            //done results
            cureentQ++;
            Nextone();

        }else {
            //other clicks
            selected = clickb.getText().toString();
            clickb.setBackgroundColor(Color.BLUE);

        }

    }

    void restart(){
        level =0;
        cureentQ=0;
        Nextone();
    }

}