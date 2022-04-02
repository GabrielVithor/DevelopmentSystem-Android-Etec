package com.example.jogodescubranumero;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView txtDicaPRog;
    EditText edtValorProg;
    EditText edtValorOcultoProg;
    int valorOculto =  gerarNumero();
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtDicaPRog = findViewById(R.id.txtDica);
        edtValorProg = findViewById(R.id.edtValor);
        edtValorOcultoProg = findViewById(R.id.edtValorOculto);
        getSupportActionBar().hide();
    }

    public int gerarNumero(){
        Random gerarNumero = new Random();
    int numero = gerarNumero.nextInt(10)+1;
    return numero;
    }

        public void clickBtnEnviar(View v){
        int valor = Integer.parseInt(edtValorProg.getText().toString());
        if(valor == valorOculto){
            txtDicaPRog.setText("Parabéns");
            edtValorOcultoProg.setText(""+valorOculto);
            mp = MediaPlayer.create(MainActivity.this,R.raw.aplauso);
            mp.start();mp = MediaPlayer.create(MainActivity.this,R.raw.aplauso);
            mp.start();        }
        else{
            mp = MediaPlayer.create(MainActivity.this,R.raw.erro);
            mp.start();
            if(valor < valorOculto){
                txtDicaPRog.setText("O valor oculto é maior que"+valor);
                edtValorProg.setText("");
                edtValorProg.requestFocus();
            }else{
                txtDicaPRog.setText("O valor oculto é menor que "+valor);
edtValorProg.setText("");
edtValorProg.requestFocus();
     }
    }
}
    public void clickBtnNovo(View v){
        txtDicaPRog.setText("O número está entre 1 e 10");
        edtValorProg.setText("");
        edtValorOcultoProg.setText("?");
valorOculto=gerarNumero();
}
}