package br.edu.ifba.mobile.infomoveisclientes.bd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class FacadeBD2 extends SQLiteOpenHelper {

    private static FacadeBD2 instancia = null;

    public static FacadeBD2 criarInstancia(Context context) {
        if (instancia == null) {
            instancia = new FacadeBD2(context);
        }
        return instancia;


    }

    public static FacadeBD2 getInstancia() {
        return instancia;

    }

    private static String NOME_BANCO = "Infomoveis Clientes";
    private static int VERSAO_BANCO = 1;

    public FacadeBD2(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    private static String COMANDO_CRIACAO_TABELA_IMOVEIS = "CREATE TABLE IMOVEIS(" + "CODIGO INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "RESPCOD TEXT, RESPQUARTO TEXT, RESPSALA TEXT, RESPBANHEIRO TEXT, RESPGARAGEM TEXT, RESPALUGUEL TEXT)";


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(COMANDO_CRIACAO_TABELA_IMOVEIS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versaoAntiga, int versaNova) {
        // TODO Auto-generated method stub

    }

    public long inserir(Imovel imovel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valores = new ContentValues();



        valores.put("RESPCOD", imovel.getRespcod());
        valores.put("RESPQUARTO", imovel.getRespquarto());
        valores.put("RESPSALA", imovel.getRespsala());
        valores.put("RESPBANHEIRO", imovel.getRespbanheiro());
        valores.put("RESPGARAGEM", imovel.getRespgaragem());
        valores.put("RESPALUGUEL", imovel.getRespaluguel());



        long codigo = db.insert("IMOVEIS", null, valores);

        return codigo;


    }

    public long atualizar (Imovel imovel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valores = new ContentValues();

        valores.put("RESPCOD", imovel.getRespcod());
        valores.put("RESPQUARTO", imovel.getRespquarto());
        valores.put("RESPSALA", imovel.getRespsala());
        valores.put("RESPBANHEIRO", imovel.getRespbanheiro());
        valores.put("RESPGARAGEM", imovel.getRespgaragem());
        valores.put("RESPALUGUEL", imovel.getRespaluguel());



        long codigo = db.update("IMOVEIS", valores, "CODIGO = " + imovel.getCodigo(),null);

        return codigo;
    }

    public int remover (Imovel imovel) {
        SQLiteDatabase db = this.getWritableDatabase();

        return db.delete("IMOVEIS", "CODIGO = " + imovel.getCodigo(), null);
    }


        // reader
        public List<Imovel> listarImoveis(){
            List<Imovel> imoveis = new ArrayList<Imovel>();
            SQLiteDatabase db = this.getReadableDatabase();

            String selecao = "SELECT CODIGO, RESPCOD, RESPQUARTO, RESPSALA, RESPBANHEIRO, RESPGARAGEM, RESPALUGUEL FROM IMOVEIS";

            Cursor cursor = db.rawQuery(selecao, null);
            if (cursor != null){
                boolean temProximo = cursor.moveToFirst();
                while (temProximo){
                    Imovel imovel = new Imovel();

                    imovel.setCodigo(cursor.getLong(cursor.getColumnIndex("CODIGO")));
                    imovel.setRespcod(cursor.getString(cursor.getColumnIndex("RESPCOD")));
                    imovel.setRespquarto(cursor.getString(cursor.getColumnIndex("RESPQUARTO")));
                    imovel.setRespsala(cursor.getString(cursor.getColumnIndex("RESPSALA")));
                    imovel.setRespbanheiro(cursor.getString(cursor.getColumnIndex("RESPBANHEIRO")));
                    imovel.setRespgaragem(cursor.getString(cursor.getColumnIndex("RESPGARAGEM")));
                    imovel.setRespaluguel(cursor.getString(cursor.getColumnIndex("RESPALUGUEL")));


                    imoveis.add(imovel);


                    temProximo = cursor.moveToNext();
                }
            }

            return imoveis;



        }
    }





