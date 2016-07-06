package br.edu.ifba.mobile.infomoveisclientes.tarefas;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;


import br.edu.ifba.mobile.infomoveisclientes.bd.FacadeBD;
import br.edu.ifba.mobile.infomoveisclientes.bd.FacadeBD2;
import br.edu.ifba.mobile.infomoveisclientes.bd.Imovel;


public class ListagemImovel extends AsyncTask<Void, Void, List<Imovel>> {

    private Context contexto = null;
    private ListView listaImoveis = null;

    public ListagemImovel(Context contexto, ListView listaImoveis) {
        this.contexto = contexto;
        this.listaImoveis = listaImoveis;


    }

    @Override
    protected List<Imovel> doInBackground(Void... params) {
        List<Imovel> imoveis = FacadeBD2.getInstancia().listarImoveis();

        return imoveis;
    }

    @Override
    protected void onPostExecute(List<Imovel> imoveis) {
        if (imoveis.isEmpty()) {
            Toast.makeText(contexto, "Lista vazia. Cadastre um imovel!", Toast.LENGTH_LONG).show();

        } else {
            ArrayAdapter<Imovel> adaptador = new ArrayAdapter<Imovel>(contexto, android.R.layout.simple_list_item_single_choice, imoveis);
            listaImoveis.setAdapter(adaptador);
        }


    }
}