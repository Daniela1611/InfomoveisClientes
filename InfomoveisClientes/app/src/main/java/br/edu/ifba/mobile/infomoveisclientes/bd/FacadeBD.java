package br.edu.ifba.mobile.infomoveisclientes.bd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import java.util.ArrayList;
import java.util.List;


public class FacadeBD extends SQLiteOpenHelper {

    private static FacadeBD instancia = null;

    public static FacadeBD criarInstancia(Context context) {
        if (instancia == null) {
            instancia = new FacadeBD(context);
        }
        return instancia;


    }

    public static FacadeBD getInstancia() {
        return instancia;

    }

    private static String NOME_BANCO = "Infomoveis";
    private static int VERSAO_BANCO = 1;

    public FacadeBD(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    private static String COMANDO_CRIACAO_TABELA_CLIENTES = "CREATE TABLE CLIENTES(" + "COD INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "NOME TEXT, RESP TEXT, EMAIL TEXT, NUM TEXT, RESPIMOVEL TEXT, RESPBAIRROCID TEXT)";


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(COMANDO_CRIACAO_TABELA_CLIENTES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versaoAntiga, int versaNova) {
        // TODO Auto-generated method stub

    }

    public long inserir(Cliente cliente) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valores = new ContentValues();

        valores.put("NOME", cliente.getNome());
        valores.put("RESP", cliente.getResp());
        valores.put("EMAIL", cliente.getEmail());
        valores.put("NUM", cliente.getNum());
        valores.put("RESPIMOVEL", cliente.getRespimovel());
        valores.put("RESPBAIRROCID", cliente.getRespbairrocid());




        long cod = db.insert("CLIENTES", null, valores);

        return cod;


    }

    public long atualizar (Cliente cliente){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valores = new ContentValues();

        valores.put("NOME", cliente.getNome());
        valores.put("RESP", cliente.getResp());
        valores.put("EMAIL", cliente.getEmail());
        valores.put("NUM", cliente.getNum());
        valores.put("RESPIMOVEL", cliente.getRespimovel());
        valores.put("RESPBAIRROCID", cliente.getRespbairrocid());




        long cod = db.update("CLIENTES", valores, "COD = " + cliente.getCod(),null);

        return cod;
    }

    public int remover (Cliente cliente) {
        SQLiteDatabase db = this.getWritableDatabase();

        return db.delete("CLIENTES", "COD = " + cliente.getCod(), null);
    }


        // reader
        public List<Cliente> listarClientes(){
            List<Cliente> clientes = new ArrayList<Cliente>();
            SQLiteDatabase db = this.getReadableDatabase();

            String selecao = "SELECT COD, NOME, RESP, EMAIL, NUM, RESPIMOVEL, RESPBAIRROCID FROM CLIENTES";

            Cursor cursor = db.rawQuery(selecao, null);
            if (cursor != null){
                boolean temProximo = cursor.moveToFirst();
                while (temProximo){
                    Cliente cliente = new Cliente();

                    cliente.setCod(cursor.getLong(cursor.getColumnIndex("COD")));
                    cliente.setNome(cursor.getString(cursor.getColumnIndex("NOME")));
                    cliente.setResp(cursor.getString(cursor.getColumnIndex("RESP")));
                    cliente.setEmail(cursor.getString(cursor.getColumnIndex("EMAIL")));
                    cliente.setNum(cursor.getString(cursor.getColumnIndex("NUM")));
                    cliente.setRespimovel(cursor.getString(cursor.getColumnIndex("RESPIMOVEL")));
                    cliente.setRespbairrocid(cursor.getString(cursor.getColumnIndex("RESPBAIRROCID")));


                    clientes.add(cliente);


                    temProximo = cursor.moveToNext();
                }
            }

            return clientes;



        }
    }











