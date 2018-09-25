package com.example.aluno.sendit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aluno.sendit.CadastroDAO;

public class CadastroColaborador extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_colaborador);
    }

    public Colaborador criarColaborador(String nome,String sobrenome,String cpf, String email, String senha, String iscolaborador){

        Colaborador colaboradorRetorno = new Colaborador();
        colaboradorRetorno.setEmail(email);
        colaboradorRetorno.setSenha(senha);
        colaboradorRetorno.setCpf(cpf);
        colaboradorRetorno.setNome(nome);
        colaboradorRetorno.setSobrenome(sobrenome);
        colaboradorRetorno.setIsColaborador(iscolaborador);
        return colaboradorRetorno;
    }

    public boolean validaCadastro(){

        EditText nome = (EditText) findViewById(R.id.editNomeColaborador);
        EditText sobrenome = (EditText) findViewById(R.id.editSobrenomeColaborador);
        EditText cpf = (EditText) findViewById(R.id.editCPFColaborador);
        EditText email = (EditText) findViewById(R.id.editemailColaborador);
        EditText senha = (EditText) findViewById(R.id.editSenhaColaborador);
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
            validade = false;
        }


        return validade;

    }

    public void cadastrar(View view){

        CadastroDAO cadastro = new CadastroDAO(getApplicationContext());

        EditText nome = (EditText) findViewById(R.id.editNomeColaborador);
        EditText sobrenome = (EditText) findViewById(R.id.editSobrenomeColaborador);
        EditText cpf = (EditText) findViewById(R.id.editCPFColaborador);
        EditText email = (EditText) findViewById(R.id.editemailColaborador);
        EditText senha = (EditText) findViewById(R.id.editSenhaColaborador);

        String nomev=nome.getText().toString();
        String sobrenomev=sobrenome.getText().toString();
        String cpfv=cpf.getText().toString();
        String emailv=email.getText().toString();
        String senhav=senha.getText().toString();

        Colaborador colaboradorCadastrando = criarColaborador(nomev,sobrenomev,cpfv,emailv,senhav, "true");
        String resultado;

        if (validaCadastro() == true) {

            cadastro.inserirColaborador(colaboradorCadastrando);

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
