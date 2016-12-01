package web;


import services.EmployeeServiceEE;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by avrabie on 12/1/2016.
 */
@WebServlet(urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    @EJB
    EmployeeServiceEE bean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        PrintWriter writer = resp.getWriter();
        writer.println("Starting persistence!");

        if (action.equals("create")) {
            String id = req.getParameter("id");
            String firstName = req.getParameter("firstName");
            String lastName = req.getParameter("lastName");
            String salary = req.getParameter("salary");
            bean.createEmployee(Long.parseLong(id), firstName, lastName, Long.parseLong(salary));
            writer.println("Should have been created!");
        }
        writer.println("Iaka: "+action);

        writer.close();
    }
}
