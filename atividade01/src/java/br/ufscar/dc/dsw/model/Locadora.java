package br.ufscar.dc.dsw.model;

public class Locadora {

    private Integer id;
    private String nome;
    private String email;
    private String senha;
    private String cnpj;
    private String cidade;

    public Locadora(Integer id) {
        this.id = id;
    }

    public Locadora(String nome, String email, String senha, String cnpj, String cidade) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cnpj = cnpj;
        this.cidade = cidade;
    }

    public Locadora(Integer id, String nome, String email, String senha, String cnpj, String cidade) {
        this(nome, email, senha, cnpj, cidade);
        this.id = id;
    }

    // Getters
    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getCidade() {
        return cidade;
    }

    //Setters
    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
