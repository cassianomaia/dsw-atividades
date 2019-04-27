package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.LocacaoDAO;
import br.ufscar.dc.dsw.dao.UsuarioDAO;
import br.ufscar.dc.dsw.model.Locacao;
import br.ufscar.dc.dsw.model.Usuario;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

@WebServlet(urlPatterns = "/locacao/*")
public class LocacaoController extends HttpServlet{
    private LocacaoDAO dao;
    private UsuarioDAO usuariodao;
    
    @Override
    public void init() {
        dao = new LocacaoDAO();
        usuariodao = new UsuarioDAO();
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        String action = request.getRequestURI();
        action = action.split("/")[action.split("/").length - 1];
        try {
            switch (action) {
                case "cadastro":
                    apresentaFormCadastro(request, response);
                    break;
                case "insercao":
                    insere(request, response);
                    break;
                case "remocao":
                    remove(request, response);
                    break;
                case "edicao":
                    apresentaFormEdicao(request, response);
                    break;
                case "atualizacao":
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
        List<Locacao> listaLocacao = dao.getAll();
        request.setAttribute("listaLocacao", listaLocacao);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/locacao/lista.jsp");
        dispatcher.forward(request, response);
    }
    
    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/locacao/formulario.jsp");
        dispatcher.forward(request, response);
    }
    
    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Locacao locacao = dao.get(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/locacao/formulario.jsp");
        request.setAttribute("locacao", locacao);
        dispatcher.forward(request, response);
    }
    
    private void atualize(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Integer id = Integer.parseInt(request.getParameter("id"));
        String cpf = request.getParameter("cpf");
        String cnpj = request.getParameter("cnpj");
        String data = request.getParameter("data");
        String hora = request.getParameter("hora");
        
        Locacao locacao = new Locacao(id, cpf, cnpj, data, hora);
        dao.update(locacao);
        response.sendRedirect("lista");
    }
    
    private void insere(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        String cnpj = request.getParameter("cnpj");
        String data = request.getParameter("data");
        String hora = request.getParameter("hora");
        
        Usuario usuario = usuariodao.getEmail(email);
        List<Locacao> listaLocacao = dao.getAll();
        boolean locar = true;
        
        
        if (!listaLocacao.isEmpty()) {
            for (int i = 0; i < listaLocacao.size(); i++) {
                                
                if (listaLocacao.get(i).getCpf().equals(usuario.getCpf())
                        && listaLocacao.get(i).getData().equals(data)) {
                                        
                    int hora_locacao = Integer.parseInt(listaLocacao.get(i).getHora().substring(0, 2));                    
                    int hora_locacao_atual = Integer.parseInt(hora.substring(0, 2));
                    
                    if (hora_locacao_atual >= hora_locacao && hora_locacao_atual <= hora_locacao + 1) {
                        locar = false;
                    }
                } else if (listaLocacao.get(i).getCnpj().equals(cnpj)
                        && listaLocacao.get(i).getData().equals(data)) {
                    
                    int hora_locacao = Integer.parseInt(listaLocacao.get(i).getHora());
                    int hora_locacao_atual = Integer.parseInt(hora);
                    if (hora_locacao_atual <= hora_locacao && hora_locacao_atual <= hora_locacao + 1) {
                        locar = false;
                    }
                }
            }
        }
        
        if (locar == true){
            Locacao locacao = new Locacao(usuario.getCpf(), cnpj, data, hora);
            dao.insert(locacao);
            response.sendRedirect("lista");
        }else{
            JOptionPane.showMessageDialog(null, "Não é possível cadastrar uma locação neste horário", "Erro de validação", JOptionPane.ERROR_MESSAGE);
            response.sendRedirect("lista");
        }
    }
    
    private void remove(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Locacao locacao = new Locacao(id);
        dao.delete(locacao);
        response.sendRedirect("lista");
    }
}