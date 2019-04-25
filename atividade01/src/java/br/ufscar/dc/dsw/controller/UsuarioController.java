package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.UsuarioDAO;
import br.ufscar.dc.dsw.model.Usuario;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/usuario/*")
public class UsuarioController extends HttpServlet {

    private UsuarioDAO dao;

    @Override
    public void init() {
        dao = new UsuarioDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/cadastro":
                    apresentaFormCadastro(request, response);
                    break;
                case "/insercao":
                    insere(request, response);
                    break;
                case "/remocao":
                    remove(request, response);
                    break;
                case "/edicao":
                    apresentaFormEdicao(request, response);
                    break;
                case "/atualizacao":
                    atualize(request, response);
                    break;
                default:
                    lista(request, response);
                    break;
            }
        } catch (RuntimeException | IOException | ServletException e) {
            throw new ServletException(e);
        }
    }

    private void lista(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Usuario> listaUsuario = dao.getAll();
        request.setAttribute("listaUsuario", listaUsuario);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/usuario/lista.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/usuario/formulario.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Usuario usuario = dao.get(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/usuario/formulario.jsp");
        request.setAttribute("usuario", usuario);
        dispatcher.forward(request, response);
    }

    private void insere(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        String cpf = request.getParameter("cpf");
        String nome = request.getParameter("nome");
        Integer telefone = Integer.parseInt(request.getParameter("telefone"));
        String senha = request.getParameter("senha");
        String sexo = request.getParameter("sexo");
        boolean ativo = Boolean.parseBoolean(request.getParameter("ativo"));

        Usuario usuario = new Usuario(email, cpf, nome, telefone, senha, sexo, ativo);
        dao.insert(usuario);
        response.sendRedirect("lista");
    }

    private void atualize(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Integer id = Integer.parseInt(request.getParameter("id"));
        String email = request.getParameter("email");
        String cpf = request.getParameter("cpf");
        String nome = request.getParameter("nome");
        Integer telefone = Integer.parseInt(request.getParameter("telefone"));
        String senha = request.getParameter("senha");
        String sexo = request.getParameter("sexo");
        boolean ativo = Boolean.parseBoolean(request.getParameter("ativo"));

        Usuario usuario = new Usuario(id, email, cpf, nome, telefone, senha, sexo, ativo);
        dao.update(usuario);
        response.sendRedirect("lista");
    }

    private void remove(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Usuario usuario = new Usuario(id);
        dao.delete(usuario);
        response.sendRedirect("lista");
    }
}
