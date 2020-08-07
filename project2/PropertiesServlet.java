package java112.project2;


import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


/**
 * This is the Properties servlet for Project 2.  It generates HTML to output
 * all of the data in the project2.properties file in table format.
 *
 * @author Steve McNatt
 */
@WebServlet(
name = "propertiesServlet",
urlPatterns = {"/properties"}
) public class PropertiesServlet extends HttpServlet {

    private Properties properties;


    /**
     * This is the init method that calls loadProperties() to load the
     * properties file into the properties object.
     */
    public void init() throws ServletException {

        loadProperties("/project2.properties");
    }


    /**
     * Handles HTTP GET requests.
     *
     * @param request               the HttpServletRequest object
     * @param response              the HttpServletResponse object
     * @exception ServletException  if there is a Servlet failure
     * @exception IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html");

        // set the response type before sending data
        PrintWriter out = response.getWriter();
        out.print("<HTML>");
        out.print("<HEAD><TITLE>Properties Servlet Output</TITLE></HEAD>");
        out.print("<BODY>");
        out.print("<h1>Properties Servlet</h1>");

        out.print("<table border=\"1\">");
        out.print("<tr>");
        out.print("<td>Author Name</td>");
        out.print("<td>" + properties.getProperty("author.name") + "</td>");
        out.print("</tr>");
        out.print("<tr>");
        out.print("<td>Author Email</td>");
        out.print("<td>" + properties.getProperty("author.email.address") + "</td>");
        out.print("</tr>");
        out.print("<tr>");
        out.print("<td>Course title</td>");
        out.print("<td>" + properties.getProperty("course.title") + "</td>");
        out.print("</tr>");
        out.print("<tr>");
        out.print("<td>Course Days and Times</td>");
        out.print("<td>" + properties.getProperty("course.days.times") + "</td>");
        out.print("</tr>");
        out.print("<tr>");
        out.print("<td>Instructor Name</td>");
        out.print("<td>" + properties.getProperty("instructor.name") + "</td>");
        out.print("</tr>");out.print("<tr>");
        out.print("<td>Project Description</td>");
        out.print("<td>" + properties.getProperty("project.description") + "</td>");
        out.print("</tr>");
        out.print("</table>");

        out.print("<p><a href=\"/java112\">Home page</p>");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
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
