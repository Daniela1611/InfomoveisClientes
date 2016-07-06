package br.edu.ifba.mobile.infomoveisclientes.fragmentos;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import br.edu.ifba.mobile.infomoveisclientes.R;
import br.edu.ifba.mobile.infomoveisclientes.bd.Cliente;
import br.edu.ifba.mobile.infomoveisclientes.tarefas.ListagemCliente;
import br.edu.ifba.mobile.infomoveisclientes.tarefas.RemocaoCliente;


public class FragmentoListaClientes extends Fragment {

    private static FragmentoListaClientes instancia = null;

    public static FragmentoListaClientes getInstancia() {
        if (instancia == null) {

            instancia = new FragmentoListaClientes();

        }
        return instancia;
    }
    private View tela = null;
    private ListView lista = null;

    @Override
    public View onCreateView(LayoutInflater inflador, ViewGroup vgrupo, Bundle bundle){

        tela=inflador.inflate(R.layout.fragmento_lista_clientes, vgrupo, false);

        preparar();

        return tela;

    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflador)
    {
        super.onCreateOptionsMenu(menu, inflador);

        inflador.inflate(R.menu.menu_infomoveis, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        long id = item.getItemId();
        if (id != AdapterView.INVALID_ROW_ID){
            if (id == R.id.cadastro_remover){
                RemocaoCliente remocao = new RemocaoCliente (this.getContext(), this.getClienteSelecionado());
                remocao.execute();
                atualizar();

            }
        }

        return super.onOptionsItemSelected(item);
    }

    private void preparar(){
        lista = (ListView) tela.findViewById(R.id.listaClientes);

        this.setHasOptionsMenu(true);
        lista.setClickable(true);
        lista.setChoiceMode(ListView.CHOICE_MODE_SINGLE);


    }

    public void atualizar(){
        ListagemCliente listagem = new ListagemCliente(this.getContext(), lista);
        listagem.execute();
    }

    public Cliente getClienteSelecionado(){
        Cliente cliente = new Cliente ();

        int posicao = lista.getCheckedItemPosition();
        if (posicao != ListView.INVALID_POSITION){
            cliente = (Cliente) lista.getItemAtPosition(posicao);

        }

        return cliente;


    }



}


