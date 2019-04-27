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

@WebServlet(urlPatterns = "/")
public class MainController extends HttpServlet {
    
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
            apresentaIndex(request, response);
        } catch (RuntimeException | IOException e) {
            throw new ServletException(e);
        }
    }
    
    private void apresentaIndex(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LocadoraDAO dao = new LocadoraDAO();
        List<Locadora> listaLocadora = dao.getAll();
        request.setAttribute("listaLocadora", listaLocadora);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/index.jsp");
        dispatcher.forward(request, response);
    }
}
