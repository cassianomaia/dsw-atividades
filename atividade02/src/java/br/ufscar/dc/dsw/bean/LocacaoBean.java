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
import javax.swing.JOptionPane;

@ManagedBean
@SessionScoped
public class LocacaoBean {
    private String email;
    private Locacao locacao;
    private Usuario usuario;
    private Cliente cliente;
    private Locadora locadora;
    
    public String lista(String email) {
        this.email = email;
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
        LocacaoDAO locacaodao = new LocacaoDAO();
        UsuarioDAO usuariodao = new UsuarioDAO();
        ClienteDAO clientedao = new ClienteDAO();
        int i;
        List<Locacao> lista = locacaodao.getAll();
        usuario = usuariodao.getByEmail(email);
        Cliente cliente = clientedao.get(usuario.getId());
        locacao.setCliente(cliente);
        for(i = 0; i<lista.size();i++){
            if(lista.get(i).getLocadora().equals(locacao.getLocadora()) && lista.get(i).getDia().equals(locacao.getDia()) && lista.get(i).getHorario().equals(locacao.getHorario())){
                //JOptionPane.showMessageDialog(null, "A locadora não tem o horário disponivel.", "Locação Existente", JOptionPane.ERROR_MESSAGE);
                return "lista.xhtml";
            }else if(lista.get(i).getCliente().equals(locacao.getCliente()) && lista.get(i).getDia().equals(locacao.getDia()) && lista.get(i).getHorario().equals(locacao.getHorario())){
                //JOptionPane.showMessageDialog(null, "O cliente já tem uma locação nesse horário.", "Locação Existente", JOptionPane.ERROR_MESSAGE);
                return "lista.xhtml";
            }
        }
        if (locacao.getId() == null) {
            locacaodao.save(locacao);
        } else {
            locacaodao.update(locacao);
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
        UsuarioDAO usuariodao = new UsuarioDAO();
        ClienteDAO clientedao = new ClienteDAO();
        LocadoraDAO locadoradao = new LocadoraDAO();
        LocacaoDAO locacaodao = new LocacaoDAO();
        usuario = usuariodao.getByEmail(email);
        PapelDAO papeldao = new PapelDAO();
        long dois = 2;
        long tres = 3;
        Papel papelcliente = papeldao.get(dois);
        Papel papellocadora = papeldao.get(tres);
        List<Papel> papelusuario = usuario.getPapel();
        if (papelusuario.get(0).equals(papelcliente)){
            cliente = clientedao.get(usuario.getId());
            return locacaodao.getAllCliente(cliente);
        }else if(papelusuario.get(0).equals(papellocadora)){
            locadora = locadoradao.get(usuario.getId());
            return locacaodao.getAllLocadora(locadora);
        }else{
            return locacaodao.getAll();
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
