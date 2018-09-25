package com.example.aluno.sendit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class listaPedidosUsuario extends AppCompatActivity {

    Pacote pacoteeditado = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pedidos_usuario);
        configurarRecycler();

        Intent intent = getIntent();

        if(intent.hasExtra("pacote")) {

            findViewById(R.id.includeListUser).setVisibility(View.INVISIBLE);
            findViewById(R.id.includeEditPack).setVisibility(View.VISIBLE);
            pacoteeditado = (Pacote) intent.getSerializableExtra("pacote");

            TextView titulo = (TextView) findViewById(R.id.txt_titulo1);
            TextView descricao = (TextView) findViewById(R.id.txt_descricao1);

            titulo.setText(pacoteeditado.getTitulo());
            descricao.setText(pacoteeditado.getDescricao());


            Button editar = (Button) findViewById(R.id.btn_edit_pack);
            editar.setOnClickListener(new Button.OnClickListener() {

                @Override
                public void onClick(View v) {

                    Intent intent1 = new Intent(getApplicationContext(), EditarPedido.class);
                    intent1.putExtra("pedidovisto", pacoteeditado);
                    startActivity(intent1);

                }
            });

            Button voltar = (Button) findViewById(R.id.btn_voltar1);
            voltar.setOnClickListener(new Button.OnClickListener(){

                @Override
                public void onClick(View v) {

                    Intent intent1 = new Intent(getApplicationContext(),listaPedidosUsuario.class);
                    startActivity(intent1);

                }
            });


        }

    }
    RecyclerView recyclerView;
    UsuarioAdapter adapter;
    private void configurarRecycler() {
        // Configurando o gerenciador de layout para ser uma lista.
        recyclerView = (RecyclerView)findViewById(R.id.recycleUsuario);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Adiciona o adapter que irá anexar os objetos à lista.
        CadastroDAO dao = new CadastroDAO(this);
        adapter = new UsuarioAdapter(dao.listaDePedidosColaborador());
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }
}
