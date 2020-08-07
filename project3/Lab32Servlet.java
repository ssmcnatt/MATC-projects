package java112.project3;

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
    name = "lab32Servlet", 
    urlPatterns = { "/lab32" }
)
public class Lab32Servlet extends HttpServlet {

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
        out.print("<HEAD><TITLE>Lab32Servlet Output</TITLE></HEAD>");
        out.print("<BODY>");
        out.print("<h1>Lab32 Servlet</h1>");
        out.print("<p><b>Locale: </b>" + request.getLocale() + "</p>");
        out.print("<p><b>Context Path: </b>" + request.getContextPath() + "</p>");
        out.print("<p><b>Local Name: </b>" + request.getLocalName() + "</p>");
        out.print("<p><b>Scheme: </b>" + request.getScheme() + "</p>");
        out.print("<p><a href=\"/java112\">Home page</p>");
        out.print("</BODY>");
        out.print("</HTML>");
        out.close();
    }
    
}

