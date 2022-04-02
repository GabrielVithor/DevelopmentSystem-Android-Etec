package com.example.jogodavelha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.function.Function;

public class MainActivity extends AppCompatActivity {
    String jogador = "X";
    String[][] matrizVerificarJogador = new String[3][3];
    int jogadas = 0;
    public void trocaJogador()
    {
        if(jogador.equals("X"))
        {
            jogador = "O";
        }
        else
        {
            jogador = "X";
        }
        jogadas++;
    }

    private boolean verificaJogador()
    {
        boolean ganhador = false;
        for (int i = 0; i < 3; i++) {
            //Ganhador horizontal
            if (matrizVerificarJogador[i][0].equals(matrizVerificarJogador[i][1]) && matrizVerificarJogador[i][0].equals(matrizVerificarJogador[i][2])) {
                ganhador = true;
            }
            if (matrizVerificarJogador[0][i].equals(matrizVerificarJogador[1][i]) && matrizVerificarJogador[0][i].equals(matrizVerificarJogador[2][i])){
                //Ganhador vertical
                ganhador = true;
            }
            if (matrizVerificarJogador[0][0].equals(matrizVerificarJogador[1][1]) && matrizVerificarJogador[1][1].equals(matrizVerificarJogador[2][2])) {
                //Ganhador diagonal
                ganhador = true;
            }
            if (matrizVerificarJogador[0][2].equals(matrizVerificarJogador[1][1]) && matrizVerificarJogador[0][2].equals(matrizVerificarJogador[2][0])) {
                //Ganhador diagonal invertida
                ganhador = true;
            }
        }
        return ganhador;
    }


