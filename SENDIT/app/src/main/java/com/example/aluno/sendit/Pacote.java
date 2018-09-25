package com.example.aluno.sendit;

import android.os.Parcel;

import java.io.Serializable;


/**
 * Created by Aluno on 26/06/2018.
 */

public class Pacote implements Serializable {

    private String id;
    private String descricao;
    private String origem;
    private String destino;
    private String idDoUsuario;
    private String titulo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getOrigem() { return origem; }

    public void setOrigem(String origem) { this.origem = origem; }

    public String getDestino() { return destino; }

    public void setDestino(String destino) { this.destino = destino; }

    public String getIdDoUsuario() {
        return idDoUsuario;
    }

    public void setIdDoUsuario(String idDoUsuario) {
        this.idDoUsuario = idDoUsuario;
    }

    public String getTitulo() { return titulo; }

    public void setTitulo(String titulo) { this.titulo = titulo; }
}
