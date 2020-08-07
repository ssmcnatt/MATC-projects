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
    name = "jstlLab2Servlet", 
    urlPatterns = { "/jstl-lab2-servlet" }
)
public class JSTLLab2Servlet extends HttpServlet {

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
                
        List arrayList = new ArrayList();
        
        arrayList.add("One");
        arrayList.add("Two");
        arrayList.add("Three");
        
        request.setAttribute("arrayList", arrayList);
        
        String url = "/jstl-lab2.jsp";
 
        RequestDispatcher dispatcher 
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
    
}

