package br.ufscar.dc.dsw.pojo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Cliente extends Usuario implements Serializable {

   
    private String nome;
    private String CPF;
    private int telefone;
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
    
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
    
    public Usuario getUsuario(){
        return this.usuario;
    }
}
