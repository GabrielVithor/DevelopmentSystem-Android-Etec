package com.example.appcofre;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView txtServicoProg;
    EditText edtNomeProg;
    EditText edtUsuarioProg;
    EditText edtSenhaProg;
    int quantidadeRegistros;
    int registroAtual;
    int idCredencialAtual;

    credencialModel credencial = new credencialModel();

    dbModel db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtServicoProg = (TextView) findViewById(R.id.txtServico);
        edtNomeProg = (EditText) findViewById(R.id.edtServico);
        edtUsuarioProg = (EditText) findViewById(R.id.edtUsuario);
        edtSenhaProg = (EditText) findViewById(R.id.edtSenha);
        getSupportActionBar().hide();
        carregarRegistroZero();
    }

    public void clickBtnDeletar(View v) {
        credencial.setId(idCredencialAtual);
        credencial.setNome(edtNomeProg.getText().toString());
        credencial.setUsuario(edtUsuarioProg.getText().toString());
        credencial.setSenha(edtSenhaProg.getText().toString());
        db= new dbModel(getApplicationContext());
        db.delete(db.getTabela(),credencial);
        limpar();
        carregarRegistroZero();
    }

    public void clickBtnAlterar(View v) {
        credencial.setId(idCredencialAtual);
        credencial.setNome(edtNomeProg.getText().toString());
        credencial.setUsuario(edtUsuarioProg.getText().toString());
        credencial.setSenha(edtSenhaProg.getText().toString());
        db = new dbModel(getApplicationContext());
        db.update(db.getTabela(),credencial);
        carregarRegistroZero();
    }

    public void clickBtnCadastrar(View v) {
        credencial.setNome(edtNomeProg.getText().toString());
        credencial.setUsuario(edtUsuarioProg.getText().toString());
        credencial.setSenha(edtSenhaProg.getText().toString());
        db = new dbModel(getApplicationContext());
        db.insert(dbModel.getTabela(), credencial);
        carregarRegistroZero();
    }

    public void clickBtnNovo(View v) {
        limpar();
    }

    public void clicBtnAnterior(View v){
        if(quantidadeRegistros !=0){
            if(registroAtual>0){
                registroAtual--;
                carregarDados(registroAtual);
            }
        }
    }

    public void clickBtnProximo(View v){
        if(quantidadeRegistros != 0){
            if(registroAtual < quantidadeRegistros-1){
                registroAtual++;
                carregarDados(registroAtual);
            }
        }
    }
    public void limpar() {
        edtNomeProg.setText("");
        edtUsuarioProg.setText("");
        edtSenhaProg.setText("");
        txtServicoProg.setText("Serviço:");
        edtNomeProg.requestFocus();
    }

    public void carregarDados(int i) {
        db = new dbModel(getApplicationContext());
        ArrayList<credencialModel> arrayCredencialModel;
        arrayCredencialModel = db.select();
        quantidadeRegistros = arrayCredencialModel.size();
        if (quantidadeRegistros != 0) {
            credencialModel credencialModel = arrayCredencialModel.get(i);
            txtServicoProg.setText("Serviço" + String.valueOf(credencialModel.getId()) + ":");
            idCredencialAtual = credencialModel.getId();
            edtNomeProg.setText(credencialModel.getNome());
            edtUsuarioProg.setText(credencialModel.getUsuario());
            edtSenhaProg.setText(credencialModel.getSenha());
        }
    }

    public void carregarRegistroZero() {
       registroAtual =0;
        carregarDados(registroAtual);
    }
}