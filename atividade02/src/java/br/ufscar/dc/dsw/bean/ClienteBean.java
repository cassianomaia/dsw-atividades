package br.ufscar.dc.dsw.bean;

import br.ufscar.dc.dsw.dao.ClienteDAO;
import br.ufscar.dc.dsw.dao.PapelDAO;
import br.ufscar.dc.dsw.pojo.Cliente;
import br.ufscar.dc.dsw.pojo.Papel;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@ManagedBean
@SessionScoped
public class ClienteBean {
    
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    private Cliente cliente;
    
    public String lista() {
        return "cliente/lista.xhtml?faces-redirect=true";
    }

    public String cadastra() {
        cliente = new Cliente();
        return "form.xhtml";
    }

    public String edita(Long id) {
        ClienteDAO dao = new ClienteDAO();
        cliente = dao.get(id);
        return "form.xhtml";
    }

    public String salva() {
        ClienteDAO dao = new ClienteDAO();
        cliente.setSenha(encoder.encode(cliente.getSenha()));
        long idpapel = 2;
        Papel papelcliente = new PapelDAO().get(idpapel);
        
        if (cliente.getId() == null) {
            cliente.setAtivo(true);
            dao.save(cliente);
            cliente.getPapel().add(papelcliente);
            dao.update(cliente);
        } else {
            dao.update(cliente);
        }
        return "lista.xhtml";
    }

    public String delete(Cliente cliente) {
        ClienteDAO dao = new ClienteDAO();
        dao.delete(cliente);
        return "index.xhtml";
    }

    public String volta() {
        return "/lista.xhtml?faces-redirect=true";
    }

    public List<Cliente> getClientes() throws SQLException {
        ClienteDAO dao = new ClienteDAO();
        return dao.getAll();
    }

    public Cliente getCliente() {
        return cliente;
    }
}
