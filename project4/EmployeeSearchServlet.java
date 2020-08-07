package java112.project4;


import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


/**
 * This is the employee search servlet.  It forwards to the Employee Search JSP
 * page.
 *
 * @author Steve McNatt
 */
@WebServlet(
name = "employeeSearchServlet",
urlPatterns = {"/employee-search"}
) public class EmployeeSearchServlet extends HttpServlet {

    /**
     *  Handles HTTP GET requests.
     *
     *@param request the HttpServletRequest object
     *@param response the HttpServletResponse object
     *@exception ServletException if there is a Servlet failure
     *@exception IOException if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        System.out.println("In EmployeeSearchServlet");
        String url = "/employeeSearch.jsp";

        RequestDispatcher dispatcher
        = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
