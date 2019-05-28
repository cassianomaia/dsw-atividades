package br.ufscar.dc.dsw.pojo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    public Long getID() {
        return ID;
    }

    private String email;
    private String senha;
    private String CPF;
    private int telefone;
    private String sexo;
    private String data_nasc;

//    public Cliente(String email, String senha, String CPF, int telefone, String sexo, String data_nasc) {
//        this.email = email;
//        this.senha = senha;
//        this.CPF = CPF;
//        this.telefone = telefone;
//        this.sexo = sexo;
//        this.data_nasc = data_nasc;
//    }
    public void set_email(String email) {
        this.email = email;
    }

    public String get_email() {
        return this.email;
    }

    public void set_senha(String senha) {
        this.senha = senha;
    }

    public String get_senha() {
        return this.senha;
    }

    public void set_cpf(String CPF) {
        this.CPF = CPF;
    }

    public String get_cpf() {
        return this.CPF;
    }

    public void set_telefone(int telefone) {
        this.telefone = telefone;
    }

    public int get_telefone() {
        return this.telefone;
    }

    public void set_sexo(String sexo) {
        this.sexo = sexo;
    }

    public String get_sexo() {
        return this.sexo;
    }

    public void set_data_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }

    public String get_data_nasc() {
        return this.data_nasc;
    }

}
