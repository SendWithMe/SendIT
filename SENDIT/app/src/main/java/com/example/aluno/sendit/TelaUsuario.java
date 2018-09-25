package com.example.aluno.sendit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TelaUsuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_usuario);
    }

    public void back(View view){
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }

    public void novoPedido(View view){
        Intent intent = new Intent(getApplicationContext(),TelaPedido.class);
        startActivity(intent);

    }

    public  void listaPedidos(View view){
        Intent intent = new Intent(getApplicationContext(),listaPedidosUsuario.class);
        startActivity(intent);

    }

    public void perfilCliente(View view){

        Intent intent  = new Intent(getApplicationContext(),InfoPerfilCliente.class);
        startActivity(intent);

    }


}
