package com.example.ProjectAndroid;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

public class SLATAV_Control_Unit extends Activity {

    BluetoothAdapter mBluetoothAdapter;
    BluetoothSocket runningsocket;
    BluetoothDevice masterdevice;
    OutputStream outStream;


    private static final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");
    private static String address = "98:D3:33:80:6E:8F";
    private static final String TAG = "MyActivity";
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.control);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        Button  Forward = (Button) findViewById(R.id.button3);
        Button Reverse = (Button)findViewById(R.id.button4);
        Button  Left = (Button)findViewById(R.id.button);
        Button Right = (Button)findViewById(R.id.button2);
        Button Up = (Button)findViewById(R.id.button5);
        Button Down = (Button)findViewById(R.id.button6);

        Forward.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                try {
                    Switch swt = (Switch)findViewById(R.id.switch1);

                    if(swt.isChecked())
                    outStream.write("forward".getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return false;
            }
        });

        Reverse.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                try {
                    Switch swt = (Switch)findViewById(R.id.switch1);

                    if(swt.isChecked())
                    outStream.write("reverse".getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return false;
            }
        });
        Left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                try {
                    Switch swt = (Switch)findViewById(R.id.switch1);

                    if(swt.isChecked())
                    outStream.write("left".getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return false;
            }
        });

        Right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                try {
                    Switch swt = (Switch)findViewById(R.id.switch1);

                    if(swt.isChecked())
                    outStream.write("right".getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return false;
            }
        });


        Up.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                try {
                    Switch swt = (Switch)findViewById(R.id.switch1);

                    if(swt.isChecked())
                    outStream.write("up".getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return false;
            }
        });


        Down.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                try {
                    Switch swt = (Switch)findViewById(R.id.switch1);

                    if(swt.isChecked())
                    outStream.write("down".getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return false;
            }
        });




    }

    public void Connect (View v){
        Log.v(TAG, "Could not send it streem");
        new backgroundAsyncTask().execute("");
        Toast.makeText(this,"Establishing Connection", Toast.LENGTH_SHORT).show();

    }

    public void switchonoff (View v) throws IOException {

        Switch swt = (Switch)findViewById(R.id.switch1);
        Context context = getApplicationContext();

        outStream.write((swt.isChecked() ? "on" : "off").getBytes());
        Toast toast = Toast.makeText(context, swt.isChecked() ? "on" : "off", Toast.LENGTH_SHORT);
        toast.show();
    }
    public void test (View v) throws IOException {

        Switch swt = (Switch)findViewById(R.id.switch1);

        if(swt.isChecked()) {
            outStream.write("test".getBytes());
        }
    }
    public void level (View v) throws IOException {

        Switch swt = (Switch)findViewById(R.id.switch1);

        if(swt.isChecked()) {
            outStream.write("level".getBytes());
        }
    }

    private class backgroundAsyncTask extends AsyncTask<String, Void, String> {

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }

        @Override
        protected String doInBackground(String... params) {
            try {


                Log.e(TAG, "Getting device");
                masterdevice = mBluetoothAdapter.getRemoteDevice(address);
                Log.e(TAG, "Getting socket");
                runningsocket = masterdevice.createRfcommSocketToServiceRecord(MY_UUID);
                Log.e(TAG, "Attempting to connecto to socket");
                runningsocket.connect();
                Log.e(TAG, "Getting out strem");

                outStream = runningsocket.getOutputStream();
                Log.e(TAG, "Wtiring to output stream");
                outStream.write("Hello world".getBytes());

            } catch (IOException e) {
                e.printStackTrace();
            }


            return "";
        }// doInBackground

    }// backgroundAsyncTask
}