package br.edu.ifba.mobile.infomoveisclientes.tarefas;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import br.edu.ifba.mobile.infomoveisclientes.bd.FacadeBD2;
import br.edu.ifba.mobile.infomoveisclientes.bd.Imovel;


public class RemocaoImovel extends AsyncTask<Void, Void, String>{

    private Context contexto = null;
    private Imovel imovel = null;
    public RemocaoImovel(Context contexto, Imovel imovel){
        this.contexto = contexto;
        this.imovel = imovel;



    }
    @Override
    protected String doInBackground(Void... params) {
        String mensagem = "";


        if (imovel.getCodigo() != -1) {
            if (FacadeBD2.getInstancia().remover(imovel) == 0)
            {
                mensagem = "Problema de remoção!";
            }else{
                mensagem = "Imóvel removido!";
            }
        }else{
            mensagem = "Selecione um imóvel!";

        }

        return mensagem;
    }
    @Override
    protected void onPostExecute(String mensagem){
        Toast.makeText(contexto, mensagem, Toast.LENGTH_LONG).show();

    }
}
