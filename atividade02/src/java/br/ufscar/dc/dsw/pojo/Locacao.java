package br.ufscar.dc.dsw.pojo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Locacao implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    private String dia;
    private String horario;

    @ManyToOne
    private Cliente cliente;
    
    @ManyToOne
    private Locadora locadora;

    public void setId(Long id) {
        this.id = id;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setLocadora(Locadora locadora) {
        this.locadora = locadora;
    }
    
    public void setDia(String dia) {
        this.dia = dia;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
    
    
    public Long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Locadora getLocadora() {
        return locadora;
    }

    public String getDia() {
        return dia;
    }

    public String getHorario() {
        return horario;
    }
}