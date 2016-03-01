package com.example.ProjectAndroid;

        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;

/**
 * Created by Eric on 3/1/2016.
 */
public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

    }


    public void bluetooth(View v){
        Intent inte = new Intent(this,BluetoothCon.class);
        startActivity(inte);
    }

    public void SLATAV(View v){
        Intent inte = new Intent(this,SLATAV_Control_Unit.class);
        startActivity(inte);
    }

}


