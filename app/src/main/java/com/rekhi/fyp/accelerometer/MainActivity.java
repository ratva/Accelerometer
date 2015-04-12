package com.rekhi.fyp.accelerometer;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends ActionBarActivity implements SensorEventListener{

    Sensor accelerometer;
    SensorManager sensorManager;
    TextView xText;
    TextView yText;
    TextView zText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);
        accelerometer=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);

        xText=(TextView)findViewById(R.id.xText);
        yText=(TextView)findViewById(R.id.yText);
        zText=(TextView)findViewById(R.id.zText);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        xText.setText(Html.fromHtml(event.values[0]+" ms<sup><small>-2</small></sup>"));
        yText.setText(Html.fromHtml(event.values[1]+" ms<sup><small>-2</small></sup>"));
        zText.setText(Html.fromHtml(event.values[2]+" ms<sup><small>-2</small></sup>"));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}

