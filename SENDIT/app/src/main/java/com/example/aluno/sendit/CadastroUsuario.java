package com.example.aluno.sendit;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aluno.sendit.BancoDeDadosAuxiliar;
import com.example.aluno.sendit.CadastroDAO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CadastroUsuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);



    }
    public Usuario criarUsuario(String nome,String sobrenome,String cpf, String email, String senha, String iscolaborador){

        Usuario usuarioRetorno = new Usuario();
        usuarioRetorno.setEmail(email);
        usuarioRetorno.setSenha(senha);
        usuarioRetorno.setCpf(cpf);
        usuarioRetorno.setNome(nome);
        usuarioRetorno.setSobrenome(sobrenome);
        usuarioRetorno.setIsColaborador(iscolaborador);
        return usuarioRetorno;
    }

    public boolean validaCadastro(){

        EditText nome = (EditText) findViewById(R.id.EditNome);
        EditText sobrenome = (EditText) findViewById(R.id.EditSobreNome);
        EditText cpf = (EditText) findViewById(R.id.EditCPF);
        EditText email = (EditText) findViewById(R.id.EditEmail);
        EditText senha = (EditText) findViewById(R.id.EditSenha);
        CadastroDAO cadastroDAO = new CadastroDAO(getApplicationContext());

        CadastroDAO busca;
        boolean validade = true;

        if (nome.getText().toString().equals("") ||nome.getText().toString() == null) {
            Toast.makeText(getApplicationContext(), "Nome inválido", Toast.LENGTH_LONG).show();
            validade = false;
        }else if (sobrenome.getText().toString().equals("") || sobrenome.getText().toString() == null){
            Toast.makeText(getApplicationContext(), "Sobrenome inválido", Toast.LENGTH_LONG).show();
            validade = false;
        }else if (cpf.getText().toString().length() != 11 || cpf.getText().toString().contains("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")){
            Toast.makeText(getApplicationContext(), "CPF inválido", Toast.LENGTH_LONG).show();
            validade = false;
        }else if(cadastroDAO.buscaCpf(cpf.getText().toString())==true){
            Toast.makeText(getApplicationContext(), "CPF já cadastrado", Toast.LENGTH_LONG).show();
            validade = false;
        }else if (!Patterns.EMAIL_ADDRESS.matcher((CharSequence) email.getText().toString()).matches()){
            Toast.makeText(getApplicationContext(), "Email inválido", Toast.LENGTH_LONG).show();
            validade = false;
        }else if (cadastroDAO.buscaEmail(email.getText().toString()).contains(email.getText().toString())){
            Toast.makeText(getApplicationContext(), "Email já cadastrado", Toast.LENGTH_LONG).show();
            validade = false;
        }else if(senha.getText().length()<8){
            Toast.makeText(getApplicationContext(), "Senha muito curta(Tamanho mínimo: 8 caracteres)",Toast.LENGTH_LONG).show();
            validade=false;
        }


        return validade;

    }

    public void confirmar(View view){

        CadastroDAO cadastro = new CadastroDAO(getApplicationContext());

        EditText nome = (EditText) findViewById(R.id.EditNome);
        EditText sobrenome = (EditText) findViewById(R.id.EditSobreNome);
        EditText cpf = (EditText) findViewById(R.id.EditCPF);
        EditText email = (EditText) findViewById(R.id.EditEmail);
        EditText senha = (EditText) findViewById(R.id.EditSenha);

        String nomev=nome.getText().toString();
        String sobrenomev=sobrenome.getText().toString();
        String cpfv=cpf.getText().toString();
        String emailv=email.getText().toString();
        String senhav=senha.getText().toString();

        Usuario usuarioCadastrando = criarUsuario(nomev,sobrenomev,cpfv,emailv,senhav,"false");
        String resultado;

            if (validaCadastro() == true) {

                cadastro.inserirUsuario(usuarioCadastrando);

                Intent intent = new Intent(this.getApplicationContext(), MainActivity.class);
                Toast.makeText(getApplicationContext(), "cadastrado com sucesso", Toast.LENGTH_LONG).show();
                startActivity(intent);
            }

    }

    public void cancelar(View view){

        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}
