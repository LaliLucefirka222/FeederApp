package com.example.feederapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button openFragBtn;
    private LinearLayout mainLayout;
//    private boolean isButtonShowing = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openFragBtn = (Button) findViewById(R.id.buttonOpenFragment);
        mainLayout = (LinearLayout) findViewById(R.id.mainLayout);


    }

    public void goToOptions(View view) {
        Intent contractorIntent = new Intent(MainActivity.this, OptionActivity.class);
        startActivity(contractorIntent);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_int, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_add) {
            LinearLayout layout = new LinearLayout(this);
            layout.setOrientation(LinearLayout.HORIZONTAL);
            TextView textTime = new TextView(this);
            textTime.setText("8:30");
            textTime.setTextSize(60);
            textTime.setPadding(50, 0, 0, 0);

            Switch sw = new Switch(this);
            //sw.setPadding(400, 0, 0, 0);
            sw.setPaddingRelative(535, 0, 0, 0);
            sw.setTextSize(60);

            layout.addView(textTime);
            layout.addView(sw);

            Button but = new Button(this);
            but.setText("пн, вт, ср, чт, пт, сб, вс");
            but.setOnClickListener(this::goToOptions);

            mainLayout.addView(layout);
            mainLayout.addView(but);
        }

        return super.onOptionsItemSelected(item);
    }

//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putBoolean("is_button_showed", isButtonShowing);
//    }
//
//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        if (savedInstanceState.getBoolean("is_button_showed", false)) {
//            addDynamicButton();
//        }
//    }
//
//    private void addDynamicButton() {
//        if (!isButtonShowing) {
//            Button addedButton = new Button(MainActivity.this);
//            mainLayout.addView(addedButton);
//            isButtonShowing = true;
//        }
//    }

}