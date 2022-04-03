package com.example.luximetro;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SensorManager sensorManager;
    private Sensor sensor;
    private SensorEventListener sensorEventListener;
    float valuemin = 100000;
    float valuemax = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        if (sensor == null) {
            Toast.makeText(this, "O dispositivo não possui luximetro", Toast.LENGTH_SHORT).show();
            finish();
        }

        sensorEventListener = new SensorEventListener() {


            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                float value = sensorEvent.values[0];
                TextView txtresultadoProg = (TextView) findViewById(R.id.txtresultado);
                TextView txtluxmin = (TextView) findViewById(R.id.txtluxmenor);
                TextView txtluxmax = (TextView) findViewById(R.id.txtluxmaior);
                if(valuemin > value){
                    valuemin = value;
                }else if(valuemax < value){
                    valuemax = value;
                }

                txtresultadoProg.setText("Luminosidade: " + value + "lx");
                txtluxmin.setText("Luminosidade minima: " + valuemin + "lx");
                txtluxmax.setText("Luminosidade maxima: " + valuemax + "lx");
            }


            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };

    }



    @Override
    protected  void onResume(){
        super.onResume();
        sensorManager.registerListener(sensorEventListener,sensor,SensorManager.SENSOR_DELAY_FASTEST);
    }
    @Override
    protected  void onPause(){
        super.onPause();
        sensorManager.unregisterListener(sensorEventListener);
    }

}