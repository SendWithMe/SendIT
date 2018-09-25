package com.example.aluno.sendit;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aluno on 26/06/2018.
 */

public class Usuario{
    private String id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String email;
    private String senha;
    private String isColaborador;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }



    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) { this.senha = senha; }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsColaborador() {
        return isColaborador;
    }

    public void setIsColaborador(String isColaborador) {
        this.isColaborador = isColaborador;
    }
}




