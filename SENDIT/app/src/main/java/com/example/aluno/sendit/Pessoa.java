package com.example.aluno.sendit;

/**
 * Created by Aluno on 26/06/2018.
 */

public class Pessoa {
    private String nome;
    private String sobrenome;
    private  String dataNascimento;
    private  String sexo;
    private  String cpf;
    private Usuario usuario;
    private double idPessoa;
    private double idUsuario;



    public String getNome() {
        return nome;
    }

    public void setNome(String novoNome) {
        this.nome = novoNome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String novoSobrenome) {
        this.sobrenome = novoSobrenome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String novaDataNascimento) {
        this.dataNascimento = novaDataNascimento;
    }
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String novoSexo) {
        this.sexo = novoSexo;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String novoCpf) {
        this.cpf = novoCpf;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario novoUsuario) {
        this.usuario = novoUsuario;
    }
    public double getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(double novoIdPessoa) {
        this.idPessoa = novoIdPessoa;
    }

    public double getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(double novoIdUsuario) {
        this.idUsuario = novoIdUsuario;
    }

}