package br.edu.ifba.mobile.infomoveisclientes.tarefas;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import br.edu.ifba.mobile.infomoveisclientes.bd.Cliente;
import br.edu.ifba.mobile.infomoveisclientes.bd.FacadeBD;


public class GravacaoCliente extends AsyncTask<Void, Void, String>{

    private Context contexto = null;
    private Cliente cliente = null;
    public GravacaoCliente(Context contexto, Cliente cliente){
        this.contexto = contexto;
        this.cliente = cliente;



    }
    @Override
    protected String doInBackground(Void... params) {
        String mensagem = "";

        long cod= -1;
        if (cliente.getCod() == -1) {
            cod = FacadeBD.getInstancia().inserir(cliente);
        }else{
            cod = FacadeBD.getInstancia().atualizar(cliente);

        }

        if (cod > 0) {
            mensagem = "Cliente gravado com sucesso!";
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
