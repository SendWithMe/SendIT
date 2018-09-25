package com.example.aluno.sendit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.aluno.sendit.BancoDeDadosAuxiliar;
import com.example.aluno.sendit.Colaborador;
import com.example.aluno.sendit.Pacote;
import com.example.aluno.sendit.Usuario;

import java.util.ArrayList;
import java.util.List;

public class CadastroDAO {

    private SQLiteDatabase database;
    private BancoDeDadosAuxiliar bdAuxiliar;

    public CadastroDAO(Context context) {
        bdAuxiliar = new BancoDeDadosAuxiliar(context);

    }
    public Usuario UsuarioAutenticar (String email, String senha){
        database = bdAuxiliar.getWritableDatabase();

        final String[] properties = {"id_usuario","nome", "sobrenome", "cpf", "email", "senha", "iscolaborador"};

        final Cursor cursor = database.query("USUARIO", properties, "email = ? and senha = ?", new String[]{email, senha}, null, null, null, null);


        if(cursor.moveToFirst()){
            final Usuario usuario = new Usuario ();
            usuario.setId(cursor.getString(0).toString());
            usuario.setNome(cursor.getString(1).toString());
            usuario.setSobrenome(cursor.getString(2).toString());
            usuario.setCpf(cursor.getString(3).toString());
            usuario.setEmail(cursor.getString(4).toString());
            usuario.setSenha(cursor.getString(5).toString());
            usuario.setIsColaborador(cursor.getString(6).toString());


            return usuario;
        }else{
            return null;
        }
    }

    public ArrayList<Pacote> listaDePedidosColaborador(){

        ArrayList<Pacote> listaPedidos = new ArrayList<Pacote>();
        database = bdAuxiliar.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM PACOTE", null);


        while(cursor.moveToNext()){

            Pacote pacote = new Pacote();
            pacote.setId(String.valueOf(cursor.getInt(cursor.getColumnIndex("ID_PACOTE"))));
            pacote.setDescricao(cursor.getString(cursor.getColumnIndex("DESCRICAO")));
            pacote.setOrigem(cursor.getString(cursor.getColumnIndex("ORIGEM")));
            pacote.setDestino(cursor.getString(cursor.getColumnIndex("DESTINO")));
            pacote.setIdDoUsuario(cursor.getString(cursor.getColumnIndex("ID_DOUSUARIO")));
            pacote.setTitulo(cursor.getString(cursor.getColumnIndex("TITULO")));

            listaPedidos.add(pacote);

        }


        cursor.close();

        return listaPedidos;

    }




    public void inserirUsuario(Usuario usuario) {

        ContentValues contentValuesUsuario = new ContentValues();

        contentValuesUsuario.put(BancoDeDadosAuxiliar.getNOME(), usuario.getNome());
        contentValuesUsuario.put(BancoDeDadosAuxiliar.getSOBRENOME(), usuario.getSobrenome());
        contentValuesUsuario.put(BancoDeDadosAuxiliar.getCPF(), usuario.getCpf());
        contentValuesUsuario.put(BancoDeDadosAuxiliar.getEMAIL(), usuario.getEmail());
        contentValuesUsuario.put(BancoDeDadosAuxiliar.getSENHA(), usuario.getSenha());
        contentValuesUsuario.put(BancoDeDadosAuxiliar.getISCOLABORADOR(),usuario.getIsColaborador());
        database = bdAuxiliar.getWritableDatabase();

        database.insert(BancoDeDadosAuxiliar.getUSUARIO(), null, contentValuesUsuario);

        database.close();

    }


    public void inserirColaborador(Colaborador colaborador) {

        ContentValues contentValuesColaborador = new ContentValues();

        contentValuesColaborador.put(BancoDeDadosAuxiliar.getNOME(), colaborador.getNome());
        contentValuesColaborador.put(BancoDeDadosAuxiliar.getSOBRENOME(), colaborador.getSobrenome());
        contentValuesColaborador.put(BancoDeDadosAuxiliar.getCPF(), colaborador.getCpf());
        contentValuesColaborador.put(BancoDeDadosAuxiliar.getEMAIL(), colaborador.getEmail());
        contentValuesColaborador.put(BancoDeDadosAuxiliar.getSENHA(), colaborador.getSenha());
        contentValuesColaborador.put(BancoDeDadosAuxiliar.getISCOLABORADOR(), colaborador.getIsColaborador());
        database = bdAuxiliar.getWritableDatabase();

        database.insert(BancoDeDadosAuxiliar.getUSUARIO(), null, contentValuesColaborador);

        database.close();

    }
    public boolean salvar(String descricao , String origem,String destino,String idUsuario,String titulo) {
        return salvar(0, descricao, origem,destino,idUsuario,titulo);

    }

