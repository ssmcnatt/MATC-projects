package java112.project4;


import java.io.*;
import java.util.*;

import java112.analyzer.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


/**
 * This is the main analyzer servlet for project 4.
 *
 * @author Steve McNatt
 */
@WebServlet(
name = "analyzerMainServlet",
urlPatterns = {"/analyzer-main"}
) public class AnalyzerMainServlet extends HttpServlet {

    private Properties properties;


    /**
     * This is the init method that calls loadProperties() to load the
     * properties file into the properties object.
     */
    public void init() throws ServletException {

        loadProperties("/project4_analyzer.properties");

        ServletContext context = getServletContext();

        context.setAttribute("project4AnalyzerProperties", properties);
    }


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

        System.out.println("In AnalyzerMainServlet");
        String url = "/analyzerMain.jsp";

        RequestDispatcher dispatcher
                            = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }


    /**
     * This method loads the properties file into the properties object.
     *
     * @param propertiesFilePath file path of the properties file
     */
    public void loadProperties(String propertiesFilePath) {

        properties = new Properties();

        try {
            properties.load(this.getClass().getResourceAsStream(propertiesFilePath));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
