package br.edu.ifba.mobile.infomoveisclientes.tarefas;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import br.edu.ifba.mobile.infomoveisclientes.bd.FacadeBD2;
import br.edu.ifba.mobile.infomoveisclientes.bd.Imovel;

/**
 * Created by Danniela on 27/05/2016.
 */
public class GravacaoImovel extends AsyncTask<Void, Void, String>{

    private Context contexto = null;
    private Imovel imovel = null;
    public GravacaoImovel(Context contexto, Imovel imovel){
        this.contexto = contexto;
        this.imovel = imovel;



    }
    @Override
    protected String doInBackground(Void... params) {
        String mensagem = "";

        long codigo= -1;
        if (imovel.getCodigo() == -1) {
            codigo = FacadeBD2.getInstancia().inserir(imovel);
        }else{
            codigo = FacadeBD2.getInstancia().atualizar(imovel);

        }

        if (codigo > 0) {
            mensagem = "Imóvel gravado com sucesso!";
            //registro inserido
        }
        else
        {
            // falha de insercao
            mensagem  = "Erro de gravação!";
        }


        return mensagem;
    }
    @Override
    protected void onPostExecute(String mensagem){
        Toast.makeText(contexto, mensagem, Toast.LENGTH_LONG).show();

    }
}
