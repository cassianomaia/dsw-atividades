package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.LocadoraDAO;
import br.ufscar.dc.dsw.model.Locadora;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/locadora/*")
public class LocadoraController extends HttpServlet{
       private LocadoraDAO dao;
       
    @Override
    public void init() {
        dao = new LocadoraDAO();
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
                    lista(request, response);
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
        List<Locadora> listaLocadora = dao.getAll();
        request.setAttribute("listaLocadora", listaLocadora);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/locadora/lista.jsp");
        dispatcher.forward(request, response);
    }
}
