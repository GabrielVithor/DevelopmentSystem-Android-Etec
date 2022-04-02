package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ligação de componentes da classe com os componentes da interface
        Button btnSomarProg = (Button) findViewById(R.id.btnSomar);
        Button btnLimparProg = (Button) findViewById(R.id.btnLimpar);
        Button btnSubtrairProg  = (Button) findViewById(R.id.btnSubtrair);
        Button btnMultiplicarProg = (Button) findViewById(R.id.btnMultiplicar);
        Button btnDividirProg = (Button) findViewById(R.id.btnDividir);
        EditText edtValor01Prog = (EditText) findViewById(R.id.edtValor01);
        EditText edtValor02Prog = (EditText) findViewById(R.id.edtValor2);
        EditText edtResultadoProg = (EditText) findViewById(R.id.edtResultado);

        //Método responsavel pea captura do clique do botao btnSomar
        //e execução da ação execuadao ao clique


        btnSomarProg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Setar valores das variaveis e realizar conversoses das varaivei
                double num1 = Double.parseDouble(edtValor01Prog.getText().toString());
                double num2 = Double.parseDouble(edtValor02Prog.getText().toString());
                double resultado = num1 + num2;
                edtResultadoProg.setText(String.valueOf(resultado));
            }
        });

        btnSubtrairProg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                double num1 = Double.parseDouble(edtValor01Prog.getText().toString());
                double num2 = Double.parseDouble(edtValor02Prog.getText().toString());
                double resultado = num1 - num2;
                edtResultadoProg.setText(String.valueOf(resultado));
            }
        });

        btnMultiplicarProg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1 = Double.parseDouble(edtValor01Prog.getText().toString());
                double num2 = Double.parseDouble(edtValor02Prog.getText().toString());
                double resultado = num1 * num2;
                edtResultadoProg.setText(String.valueOf(resultado));
            }
        });

        btnDividirProg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1 = Double.parseDouble(edtValor01Prog.getText().toString());
                double num2 = Double.parseDouble(edtValor02Prog.getText().toString());
                double resultado = num1 / num2;
                edtResultadoProg.setText(String.valueOf(resultado));
            }
        });

        btnLimparProg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtValor01Prog.setText("");
                edtValor02Prog.setText("");
                edtResultadoProg.setText("");
                edtValor01Prog.requestFocus();

            }
        });
    }
}