    public boolean salvar(int id ,String descricao, String origem,String destino,String idUsuario, String titulo) {

        ContentValues contentValuesPacote = new ContentValues();

        contentValuesPacote.put(BancoDeDadosAuxiliar.getDESCRICAO(), descricao);
        contentValuesPacote.put(BancoDeDadosAuxiliar.getORIGEM(), origem);
        contentValuesPacote.put(BancoDeDadosAuxiliar.getDESTINO(), destino);
        contentValuesPacote.put(BancoDeDadosAuxiliar.getIdDousuario(), idUsuario);
        contentValuesPacote.put(BancoDeDadosAuxiliar.getTitulo(), titulo);
        database = bdAuxiliar.getWritableDatabase();

        if(id>0){

            return  database.update("PACOTE",contentValuesPacote,"ID_PACOTE=?",new String[]{ id + "" }) > 0;

        }
        else{
            return database.insert("PACOTE", null, contentValuesPacote) > 0;
        }


    }

    public boolean atualizarUsuario(int id ,String nome, String sobrenome,String cpf,String email, String senha, String iscolaborador) {

        ContentValues contentValuesUsuario = new ContentValues();

        contentValuesUsuario.put(BancoDeDadosAuxiliar.getNOME(), nome);
        contentValuesUsuario.put(BancoDeDadosAuxiliar.getSOBRENOME(), sobrenome);
        contentValuesUsuario.put(BancoDeDadosAuxiliar.getCPF(), cpf);
        contentValuesUsuario.put(BancoDeDadosAuxiliar.getEMAIL(), email);
        contentValuesUsuario.put(BancoDeDadosAuxiliar.getSENHA(), senha);
        contentValuesUsuario.put(BancoDeDadosAuxiliar.getISCOLABORADOR(), iscolaborador);
        database = bdAuxiliar.getWritableDatabase();

        return  database.update("USUARIO",contentValuesUsuario,"ID_USUARIO=?",new String[]{ id + "" }) > 0;

    }

    public List<Usuario> buscar() {
        List<Usuario> lista= new ArrayList<Usuario>();
        String[] colunas = new String[]{"EMAIL"};
        Cursor cursor = database.query("USUARIO", colunas, null, null, null, null, "nome ASC");

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                Usuario u = new Usuario();
                u.setEmail(cursor.getString(0));
                lista.add(u);
            }while(cursor.moveToNext());




        }
        return lista;
    }


    public List<String> buscaEmail(String email) {
        List <String> emailList = new ArrayList<String>();

        String sql = "SELECT EMAIL FROM USUARIO";
        Cursor cursor = database.rawQuery(sql,null);
        if(cursor.moveToFirst()){

            do{

                emailList.add(cursor.getString(cursor.getColumnIndex("EMAIL")));

            }while (cursor.moveToNext());

        }

        return emailList;





    }





    public boolean buscaCpf(String cpf){
        database = bdAuxiliar.getReadableDatabase();

        Cursor cursor = database.rawQuery("select * from  USUARIO   where cpf = ? ", new String[]{cpf});

        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        else{
            return true;
        }
    }

    public Boolean resultado(List<Usuario> lista,String email){
        boolean resut =false;
        for(Usuario usuario:lista){
            if(usuario.getEmail()==email){
                resut=true;

            }

        }

        return resut;
    }

    public Pacote retornaUltimo(){

        Cursor cursor = database.rawQuery("SELECT * FROM PACOTE ORDER BY ID_PACOTE DESC", null);

        if(cursor.moveToFirst()){

            String id = String.valueOf(cursor.getInt(cursor.getColumnIndex("ID_PACOTE")));
            String descriccao = cursor.getString(cursor.getColumnIndex("DESCRICAO"));
            String origem = cursor.getString(cursor.getColumnIndex("ORIGEM"));
            String destino = cursor.getString(cursor.getColumnIndex("DESTINO"));
            String id_dousuario = cursor.getString(cursor.getColumnIndex("ID_DOUSUARIO"));
            String titulo = cursor.getString(cursor.getColumnIndex("TITULO"));
            cursor.close();

            Pacote pacote = new Pacote();

            pacote.setId(id);
            pacote.setDescricao(descriccao);
            pacote.setOrigem(origem);
            pacote.setDestino(destino);
            pacote.setIdDoUsuario(id_dousuario);
            pacote.setTitulo(titulo);

            return pacote;

        }

        return null;

    }
    public boolean excluir(int id){

        boolean deletado=false;

        SQLiteDatabase db=bdAuxiliar.getWritableDatabase();

        deletado = db.delete("PACOTE","ID_PACOTE ='" + id + "'",null)> 0;

        return deletado;

    }

}








