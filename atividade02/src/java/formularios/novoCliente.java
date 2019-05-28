package formularios;

import br.ufscar.dc.dsw.pojo.Usuario;
import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author rodrigo
 */
@ManagedBean
@SessionScoped
public class novoCliente {

//    private Usuario cliente;
    public novoCliente() {
//        cliente = new Usuario();
    }

    public String index() {
        return "/faces/cliente/novoCliente.xhtml?redirect=true";
    }

}
