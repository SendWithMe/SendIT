package com.example.aluno.sendit;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcelable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioHolder>{
    private final List<Pacote> pacotes;

    public UsuarioAdapter(List<Pacote> clientes) {
        this.pacotes = clientes;
    }

    @Override
    public UsuarioHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new UsuarioHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itenusuario, parent, false));
    }

    @Override
    public void onBindViewHolder(UsuarioHolder holder, int position) {
        holder.nomePacote.setText(pacotes.get(position).getTitulo());
        final Pacote pacote = pacotes.get(position);
        final String index = pacote.getId();
        holder.btnEditar.setOnClickListener(new Button.OnClickListener() {
            @Override


            public void onClick(final View v) {
                Toast.makeText(getActivity(v),index,Toast.LENGTH_LONG).show();

                final View view = v;
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Confirmação")
                        .setMessage("Tem certeza que deseja excluir este pacote?")
                        .setPositiveButton("Excluir", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                String aqui = pacote.getId().toString();
                                int ind=Integer.parseInt(aqui);
                                CadastroDAO dao = new CadastroDAO(view.getContext());

                                boolean sucesso = dao.excluir(ind);
                                if(sucesso) {
                                    removerPacote(pacote);
                                    Snackbar.make(view, "Excluiu!", Snackbar.LENGTH_LONG)
                                            .setAction("Action", null).show();
                                }else{
                                    Snackbar.make(view, "Erro ao excluir o cliente!", Snackbar.LENGTH_LONG)
                                            .setAction("Action", null).show();
                                }
                            }
                        })
                        .setNegativeButton("Cancelar", null)
                        .create()
                        .show();
            }
        });







       holder.btnEditar.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity activity = getActivity(v);
                Intent intent = activity.getIntent();
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                intent.putExtra("pacote", pacote);
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
                return (Activity)context;
            }
            context = ((ContextWrapper)context).getBaseContext();
        }
        return null;
    }

    public void atualizarCliente(Pacote pacote){
        pacotes.set(pacotes.indexOf(pacote), pacote);
        notifyItemChanged(pacotes.indexOf(pacote));
    }
    public void removerPacote(Pacote pacote){
        int position = pacotes.indexOf(pacote);
        pacotes.remove(position);
        notifyItemRemoved(position);
    }


}

