package java112.project4;


import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


/**
 * This is the employee add display servlet.  It forwards to the Employee Add
 * JSP page.
 *
 * @author Steve McNatt
 */
@WebServlet(
name = "employeeAddDisplayServlet",
urlPatterns = {"/employee-add"}
) public class EmployeeAddDisplayServlet extends HttpServlet {

    /**
     * Handles HTTP GET requests.
     *
     * @param request the HttpServletRequest object
     * @param response the HttpServletResponse object
     * @exception ServletException if there is a Servlet failure
     * @exception IOException if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        System.out.println("In EmployeeAddDisplayServlet");
        HttpSession session = request.getSession();
        session.setAttribute("project4AddMessage", "");

        String url = "/employeeAdd.jsp";

        RequestDispatcher dispatcher
                    = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
