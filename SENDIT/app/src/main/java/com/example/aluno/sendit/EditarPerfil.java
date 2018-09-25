package com.example.aluno.sendit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditarPerfil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_perfil);

        final Session session  = new Session(getApplicationContext());

        final EditText nome = (EditText) findViewById(R.id.editNomeColaborador1);
        final EditText sobrenome = (EditText) findViewById(R.id.editSobrenomeColaborador1);
        final EditText senha = (EditText) findViewById(R.id.editSenhaColaborador1);

        nome.setText(session.getNome());
        sobrenome.setText(session.getSobrenome());
        senha.setText(session.getSenha());

        Button editar = (Button) findViewById(R.id.btnCadastrarColaborador1);

        editar.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {

                CadastroDAO cadastroDAO = new CadastroDAO(getApplicationContext());
                Usuario usuario  = cadastroDAO.UsuarioAutenticar(session.getEmail().toString(),session.getSenha().toString());

                int validade = 0;

                if (nome.getText().toString().equals("") ||nome.getText().toString() == null) {
                    Toast.makeText(getApplicationContext(), "Nome inválido", Toast.LENGTH_LONG).show();
                    validade = +1;
                }else if (sobrenome.getText().toString().equals("") || sobrenome.getText().toString() == null){
                    Toast.makeText(getApplicationContext(), "Sobrenome inválido", Toast.LENGTH_LONG).show();
                    validade = +1;
                }else if(senha.getText().length()<8){
                    Toast.makeText(getApplicationContext(), "Senha muito curta(Tamanho mínimo: 8 caracteres)",Toast.LENGTH_LONG).show();
                    validade = +1;
                }

                if(validade == 0){

                    String nome1 = nome.getText().toString();
                    String sobrenome1 = sobrenome.getText().toString();
                    String cpf1 = usuario.getCpf().toString();
                    String email1 = usuario.getEmail().toString();
                    String senha1 = senha.getText().toString();
                    String iscolaborador = usuario.getIsColaborador().toString();

                    cadastroDAO.atualizarUsuario(Integer.parseInt(usuario.getId()),nome1,sobrenome1,cpf1,email1,senha1,iscolaborador);

                    Intent intent  = new Intent(getApplicationContext(),InfoPerfilCliente.class);

                    startActivity(intent);

                    Toast.makeText(getApplicationContext(), "Perfil atualizado com sucesso!",Toast.LENGTH_LONG).show();




                }

            }
        });

    }

    public void cancelarEdicao(View view){

        Intent intent  = new Intent(getApplicationContext(),InfoPerfilCliente.class);
        startActivity(intent);

    }

    public void editarEmail(View view){

        Intent intent  = new Intent(getApplicationContext(),EditarEmail.class);
        startActivity(intent);

    }

    public void editarCPF(View view){

        Intent intent  = new Intent(getApplicationContext(),EditarCPF.class);
        startActivity(intent);

    }

}
