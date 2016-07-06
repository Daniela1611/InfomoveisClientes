package br.edu.ifba.mobile.infomoveisclientes.bd;




public class Imovel {

    private long codigo = -1;
    private String respcod;
    private String respquarto;
    private String respsala;
    private String respbanheiro;
    private String respgaragem;
    private String respaluguel;






    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) { this.codigo = codigo; }

    public String getRespcod() {return respcod; }

    public void setRespcod(String respcod) {this.respcod = respcod; }

    public String getRespquarto() {return respquarto; }

    public void setRespquarto(String respquarto){this.respquarto = respquarto; }

    public String getRespsala() {return respsala; }

    public void setRespsala(String respsala){this.respsala = respsala; }

    public String getRespbanheiro() {return respbanheiro; }

    public void setRespbanheiro(String respbanheiro){this.respbanheiro = respbanheiro; }

    public String getRespgaragem() {return respgaragem; }

    public void setRespgaragem(String respgaragem){this.respgaragem = respgaragem; }

    public String getRespaluguel() {return respaluguel; }

    public void setRespaluguel(String respaluguel){this.respaluguel = respaluguel; }










    @Override
    public String toString(){


        return  "Cod: " + respcod + " Quartos: " + respquarto + " Banheiro: " + respbanheiro + " Garagem: " + respgaragem + " | " + respaluguel;
    }

}



