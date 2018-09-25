package com.example.aluno.sendit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.aluno.sendit.CadastroDAO;

import java.util.ArrayList;

public class ListaPedidosColaborador extends AppCompatActivity {

    Pacote pacoteinfo = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pedidos_colaborador);
        configurarRecycler();

        Intent intent = getIntent();

        if(intent.hasExtra("pacote")){

            findViewById(R.id.includelista).setVisibility(View.INVISIBLE);
            findViewById(R.id.includeinfo).setVisibility(View.VISIBLE);
            pacoteinfo = (Pacote) intent.getSerializableExtra("pacote");

            TextView titulo = (TextView) findViewById(R.id.txt_viewtitulo);
            TextView descricao = (TextView) findViewById(R.id.txt_viewdesc);

            titulo.setText(pacoteinfo.getTitulo());
            descricao.setText(pacoteinfo.getDescricao());

            Button infolocal = (Button) findViewById(R.id.btn_info_local);
            infolocal.setOnClickListener(new Button.OnClickListener(){

                @Override
                public void onClick(View v) {

                    Intent intent1 = new Intent(getApplicationContext(),mapaCola.class);
                    intent1.putExtra("pedidovisto",pacoteinfo);
                    intent1.putExtra("origem",pacoteinfo.getOrigem());
                    intent1.putExtra("destino",pacoteinfo.getDestino());

                    startActivity(intent1);

                }
            });

        }

    }

    RecyclerView recyclerView;
    ListaColaboradorAdapter adapter;

    public void configurarRecycler(){

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_colaborador);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        CadastroDAO cadastroDAO = new CadastroDAO(this);
        adapter = new ListaColaboradorAdapter(cadastroDAO.listaDePedidosColaborador());
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

    }


    public void back (View view){
        Intent intent=new Intent(getApplicationContext(),TelaColaborador.class);
        startActivity(intent);
    }

}
