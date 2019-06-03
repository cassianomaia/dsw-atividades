/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.bean;

import br.ufscar.dc.dsw.dao.ClienteDAO;
import br.ufscar.dc.dsw.dao.LocadoraDAO;
import br.ufscar.dc.dsw.dao.PapelDAO;
import br.ufscar.dc.dsw.pojo.Cliente;
import br.ufscar.dc.dsw.pojo.Locadora;
import br.ufscar.dc.dsw.pojo.Papel;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author catit
 */
@ManagedBean
@SessionScoped
public class LocadoraBean {

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    private Locadora locadora;

    public String lista() {
        return "locadora/listaLocadoras.xhtml?faces-redirect=true";
    }

    public String cadastra() {
        locadora = new Locadora();
        return "formulario.xhtml";
    }

    public String formulario() {
        return "formulario.xhtml";
    }

    public String edita(Long id) {
        LocadoraDAO dao = new LocadoraDAO();
        locadora = dao.get(id);
        return "formulario.xhtml";
    }

    public String salva() {
        LocadoraDAO dao = new LocadoraDAO();
        locadora.setSenha(encoder.encode(locadora.getSenha()));
        long idpapel = 3;
        Papel papellocadora = new PapelDAO().get(idpapel);

        if (locadora.getId() == null) {
            locadora.setAtivo(true);
            dao.save(locadora);
            locadora.getPapel().add(papellocadora);
            dao.update(locadora);
        } else {
            dao.update(locadora);
        }
        return "listaLocadoras.xhtml";
    }

    public String delete(Locadora locadora) {
        LocadoraDAO dao = new LocadoraDAO();
        dao.delete(locadora);
        return "listaLocadoras.xhtml";
    }

    public String volta() {
        return "/index.xhtml?faces-redirect=true";
    }

    public List<Locadora> getLocadoras() throws SQLException {
        LocadoraDAO dao = new LocadoraDAO();
        return dao.getAll();
    }

    public Locadora getLocadora() {
        return locadora;
    }
}
