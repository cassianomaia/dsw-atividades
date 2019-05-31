package br.ufscar.dc.dsw.pojo;

import java.io.Serializable;
import java.sql.Date;
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
    
    private Date data;
    
    @ManyToOne
    private Usuario usuario;
    
    @ManyToOne
    private Locadora locadora;

    public void setId(Long id) {
        this.id = id;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setLocadora(Locadora locadora) {
        this.locadora = locadora;
    }
    
    public Long getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Locadora getLocadora() {
        return locadora;
    }
}