    private void inicializaMatrizVerificacao()
    {
        for(int linha = 0; linha < 3; linha++)
        {
            for(int coluna = 0; coluna < 3; coluna++)
            {
                matrizVerificarJogador[linha][coluna] =
                        String.valueOf(linha)+String.valueOf(coluna);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        final Button[][] btnProg =  new Button[3][3];
        btnProg[0][0] = (Button) findViewById(R.id.btn11);
        btnProg[0][1] = (Button) findViewById(R.id.btn12);
        btnProg[0][2] = (Button) findViewById(R.id.btn13);
        btnProg[1][0] = (Button) findViewById(R.id.btn21);
        btnProg[1][1] = (Button) findViewById(R.id.btn22);
        btnProg[1][2] = (Button) findViewById(R.id.btn23);
        btnProg[2][0] = (Button) findViewById(R.id.btn31);
        btnProg[2][1] = (Button) findViewById(R.id.btn32);
        btnProg[2][2] = (Button) findViewById(R.id.btn33);
        final TextView txtJogadorProg = (TextView) findViewById(R.id.txtJogador);
        final Button btnResetProg = (Button) findViewById(R.id.btnReset);

        inicializaMatrizVerificacao();

        btnProg[0][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnProg[0][0].setText(jogador);
                btnProg[0][0].setClickable(false);
                matrizVerificarJogador[0][0]=jogador;
                //trocaJogador();
                //txtJogadorProg.setText("Jogador: " + jogador);
                if(verificaJogador()){
                    txtJogadorProg.setText("Meus parabens " + jogador);
                    for(int i =0;i<3;i++){
                        for(int j=0;j<3;j++){
                            btnProg[i][j].setClickable(false);
                        }
                    }
                }else{
                    trocaJogador();
                    txtJogadorProg.setText("Jogador: " + jogador);
                }
            }
        });
        btnProg[0][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnProg[0][1].setText(jogador);
                btnProg[0][1].setClickable(false);
                matrizVerificarJogador[0][1]=jogador;
                if(verificaJogador()){
                    txtJogadorProg.setText("Meus parabens " + jogador);
                    for(int i =0;i<3;i++){
                        for(int j=0;j<3;j++){
                            btnProg[i][j].setClickable(false);
                        }
                    }
                }else{
                    trocaJogador();
                    txtJogadorProg.setText("Jogador: " + jogador);
                    if(jogadas == 9){
                        txtJogadorProg.setText("Empate !!!");
                    }
                }
            }
        });
        btnProg[0][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnProg[0][2].setText(jogador);
                btnProg[0][2].setClickable(false);
                matrizVerificarJogador[0][2]=jogador;
                if(verificaJogador()){
                    txtJogadorProg.setText("Meus parabens " + jogador);
                    for(int i =0;i<3;i++){
                        for(int j=0;j<3;j++){
                            btnProg[i][j].setClickable(false);
                        }
                    }
                }else{
                    trocaJogador();
                    txtJogadorProg.setText("Jogador: " + jogador);
                    if(jogadas == 9){
                        txtJogadorProg.setText("Empate !!!");
                    }
                }
            }
        });
        btnProg[1][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnProg[1][0].setText(jogador);
                btnProg[1][0].setClickable(false);
                matrizVerificarJogador[1][0]=jogador;
                if(verificaJogador()){
                    txtJogadorProg.setText("Meus parabens " + jogador);
                    for(int i =0;i<3;i++){
                        for(int j=0;j<3;j++){
                            btnProg[i][j].setClickable(false);
                        }
                    }
                }else{
                    trocaJogador();
                    txtJogadorProg.setText("Jogador: " + jogador);
                    if(jogadas == 9){
                        txtJogadorProg.setText("Empate !!!");
                    }
                }
            }
        });
        btnProg[1][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnProg[1][1].setText(jogador);
                btnProg[1][1].setClickable(false);
                matrizVerificarJogador[1][1]=jogador;
                if(verificaJogador()){
                    txtJogadorProg.setText("Meus parabens " + jogador);
                    for(int i =0;i<3;i++){
                        for(int j=0;j<3;j++){
                            btnProg[i][j].setClickable(false);
                        }
                    }
                }else{
                    trocaJogador();
                    txtJogadorProg.setText("Jogador: " + jogador);
                    if(jogadas == 9){
                        txtJogadorProg.setText("Empate !!!");
                    }
                }
            }
        });
        btnProg[1][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnProg[1][2].setText(jogador);
                btnProg[1][2].setClickable(false);
                matrizVerificarJogador[1][2]=jogador;
                if(verificaJogador()){
                    txtJogadorProg.setText("Meus parabens " + jogador);
                    for(int i =0;i<3;i++){
                        for(int j=0;j<3;j++){
                            btnProg[i][j].setClickable(false);
                        }
                    }
                }else{
                    trocaJogador();
                    txtJogadorProg.setText("Jogador: " + jogador);
                    if(jogadas == 9){
                        txtJogadorProg.setText("Empate !!!");
                    }
                }
            }
        });
        btnProg[2][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnProg[2][0].setText(jogador);
                btnProg[2][0].setClickable(false);
                matrizVerificarJogador[2][0]=jogador;
                if(verificaJogador()){
                    txtJogadorProg.setText("Meus parabens " + jogador);
                    for(int i =0;i<3;i++){
                        for(int j=0;j<3;j++){
                            btnProg[i][j].setClickable(false);
                        }
                    }
                }else{
                    trocaJogador();
                    txtJogadorProg.setText("Jogador: " + jogador);
                    if(jogadas == 9){
                        txtJogadorProg.setText("Empate !!!");
                    }
                }
            }
        });
        btnProg[2][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnProg[2][1].setText(jogador);
                btnProg[2][1].setClickable(false);
                matrizVerificarJogador[2][1]=jogador;
                if(verificaJogador()){
                    txtJogadorProg.setText("Meus parabens " + jogador);
                    for(int i =0;i<3;i++){
                        for(int j=0;j<3;j++){
                            btnProg[i][j].setClickable(false);
                        }
                    }
                }else{
                    trocaJogador();
                    txtJogadorProg.setText("Jogador: " + jogador);
                    if(jogadas == 9){
                        txtJogadorProg.setText("Empate !!!");
                    }
                }
            }
        });
        btnProg[2][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnProg[2][2].setText(jogador);
                btnProg[2][2].setClickable(false);
                matrizVerificarJogador[2][2]=jogador;
                if(verificaJogador()){
                    txtJogadorProg.setText("Meus parabens " + jogador);
                    for(int i =0;i<3;i++){
                        for(int j=0;j<3;j++){
                            btnProg[i][j].setClickable(false);
                        }
                    }
                }else{
                    trocaJogador();
                    txtJogadorProg.setText("Jogador: " + jogador);
                    if(jogadas == 9){
                        txtJogadorProg.setText("Empate !!!");
                    }
                }
            }
        });

        btnResetProg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i < 3;i++){
                    for(int j = 0;j < 3;j++){
                        btnProg[i][j].setClickable(true);
                        btnProg[i][j].setText("");
                    }
                }
                inicializaMatrizVerificacao();
                txtJogadorProg.setText("Jogador: " + jogador);
                jogadas=0;
            }
        });

    }
}