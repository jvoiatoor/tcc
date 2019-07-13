/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.CriarcontaDAO;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Criarconta;
import util.Criptografia;

/**
 *
 * @author Aluno
 */
@WebServlet(name = "LoginWS", urlPatterns = {"/admin/login/LoginWS"})
public class LoginWS extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        RequestDispatcher destino;
        switch (String.valueOf(acao)) {
            case "sair":
                request.getSession().setAttribute("usuario", null);
                response.sendRedirect("../inicial");
                return;
            //destino = request.getRequestDispatcher("../login/login.jsp");
            // destino.forward(request, response);
            //  break;
            case "inicial":
                destino = request.getRequestDispatcher("../inicial/index.jsp");
                destino.forward(request, response);
                break;
            default:
                destino = request.getRequestDispatcher("../login/login.jsp");
                destino.forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("txtEmail");
        String senha;
        String pagina;
        try {
            senha = Criptografia.convertPasswordToMD5(request.getParameter("txtSenha"));
            CriarcontaDAO dao = new CriarcontaDAO();
            Criarconta admin = dao.fazerlogin(email, senha);
            if (admin.getId() != null) {
            
                request.getSession().setAttribute("usuario", admin);
                
                if(admin.getGaragem()){
                pagina = "../inicial/index.jsp";
                    
                }
                else{
                pagina = "../inicial/index.jsp";
                }
            } else {
                request.setAttribute("msg", "Senha e/ou Login incorretos!");
                pagina = "login.jsp";
            }
            RequestDispatcher destino = request.getRequestDispatcher(pagina);
            destino.forward(request, response);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginWS.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
