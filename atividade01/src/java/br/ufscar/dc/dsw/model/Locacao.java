package br.ufscar.dc.dsw.model;

import java.sql.Date;

public class Locacao {
    private String cpf;
    private String cnpj;
    private Date data;

    public Locacao(String cpf, String cnpj, Date data) {
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.data = data;
    }
    
    //Getters
    public String getCpf() {
        return cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public Date getData() {
        return data;
    }
    
    //Seters
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setData(Date data) {
        this.data = data;
    }  
}
