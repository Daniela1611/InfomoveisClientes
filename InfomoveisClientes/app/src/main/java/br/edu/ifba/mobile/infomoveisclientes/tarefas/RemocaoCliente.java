package br.edu.ifba.mobile.infomoveisclientes.tarefas;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import br.edu.ifba.mobile.infomoveisclientes.bd.Cliente;
import br.edu.ifba.mobile.infomoveisclientes.bd.FacadeBD;


public class RemocaoCliente extends AsyncTask<Void, Void, String>{

    private Context contexto = null;
    private Cliente cliente = null;
    public RemocaoCliente(Context contexto, Cliente cliente){
        this.contexto = contexto;
        this.cliente = cliente;



    }
    @Override
    protected String doInBackground(Void... params) {
        String mensagem = "";


        if (cliente.getCod() != -1) {
            if (FacadeBD.getInstancia().remover(cliente) == 0)
            {
                mensagem = "Problema de remoção!";
            }else{
                mensagem = "Cliente removido!";
            }
        }else{
            mensagem = "Selecione um cliente!";

        }

        return mensagem;
    }
    @Override
    protected void onPostExecute(String mensagem){
        Toast.makeText(contexto, mensagem, Toast.LENGTH_LONG).show();

    }
}
