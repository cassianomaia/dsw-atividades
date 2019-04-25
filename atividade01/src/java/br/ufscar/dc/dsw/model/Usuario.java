package br.ufscar.dc.dsw.model;

public class Usuario {

    private Integer id;
    private String nome;
    private String email;
    private String senha;
    private Integer telefone;
    private String sexo;
    private String cpf;
    private boolean ativo;

    public Usuario(Integer id) {
        this.id = id;
    }

    public Usuario(String email, String cpf, String nome, Integer telefone, String senha, String sexo, boolean ativo) {
        this.email = email;
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.senha = senha;
        this.sexo = sexo;
        this.ativo = ativo;
    }

    public Usuario(Integer id, String email, String cpf, String nome, Integer telefone, String senha, String sexo, boolean ativo) {
        this(email, cpf, nome, telefone, senha, sexo, ativo);
        this.id = id;
    }

    // Getters
    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public String getSenha() {
        return senha;
    }

    public String getSexo() {
        return sexo;
    }

    public boolean getAtivo() {
        return ativo;
    }

    //Setters
    public void setId(Integer id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

}
