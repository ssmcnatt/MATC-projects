package java112.project4;


import java.io.*;
import java.util.*;

import java112.analyzer.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


/**
 * This is the servlet used to select an output file from a dropdown list, and
 * display the selected file.
 *
 * @author Steve McNatt
 */
@WebServlet(
name = "analyzerShowOutputServlet",
urlPatterns = {"/analyzer-show-output"}
) public class AnalyzerShowOutputServlet extends HttpServlet {

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

        System.out.println("In AnalyzerShowOutputServlet");

        ServletContext context = getServletContext();

        Properties properties =
                (Properties) context.getAttribute("project4AnalyzerProperties");

        String fileName = properties.getProperty("output.dir")
                            + request.getParameter("fileDropdown");
        System.out.println("fileName: " + fileName);

        String outputFile = "file://" + properties.getProperty("output.dir")
                                + request.getParameter("fileDropdown");
        System.out.println("outputFile: " + outputFile);

        context.setAttribute("outputFile", outputFile);

        String url = "/analyzerShowOutput.jsp";

        RequestDispatcher dispatcher
                        = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
