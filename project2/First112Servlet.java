package java112.project2;


import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


/**
 * This is the First112 servlet for Project 2.  It generates HTML to output my name,
 * the course name, an image, and a link back to the project home page.
 *
 * @author Steve McNatt
 */
@WebServlet(
name = "first112Servlet",
urlPatterns = {"/first112"}
) public class First112Servlet extends HttpServlet {

    /**
     *  Handles HTTP GET requests.
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
        out.print("<HEAD><TITLE>First Servlet Output</TITLE></HEAD>");
        out.print("<BODY>");
        out.print("<h1>Advanced Java - Steve McNatt</h1>");
        out.print("<p><img src=\"images/hermie.jpg\"><p>");
        out.print("<p><a href=\"/java112\">Home page</p>");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }
}
