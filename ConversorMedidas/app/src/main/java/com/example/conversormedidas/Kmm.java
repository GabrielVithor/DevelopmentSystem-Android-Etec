package com.example.conversormedidas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Kmm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kmm);
        final EditText edtMetrosProg = (EditText)findViewById(R.id.edtMetros);
        final EditText edtKmProg = (EditText)findViewById(R.id.edtKm);
        Button btnConverterProg =(Button)findViewById(R.id.btnConverter);
        Button btnNovoProg =(Button)findViewById(R.id.btnNovo);

        btnConverterProg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double metros = Double.parseDouble(edtKmProg.getText().toString());
                double km = metros * 1000;
                edtMetrosProg.setText(String.valueOf(km));
            }
        });

        btnNovoProg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtKmProg.setText("");
                edtMetrosProg.setText("");
                edtKmProg.requestFocus();
            }
        });
    }
}