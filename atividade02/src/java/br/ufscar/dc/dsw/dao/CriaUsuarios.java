package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.pojo.Cliente;
import br.ufscar.dc.dsw.pojo.Locadora;
import br.ufscar.dc.dsw.pojo.Papel;
import br.ufscar.dc.dsw.pojo.Usuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CriaUsuarios {

    public static void main(String[] args) throws ClassNotFoundException {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        PapelDAO papelDAO = new PapelDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        ClienteDAO clienteDAO = new ClienteDAO();
        LocadoraDAO locadoraDAO = new LocadoraDAO();

        // Criando papeis utilizados no sistema
        Papel p1 = new Papel();
        p1.setNome("ROLE_ADMIN");
        papelDAO.save(p1);
        
        Papel p2 = new Papel();
        p2.setNome("ROLE_USER");
        papelDAO.save(p2);
        
        Papel p3 = new Papel();
        p3.setNome("ROLE_LOCADORA");
        papelDAO.save(p3);
        
        // Criando Usuario admin com papel ROLE_ADMIN
        Usuario u1 = new Usuario();
        u1.setEmail("admin@admin.com");
        u1.setSenha(encoder.encode("admin"));
        u1.setAtivo(true);
        usuarioDAO.save(u1);

        u1.getPapel().add(p1);
        usuarioDAO.update(u1);
        
        Cliente c1 = new Cliente();
        c1.setAtivo(true);
        c1.setCpf("111.111.111-11");
        c1.setData_nasc("04/03/1996");
        c1.setEmail("usuario@usuario.com");
        c1.setNome("Usuario");
        c1.setSenha(encoder.encode("usuario"));
        c1.setSexo("Masc");
        c1.setTelefone("(16)3333-3333");
        clienteDAO.save(c1);
        c1.getPapel().add(p2);
        usuarioDAO.update(c1);
        
        Locadora l1 = new Locadora();
        l1.setAtivo(true);
        l1.setCidade("São Carlos");
        l1.setCnpj("11.477.483/0001-36");
        l1.setEmail("locadora@locadora.com");
        l1.setNome("Locadora Faculdade");
        l1.setSenha(encoder.encode("locadora"));
        locadoraDAO.save(l1);
        l1.getPapel().add(p3);
        usuarioDAO.update(l1);
    }
}
