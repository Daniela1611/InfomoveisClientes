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
import br.edu.ifba.mobile.infomoveisclientes.bd.Imovel;
import br.edu.ifba.mobile.infomoveisclientes.tarefas.ListagemCliente;
import br.edu.ifba.mobile.infomoveisclientes.tarefas.ListagemImovel;
import br.edu.ifba.mobile.infomoveisclientes.tarefas.RemocaoCliente;
import br.edu.ifba.mobile.infomoveisclientes.tarefas.RemocaoImovel;


public class FragmentoListaImoveis extends Fragment {

    private static FragmentoListaImoveis instancia = null;

    public static FragmentoListaImoveis getInstancia() {
        if (instancia == null) {

            instancia = new FragmentoListaImoveis();

        }
        return instancia;
    }
    private View tela = null;
    private ListView lista = null;

    @Override
    public View onCreateView(LayoutInflater inflador, ViewGroup vgrupo, Bundle bundle){

        tela=inflador.inflate(R.layout.fragmento_lista_imoveis, vgrupo, false);

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
                RemocaoImovel remocao = new RemocaoImovel(this.getContext(), this.getImovelSelecionado());
                remocao.execute();
                atualizar();

            }
        }

        return super.onOptionsItemSelected(item);
    }

    private void preparar(){
        lista = (ListView) tela.findViewById(R.id.listaImoveis);

        this.setHasOptionsMenu(true);
        lista.setClickable(true);
        lista.setChoiceMode(ListView.CHOICE_MODE_SINGLE);


    }

    public void atualizar(){
        ListagemImovel listagem = new ListagemImovel (this.getContext(), lista);
        listagem.execute();
    }

    public Imovel getImovelSelecionado(){
        Imovel imovel = new Imovel ();

        int posicao = lista.getCheckedItemPosition();
        if (posicao != ListView.INVALID_POSITION){
            imovel = (Imovel) lista.getItemAtPosition(posicao);

        }

        return imovel;


    }



}


