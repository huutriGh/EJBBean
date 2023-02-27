package org.example.servlets;

import org.example.services.AccountClient;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/account")
public class AccountServlet extends HttpServlet {

    @Inject
    AccountClient client;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        write(response, "Example Servlet to show how EJB can invoke an EJB in another application");
        try {
            long money= request.getParameter("money") != null ? Long.parseLong(request.getParameter("money")) : 100l;
            float moneyWithInterest = client.callRemoteEJB(money);
            write(response, "Amount: " + moneyWithInterest);
        } catch (Exception n) {
            write(response, "Failed to invoke Remote EJB");
            write(response, n.getMessage());
        }
    }
    private static void write(HttpServletResponse writer, String message) {
        try {
            writer.getWriter().write(message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
