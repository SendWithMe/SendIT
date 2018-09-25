package com.example.aluno.sendit;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

public class ListaColaboradorAdapter extends RecyclerView.Adapter<PacoteHolder> {

    private final List<Pacote> pacotes;

    public ListaColaboradorAdapter(List<Pacote> pacotes) {

        this.pacotes = pacotes;

    }

    @Override
    public PacoteHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PacoteHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista, parent, false));
    }

    @Override
    public void onBindViewHolder(PacoteHolder holder, int position) {
        holder.idPedido.setText(pacotes.get(position).getTitulo());
        final Pacote pacote = pacotes.get(position);

        holder.btnInfo.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity activity = getActivity(v);
                Intent intent = activity.getIntent();
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                intent.putExtra("pacote",pacote);
                activity.finish();
                activity.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return pacotes != null ? pacotes.size() : 0;
    }


    private Activity getActivity(View view) {
        Context context = view.getContext();
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    public void atualizarCliente(Pacote pacote) {
        pacotes.set(pacotes.indexOf(pacote), pacote);
        notifyItemChanged(pacotes.indexOf(pacote));
    }

    public void removerPacote(Pacote pacote) {
        int position = pacotes.indexOf(pacote);
        pacotes.remove(position);
        notifyItemRemoved(position);
    }



}