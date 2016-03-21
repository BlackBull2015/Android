package com.example.ProjectAndroid;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Set;
import java.util.UUID;

/**
 * Created by Eric on 3/1/2016.
 */
public class BluetoothCon extends Activity {

    BluetoothAdapter mBluetoothAdapter;
    ListView lvt;


    ArrayAdapter mArrayAdapter;
    BluetoothDevice masterdevice;


    private static final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");
    Set<BluetoothDevice> pairedDevices;
    BluetoothSocket runningsocket;


    OutputStream outStream;


//   ConnectThread connect;
   // ConnectedThread running;

    private static String address = "98:D3:33:80:6E:8F";
    private static final String TAG = "MyActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bluetooth);
        lvt = (ListView) findViewById(R.id.listView);

        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        mArrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1);
        lvt.setAdapter(mArrayAdapter);

        SettingUp();
//
//
//        lvt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                connect = new ConnectThread(masterdevice);
//                connect.run();
//                Toast.makeText(getApplicationContext(),
//                        "Click ListItem Number " + position, Toast.LENGTH_LONG)
//                        .show();
//            }
//        });



    }


    public void connect(View v){
        Log.v(TAG,"Socket created");


       new backgroundAsyncTask().execute("run");

//        BluetoothDevice device = mBluetoothAdapter.getRemoteDevice(address);

//        connect = new ConnectThread(device);
//        connect.run();

    }


    public void connect2(View v){
//        Log.v(TAG, "Socket created");
//        running = new ConnectedThread(runningsocket);
//        running.run();
    }




    private class backgroundAsyncTask extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {

        }


        @Override
        protected String doInBackground(String... params) {



            try {
                masterdevice = mBluetoothAdapter.getRemoteDevice(address);
                runningsocket = masterdevice.createRfcommSocketToServiceRecord(MY_UUID);
                runningsocket.connect();
                outStream = runningsocket.getOutputStream();

            } catch (IOException e) {
                e.printStackTrace();
            }


            return "";
        }// doInBackground

    }// backgroundAsyncTask


    public void kill(View v) throws IOException {
        runningsocket.close();
    }

    public void SendData (View v) throws IOException {
        EditText edt = (EditText) findViewById(R.id.TextArea1);
        outStream.write(edt.getText().toString().getBytes());
   }

