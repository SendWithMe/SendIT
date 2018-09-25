package com.example.aluno.sendit;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.aluno.sendit.Pacote;
import com.example.aluno.sendit.Usuario;

public class BancoDeDadosAuxiliar extends SQLiteOpenHelper{
    private static final  String nomeBD = "BD_SendIT";
    private static final int versao = 2;

    ;



    //Usuario

    private static final String USUARIO = "USUARIO";
    private static final String ID_USUARIO = "ID_USUARIO";
    private static final String NOME = "NOME";
    private static final String SOBRENOME = "SOBRENOME";
    private static final String CPF = "CPF";
    private static final String EMAIL = "EMAIL";
    private static final String SENHA = "SENHA";
    private static final String ISCOLABORADOR = "ISCOLABORADOR";


    //pacote
    private static final String PACOTE = "PACOTE";
    private static final String ID_PACOTE = "ID_PACOTE";
    private static final String DESCRICAO = "DESCRICAO";
    private static final String ORIGEM = "ORIGEM";
    private static final String DESTINO = "DESTINO";
    private static final String ID_DOUSUARIO = "ID_DOUSUARIO";
    private static final String TITULO = "TITULO";

    public static String getPACOTE() {
        return PACOTE;
    }

    public static String getIdPacote() {
        return ID_PACOTE;
    }

    public static String getDESCRICAO() {
        return DESCRICAO;
    }

    public static String getORIGEM() { return ORIGEM; }

    public static String getDESTINO() { return DESTINO; }

    public static String getTITULO() { return TITULO; }

    public static String getIdDousuario() {
        return ID_DOUSUARIO;
    }

    public static String getTitulo(){ return TITULO; }





    public static String getNomeBD() {
        return nomeBD;
    }

    public static int getVersao() {
        return versao;
    }


    public static String getNOME() {
        return NOME;
    }

    public static String getSOBRENOME() {
        return SOBRENOME;
    }

    public static String getCPF() { return CPF;}

    public static String getUSUARIO() {
        return USUARIO;
    }

    public static String getIdUsuario() {
        return ID_USUARIO;
    }

    public static String getEMAIL() {
        return EMAIL;
    }

    public static String getSENHA() {
        return SENHA;
    }

    public static String getISCOLABORADOR(){return ISCOLABORADOR;}




    public BancoDeDadosAuxiliar(Context context) {
        super(context, nomeBD, null, versao);
    }


        @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

            String sqlUsuario = "CREATE TABLE " + USUARIO + "(" + ID_USUARIO + " INTEGER PRIMARY KEY AUTOINCREMENT," +  NOME + " TEXT NOT NULL," + SOBRENOME + " TEXT NOT NULL," + CPF + " TEXT NOT NULL," + EMAIL + " TEXT NOT NULL," + SENHA + " TEXT NOT NULL,"+ ISCOLABORADOR + ")";
        sqLiteDatabase.execSQL(sqlUsuario);


            String sqlPacote = "CREATE TABLE " + PACOTE + "(" + ID_PACOTE + " INTEGER PRIMARY KEY AUTOINCREMENT," +  DESCRICAO + " TEXT NOT NULL," + ORIGEM + " TEXT NOT NULL," + DESTINO + " TEXT NOT NULL," + ID_DOUSUARIO + " TEXT NOT NULL," + TITULO + " TEXT NOT NULL" + ")";
            sqLiteDatabase.execSQL(sqlPacote);



    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + PACOTE);
        onCreate(sqLiteDatabase);
    }
}

