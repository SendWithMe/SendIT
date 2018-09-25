package com.example.aluno.sendit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TelaColaborador extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_colaborador);
    }

    public void listaPedidosColaborador(View view){

        Intent intent  = new Intent(getApplicationContext(),ListaPedidosColaborador.class);
        startActivity(intent);

    }

    public void perfilColaborador(View view){

        Intent intent  = new Intent(getApplicationContext(),InfoPerfilCliente.class);
        startActivity(intent);

    }

    public void sairColaborador(View view){

        Intent intent  = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);

    }

}