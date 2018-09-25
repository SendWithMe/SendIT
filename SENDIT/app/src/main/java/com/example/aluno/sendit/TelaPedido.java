package com.example.aluno.sendit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TelaPedido extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_pedido);
    }

    public Pacote criarPacote(String descricao,String origem,String destino,String id_usuario, String titulo){

        Pacote pacote = new Pacote();

        pacote.setDescricao(descricao);
        pacote.setOrigem(origem);
        pacote.setDestino(destino);
        pacote.setIdDoUsuario(id_usuario);
        pacote.setTitulo(titulo);
        return pacote;
    }



    public void confirmarPedido(View view){
        CadastroDAO cadastro = new CadastroDAO(getApplicationContext());

        Intent novaIntent = getIntent();
        String msg = novaIntent.getStringExtra("origem");
        String msg2 = novaIntent.getStringExtra("destino");




        EditText edt_descricao=(EditText)findViewById(R.id.edtDescricao);
        EditText edt_titulo = (EditText)findViewById(R.id.edtTitulo);

        String descricao=edt_descricao.getText().toString();
        String titulo = edt_titulo.getText().toString();
        Session session = new Session(getApplicationContext());
        String email = session.getEmail();
        String senha = session.getSenha();

        Usuario usuario=cadastro.UsuarioAutenticar(email,senha);

        cadastro.salvar(descricao,msg,msg2,usuario.getId(),titulo);

        Toast.makeText(getApplicationContext(),"Adicionado com Sucesso",Toast.LENGTH_LONG).show();



        Intent intent = new Intent(getApplicationContext(),TelaUsuario.class);
        startActivity(intent);


    }
    public void back(View view){
        Intent intent = new Intent(getApplicationContext(),TelaUsuario.class);
        startActivity(intent);
    }
    public void mapa(View view){
        Intent intent=new Intent(getApplicationContext(),TelaMapa.class);
        startActivity(intent);

  }
 }
