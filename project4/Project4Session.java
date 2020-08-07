package java112.project4;

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
    name = "project4Session", 
    urlPatterns = { "/project4-session" }
)
public class Project4Session extends HttpServlet {

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
                
                
        HttpSession session = request.getSession();
        
        Integer sessionCounter;
        
        sessionCounter = (Integer) session.getAttribute("project4SessionCounter");
        
        if (sessionCounter == null) {
            sessionCounter = (Integer) 1;
            session.setAttribute("project4SessionCounter", sessionCounter);
        } else {
            sessionCounter++;
            session.setAttribute("project4SessionCounter", sessionCounter);
        }
                
        String url = "/project4Session.jsp";
 
        RequestDispatcher dispatcher 
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
    
}

