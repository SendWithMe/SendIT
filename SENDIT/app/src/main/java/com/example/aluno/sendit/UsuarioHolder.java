package com.example.aluno.sendit;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class UsuarioHolder extends RecyclerView.ViewHolder{
    public TextView nomePacote;
    public ImageButton btnEditar;
    public ImageButton btnExcluir;

    public UsuarioHolder(View itemView) {
        super(itemView);
        nomePacote = (TextView) itemView.findViewById(R.id.nomePacote);
        btnEditar = (ImageButton) itemView.findViewById(R.id.btnEdit);
        btnExcluir = (ImageButton) itemView.findViewById(R.id.btnDelete);
    }
}
