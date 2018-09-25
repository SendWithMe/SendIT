package com.example.aluno.sendit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Session session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        session = new Session(getApplicationContext());




    }
    public void cadastrar(View view){
        Intent intent = new Intent(this.getApplicationContext(),CadastroUsuario.class);
        startActivity(intent);
    }

    public void cadastrarColaborador(View view){
        Intent intent = new Intent(this.getApplicationContext(),CadastroColaborador.class);
        startActivity(intent);
    }

    public void loginFinal(View view){
        CadastroDAO cadastroDAO = new CadastroDAO(getApplicationContext());
        EditText edtemail=(EditText)findViewById(R.id.email);
        EditText edtsenha=(EditText)findViewById(R.id.senha);

        String emailv= edtemail.getText().toString();
        String senhav=edtsenha.getText().toString();

        Usuario usuario = cadastroDAO.UsuarioAutenticar(emailv,senhav);


        if(usuario==null){



            Toast.makeText(getApplicationContext(),"Email ou Senha inválidos",Toast.LENGTH_LONG).show();

        }
        else {
            String tipo = usuario.getIsColaborador().toString();


            session.setEmail(emailv);
            session.setSenha(senhav);
            session.setNome(usuario.getNome());
            session.setSobrenome(usuario.getSobrenome());
            session.setCpf(usuario.getCpf());

            if(tipo.equals("false")){
                Intent intent = new Intent(getApplicationContext(), TelaUsuario.class);
                startActivity(intent);

            }else{

                Intent intent = new Intent(getApplicationContext(), TelaColaborador.class);
                startActivity(intent);

            }

        }

    }


}