//
//
//
//    private class ConnectThread extends Thread {
//      //  private final BluetoothSocket mmSocket;
//
//        private final BluetoothDevice mmDevice;
//
//        public ConnectThread(BluetoothDevice device) {
//            // Use a temporary object that is later assigned to mmSocket,
//            // because mmSocket is final
//            BluetoothSocket tmp = null;
//            mmDevice = device;
//
//            // Get a BluetoothSocket to connect with the given BluetoothDevice
//            try {
//                // MY_UUID is the app's UUID string, also used by the server code
//                tmp = device.createRfcommSocketToServiceRecord(MY_UUID);
//                Log.v(TAG,"Geting tmp");
//            } catch (IOException e) { }
//            runningsocket = tmp;
//        }
//
//        public void run() {
//            Log.v(TAG,"Running");
//            // Cancel discovery because it will slow down the connection
//            mBluetoothAdapter.cancelDiscovery();
//
//            try {
//                // Connect the device through the socket. This will block
//                // until it succeeds or throws an exception
//                runningsocket.connect();
//                Log.v(TAG, "connecting");
//            } catch (IOException connectException) {
//                // Unable to connect; close the socket and get out
//                try {
//                    Log.e(TAG, "mm close");
//                    runningsocket.close();
//                } catch (IOException closeException) { }
//                return;
//            }
//            try {
//                byte[] buff = "Hello world ".getBytes();
//                Log.v(TAG, "Creating output streem");
//                OutputStream outStream = runningsocket.getOutputStream();
//                    Log.v(TAG, "Sending data");
//                    outStream.write(buff);
//                    outStream.flush();
//            }catch(IOException e){
//                Log.e(TAG, "Could not send it streem");
//            }
//            // Do work to manage the connection (in a separate thread)
////            tt1 = new ConnectedThread(mmSocket);
////            tt1.run();
//        }
//
//        /** Will cancel an in-progress connection, and close the socket */
//        public void cancel() {
//            try {
//                runningsocket.close();
//            } catch (IOException e) { }
//        }
//    }
//
//
//    public void kill(View v) throws IOException {
//        runningsocket.close();
//    }
//
//    public void SendData (View v){
//        EditText edt = (EditText) findViewById(R.id.TextArea1);
//        running.write(edt.getText().toString().getBytes());
//   }
//
//
//        private class ConnectedThread extends Thread {
//        private final BluetoothSocket mmSocket;
//        private final InputStream mmInStream;
//        private final OutputStream mmOutStream;
//
//        public ConnectedThread(BluetoothSocket socket) {
//            mmSocket = socket;
//            InputStream tmpIn = null;
//            OutputStream tmpOut = null;
//
//            // Get the input and output streams, using temp objects because
//            // member streams are final
//            try {
//                tmpIn = socket.getInputStream();
//                tmpOut = socket.getOutputStream();
//            } catch (IOException e) { }
//
//            mmInStream = tmpIn;
//            mmOutStream = tmpOut;
//        }
//
//        public void run() {
//
//            byte[] btf = new byte[24];
//            byte[] buffer = new byte[1024];  // buffer store for the stream
//            int bytes; // bytes returned from read()
//            TextView txtv = (TextView)findViewById(R.id.textView5);
//            int txt;
//            try {
//                byte[] buff = "hi there 2".getBytes();
//                Log.v(TAG, "Creating output streem");
//                OutputStream outStream = runningsocket.getOutputStream();
//
//                    outStream.write(buff);
//                    outStream.flush();
//            }catch(IOException e){
//                Log.e(TAG, "Could not send it streem");
//            }
////            // Keep listening to the InputStream until an exception occurs
////            while (true) {
////                try {
////
////
////                    txt = mmInStream.read();
////
////                    txtv.setText(txt);
////
////                } catch (IOException e) {
////                    break;
////                }
////            }
//        }
//
//        /* Call this from the main activity to send data to the remote device */
//        public void write(byte[] bytes) {
//            try {
//                mmOutStream.write(bytes);
//            } catch (IOException e) { }
//        }
//
//        /* Call this from the main activity to shutdown the connection */
//        public void cancel() {
//            try {
//                mmSocket.close();
//            } catch (IOException e) { }
//        }
//    }



    public void write(byte[] bytes) {
        try {
            outStream.write(bytes);
        } catch (IOException e) { }
    }



    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        unregisterReceiver(mReceiver);
        try {
            runningsocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //  connect.cancel();
    }


    public void SettingUp(){
        //Check is bluetooth suported
        if (mBluetoothAdapter == null) {
            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context, "Bluetooth not found", Toast.LENGTH_SHORT);
            toast.show();
        }else{
            //Check is bluetooth enabled
            if (!mBluetoothAdapter.isEnabled()) {
                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, 101);

                    Toast.makeText(getApplicationContext(),"Bluetooth turned on" ,
                            Toast.LENGTH_LONG).show();
                }
            else {
                Toast.makeText(getApplicationContext(),"Bluetooth already turned on" ,
                        Toast.LENGTH_LONG).show();

            }
        }
    }

    final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            // When discovery finds a device
            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                // Get the BluetoothDevice object from the Intent
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                if(device.getName().toString().contains("ERIC")){
                    masterdevice = device;
                }
                // Add the name and address to an array adapter to show in a ListView
                mArrayAdapter.add(device.getName() + "\n" + device.getAddress());
                mArrayAdapter.notifyDataSetChanged();
            }
        }
    };

    public void discover (View v){
        //Create a BroadcastReceiver for ACTION_FOUND
        if (mBluetoothAdapter.isDiscovering()) {
            // the button is pressed when it discovers, so cancel the discovery
            mBluetoothAdapter.cancelDiscovery();
        }
        else {
           // mArrayAdapter.clear();
            mBluetoothAdapter.startDiscovery();

            registerReceiver(mReceiver, new IntentFilter(BluetoothDevice.ACTION_FOUND));
        }
            }

    public void paried(View v ){
        pairedDevices  = mBluetoothAdapter.getBondedDevices();
        // If there are paired devices
        if (pairedDevices.size() > 0) {
            // Loop through paired devices
            for (BluetoothDevice device : pairedDevices) {
                // Add the name and address to an array adapter to show in a ListView
                mArrayAdapter.add(device.getName() + "\n" + device.getAddress());
                if(device.getName().toString().contains("HC"));
                masterdevice = device;
            }
        }
        lvt.setAdapter(mArrayAdapter);
    }



}
