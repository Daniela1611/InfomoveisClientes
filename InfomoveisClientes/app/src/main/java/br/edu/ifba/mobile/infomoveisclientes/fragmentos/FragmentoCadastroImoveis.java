package br.edu.ifba.mobile.infomoveisclientes.fragmentos;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import br.edu.ifba.mobile.infomoveisclientes.R;
import br.edu.ifba.mobile.infomoveisclientes.bd.Imovel;
import br.edu.ifba.mobile.infomoveisclientes.tarefas.GravacaoImovel;


public class FragmentoCadastroImoveis extends Fragment {

    private static FragmentoCadastroImoveis instancia = null;

    public static FragmentoCadastroImoveis getInstancia() {
        if (instancia == null) {
            instancia = new FragmentoCadastroImoveis();

        }
        return instancia;

    }

    private View tela = null;

    private EditText respcod = null;
    private EditText respquarto = null;
    private EditText respsala = null;
    private EditText respbanheiro = null;
    private EditText respgaragem = null;
    private EditText respaluguel = null;

    private Button botaoGravar2 = null;

    private Imovel imovel = null;


    @Override
    public View onCreateView(LayoutInflater inflador, ViewGroup vgrupo, Bundle bundle) {

        tela = inflador.inflate(R.layout.fragmento_cadastro_imoveis, vgrupo, false);

        preparar();

        return tela;

    }

    private void preparar() {
        respcod = (EditText) tela.findViewById(R.id.respcod);
        respquarto = (EditText) tela.findViewById(R.id.respquarto);
        respsala = (EditText) tela.findViewById(R.id.respsala);
        respbanheiro = (EditText) tela.findViewById(R.id.respbanheiro);
        respgaragem = (EditText) tela.findViewById(R.id.respgaragem);
        respaluguel = (EditText) tela.findViewById(R.id.respaluguel);
        botaoGravar2 = (Button) tela.findViewById(R.id.botaoGravar2);
        botaoGravar2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                GravacaoImovel gravacao = new GravacaoImovel(getContexto(), getImovel());
                gravacao.execute();
            }


        });
    }

    private Context getContexto() {
        return this.getContext();
    }

    private Imovel getImovel() {
        imovel.setRespcod(respcod.getText().toString());
        imovel.setRespquarto(respquarto.getText().toString());
        imovel.setRespsala(respsala.getText().toString());
        imovel.setRespbanheiro(respbanheiro.getText().toString());
        imovel.setRespgaragem(respgaragem.getText().toString());
        imovel.setRespaluguel(respaluguel.getText().toString());

        return imovel;


    }

    public void exibirImovelSelecionado()
    {
        imovel = FragmentoListaImoveis.getInstancia().getImovelSelecionado();

        if (imovel.getCodigo() == -1) {
            limparcampos();
        }else{
            carregarCampos();

        }
    }

    private void limparcampos(){
        respcod.setText("");
        respquarto.setText("");
        respsala.setText("");
        respbanheiro.setText("");
        respgaragem.setText("");
        respaluguel.setText("");


    }

    private void carregarCampos(){

        respcod.setText(imovel.getRespcod() + "");
        respquarto.setText(imovel.getRespquarto() + "");
        respsala.setText(imovel.getRespsala() + "");
        respbanheiro.setText(imovel.getRespbanheiro() + "");
        respgaragem.setText(imovel.getRespgaragem() + "");
        respaluguel.setText(imovel.getRespaluguel() + "");



    }
}
