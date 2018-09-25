package com.example.aluno.sendit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InfoPerfilCliente extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_cliente);

        TextView email = (TextView)findViewById(R.id.textView_emailCliente);
        TextView nome = (TextView) findViewById(R.id.textView_nomeCliente);
        TextView cpf = (TextView) findViewById(R.id.textView_cpfCliente);

        Session session  = new Session(getApplicationContext());

        String cemail = session.getEmail();
        String cnome = session.getNome();
        String csobrenome = session.getSobrenome();
        String ccpf = session.getCpf();

        email.setText("Email:" + cemail);
        nome.setText("Nome:" + cnome + " " + csobrenome);
        cpf.setText("CPF: " + ccpf);

    }

    public void perfilClienteVoltar(View view){

        Intent intent = new Intent(getApplicationContext(),TelaUsuario.class);
        startActivity(intent);

    }

    public void editarPerfilCliente(View view){

        Intent intent = new Intent(getApplicationContext(), EditarPerfil.class);
        startActivity(intent);

    }




}

