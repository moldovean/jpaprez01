package web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by adri on 12/2/16.
 */
@WebServlet(urlPatterns = "/simple2")
public class SimpleServlet2 extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("Iaka lucreaza");
        writer.println("Le me set some variables for you");
        req.setAttribute("firstName","Adrian");
        req.setAttribute("lastName","Vrabie");
//        req.getRequestDispatcher("myform.jsp").forward(req,resp);
        writer.close();
    }
}
