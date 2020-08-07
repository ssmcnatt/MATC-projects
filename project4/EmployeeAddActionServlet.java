package java112.project4;


import java.io.*;
import java.util.*;

import java112.employee.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


/**
 * This the employee add action servlet.  It gets the employeeDirectory, gets
 * the data from the employee add page, and adds the employee to the database.
 *
 *@author    eknapp
 */
@WebServlet(
name = "employeeAddActionServlet",
urlPatterns = {"/employee-add-action"}
) public class EmployeeAddActionServlet extends HttpServlet {

    EmployeeDirectory employeeDirectory;


    /**
     * This is the init method.  It gets the employeeDirectory.
     */
    public void init() throws ServletException {

        ServletContext context = getServletContext();

        employeeDirectory = new EmployeeDirectory();

        employeeDirectory 
                = (EmployeeDirectory)context.getAttribute("employeeDirectory");
    }


    /**
     *  Handles HTTP POST requests.
     *
     * @param request the HttpServletRequest object
     * @param response the HttpServletResponse object
     * @exception ServletException if there is a Servlet failure
     * @exception IOException if there is an IO failure
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        System.out.println("In EmployeeAddActionServlet");
        String message = null;
        String employeeId = null;

        Employee employee = new Employee();

        if (request.getParameter("firstName") == null
                || request.getParameter("firstName") == ""
                || request.getParameter("lastName") == null
                || request.getParameter("lastName") == ""
                || request.getParameter("socialSecurityNumber") == null
                || request.getParameter("socialSecurityNumber") == ""
                || request.getParameter("department") == null
                || request.getParameter("department") == ""
                || request.getParameter("phoneNumber") == null
                || request.getParameter("phoneNumber") == "") {

            message = "All fields must be entered";
        } else {
            employee.setEmployeeFirstName(request.getParameter("firstName"));
            employee.setEmployeeLastName(request.getParameter("lastName"));
            employee.setEmployeeSsn(request.getParameter("socialSecurityNumber"));
            employee.setEmployeeDepartment(request.getParameter("department"));
            employee.setEmployeeRoomNumber(request.getParameter("roomNumber"));
            employee.setEmployeePhoneNumber(request.getParameter("phoneNumber"));

            employeeId 
                = employeeDirectory.addEmployeeRecord(employee.getEmployeeFirstName(),
            employee.getEmployeeLastName(),
            employee.getEmployeeSsn(),
            employee.getEmployeeDepartment(),
            employee.getEmployeeRoomNumber(),
            employee.getEmployeePhoneNumber());

            message = "Employee Added: " + employeeId + " - "
                        + employee.getEmployeeFirstName() + " "
                        + employee.getEmployeeLastName();
        }


        System.out.println(employee.toString());

        HttpSession session = request.getSession();
        session.setAttribute("project4AddMessage", message);

        String url = "/java112/employeeAdd.jsp";

        response.sendRedirect(url);
    }
}
