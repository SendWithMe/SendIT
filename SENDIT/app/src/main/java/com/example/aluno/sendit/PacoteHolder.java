package com.example.aluno.sendit;

import android.support.design.internal.NavigationMenuPresenter;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class PacoteHolder extends RecyclerView.ViewHolder {

    public TextView idPedido;
    public Button btnInfo;

    public PacoteHolder(View itemView){

        super(itemView);

        idPedido = (TextView) itemView.findViewById(R.id.edt_descricao);
        btnInfo = (Button) itemView.findViewById(R.id.btn_deta);


    }

}
