package com.example.aula2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSobreProg = (Button) findViewById(R.id.btnSobre);
        Button btnTelProg = (Button) findViewById(R.id.btnTel);

        btnSobreProg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this,sobre.class);
                startActivity(it);
            }
        });

        btnTelProg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this,telefone.class);
                startActivity(it);
            }
        });

    }
}