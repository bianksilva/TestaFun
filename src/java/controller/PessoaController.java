package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import java.text.SimpleDateFormat;
import model.Pessoa;
import persistencia.PessoaDAO;

/**
 *
 * @author Bianca Silva
 */
@WebServlet(name = "PessoaController", urlPatterns = {"/PessoaController"})
public class PessoaController extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int cod = Integer.parseInt(request.getParameter("cod"));
            PessoaDAO dao = new PessoaDAO();
            if (request.getParameter("acao").equals("alterar")) {
                Pessoa pessoa = dao.getPessoaPorCodigo(cod);
                if (pessoa.getCod() > 0) {
                    RequestDispatcher disp = getServletContext().getRequestDispatcher("/exibir_pessoa.jsp");
                    request.setAttribute("pessoa", pessoa);
                    disp.forward(request, response);
                } else {
                    PrintWriter out = response.getWriter();
                    out.println("<script>alert('Usuário não encontrado! ');location.href='./index.jsp'</script>");
                }
            }

            if (request.getParameter("acao").equals("excluir")) {
                PrintWriter out = response.getWriter();
                if (dao.excluir(cod)) {
                    out.println("<script>alert('Pessoa excluída com sucesso! ');location.href='./index.jsp'</script>");
                } else {
                    out.println("<script>alert('Não foi possível excluir o usuário! ');location.href='./index.jsp'</script>");
                }

            }

            if (request.getParameter("acao").equals("exibir")) {
                Pessoa pessoa = dao.getPessoaPorCodigo(cod);
                if (pessoa.getCod() > 0) {
                    RequestDispatcher disp = getServletContext().getRequestDispatcher("/exibir_pessoa.jsp");
                    request.setAttribute("pessoa", pessoa);
                    disp.forward(request, response);
                } else {
                    PrintWriter out = response.getWriter();
                    out.println("<script>alert('Perfil não encontrado! ');location.href='./index.jsp'</script>");
                }
            }

        } catch (Exception e) {
            System.out.println("Erro ao recuperar dados");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String mensagem;
        try {
            Pessoa pessoa = new Pessoa();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            if (!request.getParameter("cod").isEmpty()) {
                pessoa.setCod(Integer.parseInt(request.getParameter("cod")));
            }
            pessoa.setCpf(request.getParameter("cpf"));
            pessoa.setNome(request.getParameter("nome"));
            pessoa.setNascimento(df.parse(request.getParameter("nascimento")));
            
            PessoaDAO dao = new PessoaDAO();

            if (dao.inserir_Pessoa(pessoa)) {
                mensagem = "Pessoa cadastrada com sucesso!";
            } else {
                mensagem = "Erro ao gravar pessoa!" ;
            }

        } catch (Exception e) {
            mensagem = "Erro!" + e;
            System.out.println("Erro ao gravar pessoa: " + e.getMessage());
        }

        PrintWriter out = response.getWriter();
        out.println("<script>alert('" + mensagem + "') ;location.href='./index.jsp'</script>");
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
