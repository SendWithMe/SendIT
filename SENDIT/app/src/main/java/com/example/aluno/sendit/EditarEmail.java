package com.example.aluno.sendit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditarEmail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_email);
        final Session session  = new Session(getApplicationContext());


        final EditText email = (EditText) findViewById(R.id.edt_edit_cpf);

        email.setText(session.getEmail());

        Button editar = (Button) findViewById(R.id.btn_edit_cpf);

        editar.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {

                CadastroDAO cadastroDAO = new CadastroDAO(getApplicationContext());
                Usuario usuario  = cadastroDAO.UsuarioAutenticar(session.getEmail().toString(),session.getSenha().toString());

                int validade = 0;


                if (!Patterns.EMAIL_ADDRESS.matcher((CharSequence) email.getText().toString()).matches()) {
                    Toast.makeText(getApplicationContext(), "Email inválido", Toast.LENGTH_LONG).show();
                    validade = +1;
                }else if (cadastroDAO.buscaEmail(email.getText().toString()).contains(email.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Email já cadastrado", Toast.LENGTH_LONG).show();
                    validade = +1;
                }


                if(validade == 0){

                    String nome1 = usuario.getNome().toString();
                    String sobrenome1 = usuario.getSobrenome().toString();
                    String cpf1 = usuario.getCpf().toString();
                    String email1 = email.getText().toString();
                    String senha1 = usuario.getSenha().toString();
                    String iscolaborador = usuario.getIsColaborador().toString();

                    cadastroDAO.atualizarUsuario(Integer.parseInt(usuario.getId()),nome1,sobrenome1,cpf1,email1,senha1,iscolaborador);

                    Intent intent  = new Intent(getApplicationContext(),InfoPerfilCliente.class);

                    startActivity(intent);

                    Toast.makeText(getApplicationContext(), "Email atualizado",Toast.LENGTH_LONG).show();

                }

            }
        });

    }

    public void cancelarEditEmail(View view){

        Intent intent  = new Intent(getApplicationContext(),EditarPerfil.class);
        startActivity(intent);

    }

}
