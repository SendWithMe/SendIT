package com.example.aluno.sendit;

import java.util.ArrayList;

/**
 * Created by Aluno on 26/06/2018.
 */

public class Colaborador{
    private String nome;
    private String sobrenome;
    private String cpf;
    private String email;
    private String senha;
    private String isColaborador;
    private double id;

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIsColaborador() {
        return isColaborador;
    }

    public void setIsColaborador(String isColaborador) {
        this.isColaborador = isColaborador;
    }
}

