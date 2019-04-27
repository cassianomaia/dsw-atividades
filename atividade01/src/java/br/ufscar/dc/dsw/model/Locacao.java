package br.ufscar.dc.dsw.model;

import java.sql.Date;

public class Locacao {
    private Integer id;
    private String cpf;
    private String cnpj;
    private String data;
    private String hora;

    public Locacao(Integer id){
        this.id = id;
    }

    public Locacao(String cpf, String cnpj, String data, String hora) {
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.data = data;
        this.hora = hora;
    }
    
    public Locacao(Integer id, String cpf, String cnpj, String data, String hora) {
        this(cpf, cnpj, data, hora);
        this.id = id;
    }
    
    //Getters
    public Integer getId() {
        return id;
    }
    
    public String getCpf() {
        return cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }
    
    //Seters
    public void setId(Integer id) {
        this.id = id;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
