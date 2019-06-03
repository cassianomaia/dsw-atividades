package br.ufscar.dc.dsw.bean;

import br.ufscar.dc.dsw.dao.ClienteDAO;
import br.ufscar.dc.dsw.dao.LocacaoDAO;
import br.ufscar.dc.dsw.dao.LocadoraDAO;
import br.ufscar.dc.dsw.dao.PapelDAO;
import br.ufscar.dc.dsw.dao.UsuarioDAO;
import br.ufscar.dc.dsw.pojo.Cliente;
import br.ufscar.dc.dsw.pojo.Locacao;
import br.ufscar.dc.dsw.pojo.Locadora;
import br.ufscar.dc.dsw.pojo.Papel;
import br.ufscar.dc.dsw.pojo.Usuario;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class LocacaoBean {
    
    private Locacao locacao;
    private Usuario usuario;
    private Cliente cliente;
    private Locadora locadora;
    
    public String lista(String email) {
        UsuarioDAO usuariodao = new UsuarioDAO();
        ClienteDAO clientedao = new ClienteDAO();
        LocadoraDAO locadoradao = new LocadoraDAO();
        usuario = usuariodao.getByEmail(email);
        PapelDAO papeldao = new PapelDAO();
        long dois = 2;
        long tres = 3;
        Papel papelcliente = papeldao.get(dois);
        Papel papellocadora = papeldao.get(tres);
        
        if(usuario.getPapel().contains(papelcliente)){
            cliente = clientedao.get(usuario.getId());
            System.out.println("Achou Cliente");
        }else if(usuario.getPapel().contains(papellocadora)){
            locadora = locadoradao.get(usuario.getId());
            System.out.println("Achou Locadora");
        }
        return "locacao/lista.xhtml?faces-redirect=true";
    }

    public String cadastra() {
        locacao = new Locacao();
        return "form.xhtml";
    }

    public String edita(Long id) {
        LocacaoDAO dao = new LocacaoDAO();
        locacao = dao.get(id);
        return "form.xhtml";
    }

    public String salva() {
        LocacaoDAO dao = new LocacaoDAO();
        
        if (locacao.getId() == null) {
            dao.save(locacao);
        } else {
            dao.update(locacao);
        }
        return "lista.xhtml";
    }

    public String delete(Locacao locacao) {
        LocacaoDAO dao = new LocacaoDAO();
        dao.delete(locacao);
        return "lista.xhtml";
    }

    public String volta() {
        return "/lista.xhtml?faces-redirect=true";
    }

    public List<Locacao> getLocacoes() throws SQLException {
        LocacaoDAO dao = new LocacaoDAO();
        if(cliente != null){
            return dao.getAllCliente(cliente);
        }else if(locadora != null){
            return dao.getAllLocadora(locadora);
        }else{
            return dao.getAll();
        }
    }

    public Locacao getLocacao() {
        return locacao;
    }
    
    public List<Cliente> getClientes() throws SQLException {
        ClienteDAO dao = new ClienteDAO();
        return dao.getAll();
    }
    
    public List<Locadora> getLocadoras() throws SQLException {
        LocadoraDAO dao = new LocadoraDAO();
        return dao.getAll();
    }
}
