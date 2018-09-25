package com.example.aluno.sendit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class EditarPedido extends AppCompatActivity {


   Pacote pacoteeditado = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_pedido);

        final Intent intent = getIntent();

        pacoteeditado = (Pacote) intent.getSerializableExtra("pedidovisto");

         EditText titulo = (EditText) findViewById(R.id.edtTitulo1);
         EditText descricao = (EditText) findViewById(R.id.edtDescricao1);

        titulo.setText(pacoteeditado.getTitulo());
        descricao.setText(pacoteeditado.getDescricao());

        ImageView origem = (ImageView) findViewById(R.id.imageViewOrigem);
        origem.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent(getApplicationContext(), TelaMapa.class);
                intent1.putExtra("pedidovisto", pacoteeditado);
                startActivity(intent1);

            }
        });

        ImageView destino = (ImageView) findViewById(R.id.imageViewDestino);
        destino.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent(getApplicationContext(), TelaMapa.class);
                intent1.putExtra("pedidovisto", pacoteeditado);
                startActivity(intent1);

            }
        });

        Button salvar = (Button) findViewById(R.id.btnConfirmar1);
        salvar.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {

                pacoteeditado = (Pacote) intent.getSerializableExtra("pedidovisto");
                EditText titulo = (EditText) findViewById(R.id.edtTitulo1);
                EditText descricao = (EditText) findViewById(R.id.edtDescricao1);

                    int id1 = Integer.parseInt(pacoteeditado.getId());
                    String descricao1 = descricao.getText().toString();
                    String origem1 = pacoteeditado.getOrigem().toString();
                    String destino1 = pacoteeditado.getDestino().toString();
                    String idusuario1 = pacoteeditado.getIdDoUsuario().toString();
                    String titulo1 = titulo.getText().toString();

                    CadastroDAO dao = new CadastroDAO(getApplicationContext());

                    dao.salvar(id1, descricao1, origem1, destino1, idusuario1, titulo1);

                    Intent intent1 = new Intent(getApplicationContext(), listaPedidosUsuario.class);
                    startActivity(intent1);

                    Toast.makeText(getApplicationContext(), "Editado com Sucesso", Toast.LENGTH_LONG).show();

            }
        });

        Button cancelar = (Button) findViewById(R.id.btnCancelar1);
        cancelar.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent(getApplicationContext(),listaPedidosUsuario.class);
                startActivity(intent1);

            }
        });


    }








}
