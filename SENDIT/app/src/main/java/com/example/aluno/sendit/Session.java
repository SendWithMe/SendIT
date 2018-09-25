package com.example.aluno.sendit;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Session {

    private SharedPreferences prefs;

    public Session(Context cntx) {
        // TODO Auto-generated constructor stub
        prefs = PreferenceManager.getDefaultSharedPreferences(cntx);
    }

    public void setEmail(String email) {
        prefs.edit().putString("email", email).commit();
    }

    public String getEmail() {
        String email = prefs.getString("email","");
        return email;
    }

    public void setSenha(String senha) {
        prefs.edit().putString("senha", senha).commit();
    }

    public String getSenha() {
        String senha = prefs.getString("senha","");
        return senha;
    }

    public void setNome(String nome) {prefs.edit().putString("nome", nome).commit();}

    public String getNome() {

        String nome = prefs.getString("nome","");
        return nome;

    }

    public void setSobrenome(String sobrenome) {prefs.edit().putString("sobrenome", sobrenome).commit();}

    public String getSobrenome() {

        String sobrenome = prefs.getString("sobrenome","");
        return sobrenome;

    }

    public void setCpf(String cpf) {prefs.edit().putString("cpf", cpf).commit();}

    public String getCpf() {

        String cpf = prefs.getString("cpf","");
        return cpf;

    }



    public String getId() {

        String id = prefs.getString("id","");
        return id;

    }

    public void setIsColaborador(String isColaborador) {prefs.edit().putString("iscolaborador", isColaborador).commit();}

    public String getIsColaborador() {

        String isColaborador = prefs.getString("iscolaborador","");
        return isColaborador;

    }

}
