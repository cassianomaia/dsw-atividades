package br.ufscar.dc.dsw.model;

public class Usuario {

    private Integer id;
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private String sexo;
    private String cpf;
    private int ativo;

    public Usuario(Integer id) {
        this.id = id;
    }

    public Usuario(String email, String cpf, String nome, String telefone, String senha, String sexo, int ativo) {
        this.email = email;
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.senha = senha;
        this.sexo = sexo;
        this.ativo = ativo;
    }

    public Usuario(Integer id, String email, String cpf, String nome, String telefone, String senha, String sexo, int ativo) {
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

    public String getTelefone() {
        return telefone;
    }

    public String getSenha() {
        return senha;
    }

    public String getSexo() {
        return sexo;
    }

    public int getAtivo() {
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

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

}
