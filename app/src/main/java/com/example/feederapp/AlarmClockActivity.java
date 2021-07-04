package com.example.feederapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

public class AlarmClockActivity extends AppCompatActivity {

    private Button button, buttonOption;
    private LinearLayout linearLayout1, linearLayout2;
    private Switch aSwitct;
    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm_clock_activity);

        button = (Button) findViewById(R.id.button2);
        linearLayout1 = (LinearLayout) findViewById(R.id.linearLayout);
        linearLayout2 = (LinearLayout) findViewById(R.id.linearLayout2);

        aSwitct = (Switch) findViewById(R.id.switch2);
        buttonOption = (Button) findViewById(R.id.buttonOption);


        button.setOnClickListener((view) -> {
            counter = linearLayout1.getChildCount() + 2;
            if (counter < 9) {
                TextView t1 = new TextView(this);
                TextView t2 = new TextView(this);

                t1.setText("8:30");
                t1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                t1.setTextSize(60);

                t2.setText("пн, вт, ср,чт, пт, сб, вс");
                t2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                t2.setTextSize(20);

                Switch s = new Switch(getApplicationContext());
                //s.setText("");
                s.setLayoutParams(aSwitct.getLayoutParams());


                Button b = new Button(getApplicationContext());
                b.setText("^");
                b.setBackground(getDrawable(R.drawable.trans));
                b.setTextColor(getColor(R.color.black));
                b.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                b.setLayoutParams(buttonOption.getLayoutParams());

                linearLayout1.addView(t1);
                linearLayout1.addView(t2);
                linearLayout2.addView(s);
                linearLayout2.addView(b);
            }
        });

//        buttonOption.setOnClickListener((view) -> {
//            Intent contractorIntent = new Intent(AlarmClockActivity.this, OptionAlarmClockActivity.class);
//            startActivity(contractorIntent);
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_int, menu);
        return true;
    }
}