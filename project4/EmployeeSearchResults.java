package java112.project4;


import java.io.*;
import java.util.*;

import java112.employee.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


/**
 * This is the employee search results servlet for projecy 4.  It gets the search
 * type and search term from the search page, calls the searchEmlployee() method,
 * and outputs the search results.
 *
 * @author Steve McNatt
 */
@WebServlet(
name = "employeeSearchResults",
urlPatterns = {"/employee-search-results"}
) public class EmployeeSearchResults extends HttpServlet {

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

        Search search = null;

        ServletContext context = getServletContext();

        EmployeeDirectory employeeDirectory =
                (EmployeeDirectory) context.getAttribute("employeeDirectory");

        String searchType = request.getParameter("searchType");
        String searchTerm = request.getParameter("searchTerm");

        System.out.println("Search type: " + searchType);
        System.out.println("Search term: " + searchTerm);

        if (searchTerm != null && searchTerm != "") {
            search = employeeDirectory.searchEmployee(searchTerm, searchType);
        }

        HttpSession session = request.getSession();
        session.setAttribute("search", search);

        System.out.println("In EmployeeSearchResults");
        String url = "/employeeSearchResults.jsp";

        RequestDispatcher dispatcher
                    = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
