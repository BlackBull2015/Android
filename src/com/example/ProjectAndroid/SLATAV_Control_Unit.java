package com.example.ProjectAndroid;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

public class SLATAV_Control_Unit extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.control);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }


    public void forward (View v){

        Switch swt = (Switch)findViewById(R.id.switch1);

        if(swt.isChecked()) {
            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context, "forward", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
    public void revers (View v){

        Switch swt = (Switch)findViewById(R.id.switch1);

        if(swt.isChecked()) {
            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context, "revers", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
    public void left (View v){


        Switch swt = (Switch)findViewById(R.id.switch1);

        if(swt.isChecked()) {
            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context, "left", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
    public void right(View v){

        Switch swt = (Switch)findViewById(R.id.switch1);

        if(swt.isChecked()) {

            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context, "right", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
    public void down (View v){

        Switch swt = (Switch)findViewById(R.id.switch1);

        if(swt.isChecked()) {
            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context, "down", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
    public void up (View v){

        Switch swt = (Switch)findViewById(R.id.switch1);

        if(swt.isChecked()) {

            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context, "up", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
    public void switchonoff (View v) {

        Switch swt = (Switch)findViewById(R.id.switch1);
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, swt.isChecked() ? "on" : "off", Toast.LENGTH_SHORT);
        toast.show();
    }
    public void test (View v){

        Switch swt = (Switch)findViewById(R.id.switch1);

        if(swt.isChecked()) {

            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context, "test", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
    public void level (View v){

        Switch swt = (Switch)findViewById(R.id.switch1);

        if(swt.isChecked()) {
            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context, "level", Toast.LENGTH_SHORT);
            toast.show();
        }
    }




}