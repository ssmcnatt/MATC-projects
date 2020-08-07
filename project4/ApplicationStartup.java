package java112.project4;


import java.io.*;
import java.util.*;

import java112.employee.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


/**
 * This is the HTTP application startup servlet for Project 4.  It loads the
 * properties file, and sets attributes for the properties, and the employee
 * directory instance.
 *
 * @author Steve McNatt
 */
@WebServlet(
name = "applicationStartup",
urlPatterns = {"/project4-startup"},
loadOnStartup = 1
) public class ApplicationStartup extends HttpServlet {

    private Properties properties;

    /**
     * This is the init method that loads the properties file and sets the
     * attributes.
     */
    public void init() throws ServletException {

        loadProperties("/project4.properties");

        ServletContext context = getServletContext();

        context.setAttribute("project4Properties", properties);

        EmployeeDirectory employeeDirectory = new EmployeeDirectory(properties);

        context.setAttribute("employeeDirectory", employeeDirectory);
    }


    /**
     * This method loads the properties file.
     *
     * @param propertiesFilePath the properties file path
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
