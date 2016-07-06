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
import br.edu.ifba.mobile.infomoveisclientes.bd.Cliente;
import br.edu.ifba.mobile.infomoveisclientes.tarefas.GravacaoCliente;


public class FragmentoCadastro extends Fragment {

    private static FragmentoCadastro instancia = null;

    public static FragmentoCadastro getInstancia() {
        if (instancia == null) {
            instancia = new FragmentoCadastro();

        }
        return instancia;

    }

    private View tela = null;

    private EditText nomeCliente = null;
    private EditText resp = null;
    private EditText email = null;
    private EditText num = null;
    private EditText respimovel = null;
    private EditText respbairrocid = null;


    private Button botaoGravar = null;

    private Cliente cliente = null;


    @Override
    public View onCreateView(LayoutInflater inflador, ViewGroup vgrupo, Bundle bundle) {

        tela = inflador.inflate(R.layout.fragmento_cadastro_clientes, vgrupo, false);

        preparar();

        return tela;

    }

    private void preparar() {
        nomeCliente = (EditText) tela.findViewById(R.id.nomeCliente);
        resp = (EditText) tela.findViewById(R.id.resp);
        email = (EditText) tela.findViewById(R.id.email);
        num = (EditText) tela.findViewById(R.id.num);
        respimovel = (EditText) tela.findViewById(R.id.respimovel);
        respbairrocid = (EditText) tela.findViewById(R.id.respbairrocid);
        botaoGravar = (Button) tela.findViewById(R.id.botaoGravar);
        botaoGravar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                GravacaoCliente gravacao = new GravacaoCliente(getContexto(), getCliente());
                gravacao.execute();
            }


        });
    }

    private Context getContexto() {
        return this.getContext();
    }

    private Cliente getCliente() {
        cliente.setNome(nomeCliente.getText().toString());
        cliente.setResp(resp.getText().toString());
        cliente.setEmail(email.getText().toString());
        cliente.setNum(num.getText().toString());
        cliente.setRespimovel(respimovel.getText().toString());
        cliente.setRespbairrocid(respbairrocid.getText().toString());

        return cliente;


    }

    public void exibirClienteSelecionado()
    {
        cliente = FragmentoListaClientes.getInstancia().getClienteSelecionado();

        if (cliente.getCod() == -1) {
            limparcampos();
        }else{
            carregarCampos();

        }
    }

    private void limparcampos(){
        nomeCliente.setText("");
        resp.setText("");
        email.setText("");
        num.setText("");
        respimovel.setText("");
        respbairrocid.setText("");


    }

    private void carregarCampos(){
        nomeCliente.setText(cliente.getNome());
        resp.setText(cliente.getResp() + "");
        email.setText(cliente.getEmail() + "");
        num.setText(cliente.getNum() + "");
        respimovel.setText(cliente.getRespimovel() + "");
        respbairrocid.setText(cliente.getRespbairrocid() + "");


    }
}
