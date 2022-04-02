package com.example.consultacep;

public class CEP {
    private String cep;
    private String logadouro;
    private String bairro;
    private String localidade;
    private String uf;

    public String getCep() {
        return cep;
    }

    public void setCep(String logadouro) {
        this.cep = logadouro;
    }

    public String getLogadouro() {
        return logadouro;
    }

    public void setLogadouro(String logadouro) {
        this.logadouro = logadouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return
                "Cep: " + getCep()+
                "\n09Logadouro:" + getLogadouro()
                +"\nBairro: "+getBairro()
                +"\nCidade: "+getLocalidade()
                +"\nEstado: "+getUf();
    }
}
