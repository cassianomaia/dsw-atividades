package br.ufscar.dc.dsw.pojo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"cpf"})})
public class Cliente extends Usuario implements Serializable {

    private String nome;
    private String CPF;
    private String telefone;
    private String sexo;
    private String data_nasc;

    @OneToOne
    private Usuario usuario;

    public Cliente() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String CPF) {
        this.CPF = CPF;
    }

    public String getCpf() {
        return this.CPF;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSexo() {
        return this.sexo;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }

    public String getData_nasc() {
        return this.data_nasc;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }
}
