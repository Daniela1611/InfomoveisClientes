package br.edu.ifba.mobile.infomoveisclientes.bd;


public class Cliente {

    private long cod = -1;
    private String nome;
    private String resp;
    private String email;
    private String num;
    private String respimovel;
    private String respbairrocid;



    public long getCod() {
        return cod;
    }

    public void setCod(long cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getResp() {
        return resp;
    }

    public void setResp(String resp) {
        this.resp = resp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getRespimovel() {
        return respimovel;
    }

    public void setRespimovel(String end) {
        this.respimovel = end;
    }

    public String getRespbairrocid() {
        return respbairrocid;
    }

    public void setRespbairrocid(String respbairrocid) {
        this.respbairrocid = respbairrocid;
    }






    @Override
    public String toString(){


        return nome + " - " + num + " - Imóvel desejado: " + respimovel;
    }

}



