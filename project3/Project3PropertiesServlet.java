package java112.project3;


import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


/**
 * This is the Properties servlet for Project 3.  It generates HTML to output
 * all of the data in the project3.properties file in table format.
 *
 * @author Steve McNatt
 */
@WebServlet(
name = "project3PropertiesServlet",
urlPatterns = {"/project3-properties"}
) public class Project3PropertiesServlet extends HttpServlet {

    private Properties properties;


    /**
     * This is the init method that calls loadProperties() to load the
     * properties file into the properties object.
     */
    public void init() throws ServletException {

        loadProperties("/project3.properties");
    }


    /**
     *  Handles HTTP GET requests.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        request.setAttribute("authorName", properties.getProperty("author.name"));
        request.setAttribute("authorEmail", properties.getProperty("author.email.address"));
        request.setAttribute("courseTitle", properties.getProperty("course.title"));
        request.setAttribute("courseDaysTimes", properties.getProperty("course.days.times"));
        request.setAttribute("instructorName", properties.getProperty("instructor.name"));
        request.setAttribute("projectDescription", properties.getProperty("project.description"));

        String url = "/project3Properties.jsp";

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
