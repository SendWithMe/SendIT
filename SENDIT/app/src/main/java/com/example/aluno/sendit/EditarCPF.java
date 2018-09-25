package com.example.aluno.sendit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditarCPF extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_cpf);
        final Session session  = new Session(getApplicationContext());


        final EditText cpf = (EditText) findViewById(R.id.edt_edit_cpf);

        cpf.setText(session.getCpf());

        Button editar = (Button) findViewById(R.id.btn_edit_cpf);

        editar.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {

                CadastroDAO cadastroDAO = new CadastroDAO(getApplicationContext());
                Usuario usuario  = cadastroDAO.UsuarioAutenticar(session.getEmail().toString(),session.getSenha().toString());

                int validade = 0;


                if (cpf.getText().toString().length() != 11 || cpf.getText().toString().contains("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")){
                    Toast.makeText(getApplicationContext(), "CPF inválido", Toast.LENGTH_LONG).show();
                    validade = +1;
                }else if(cadastroDAO.buscaCpf(cpf.getText().toString())==true) {
                    Toast.makeText(getApplicationContext(), "CPF já cadastrado", Toast.LENGTH_LONG).show();
                    validade = +1;
                }


                if(validade == 0){

                    String nome1 = usuario.getNome().toString();
                    String sobrenome1 = usuario.getSobrenome().toString();
                    String cpf1 = cpf.getText().toString();
                    String email1 = usuario.getEmail().toString();
                    String senha1 = usuario.getSenha().toString();
                    String iscolaborador = usuario.getIsColaborador().toString();

                    cadastroDAO.atualizarUsuario(Integer.parseInt(usuario.getId()),nome1,sobrenome1,cpf1,email1,senha1,iscolaborador);

                    Intent intent  = new Intent(getApplicationContext(),InfoPerfilCliente.class);

                    startActivity(intent);

                    Toast.makeText(getApplicationContext(), "CPF atualizado",Toast.LENGTH_LONG).show();

                }

            }
        });

    }

    public void cancelarEditCPF(View view){

        Intent intent  = new Intent(getApplicationContext(),EditarPerfil.class);
        startActivity(intent);

    }

}
