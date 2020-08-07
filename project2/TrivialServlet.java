package java112.project2;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *  This is part of a lab and is the first servlet for the course.
 *
 *@author    eknapp
 */
@WebServlet(
    name = "trivialServlet", 
    urlPatterns = { "/trivial", "/simple" }
)
public class TrivialServlet extends HttpServlet {

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
        response.setContentType("text/html");
        // set the response type before sending data
        PrintWriter  out  = response.getWriter();
        out.print("<HTML>");
        out.print("<HEAD><TITLE>Trivial Servlet Output</TITLE></HEAD>");
        out.print("<BODY>");
        out.print("<h1>Trivial Servlet</h1>");
        out.print("<p><a href=\"/java112\">Home page</p>");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }
    
}

