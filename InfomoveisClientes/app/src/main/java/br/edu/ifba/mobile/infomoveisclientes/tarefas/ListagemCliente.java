package br.edu.ifba.mobile.infomoveisclientes.tarefas;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import br.edu.ifba.mobile.infomoveisclientes.bd.Cliente;
import br.edu.ifba.mobile.infomoveisclientes.bd.FacadeBD;

public class ListagemCliente extends AsyncTask<Void, Void, List<Cliente>> {

    private Context contexto = null;
    private ListView listaClientes = null;

    public ListagemCliente(Context contexto, ListView listaClientes) {
        this.contexto = contexto;
        this.listaClientes = listaClientes;


    }

    @Override
    protected List<Cliente> doInBackground(Void... params) {
        List<Cliente> clientes = FacadeBD.getInstancia().listarClientes();

        return clientes;
    }

    @Override
    protected void onPostExecute(List<Cliente> clientes) {
        if (clientes.isEmpty()) {
            Toast.makeText(contexto, "Lista vazia. Cadastre um cliente!", Toast.LENGTH_LONG).show();

        } else {
            ArrayAdapter<Cliente> adaptador = new ArrayAdapter<Cliente>(contexto, android.R.layout.simple_list_item_single_choice, clientes);
            listaClientes.setAdapter(adaptador);
        }


    }
}