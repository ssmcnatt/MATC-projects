package java112.project3;


import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


/**
 * This is the HTTP request servlet for Project 3.  It generates HTML to output
 * several parts of information in the HTTP request.
 *
 * @author Steve McNatt
 */
@WebServlet(
name = "requestServlet",
urlPatterns = {"/request-servlet"}
) public class HttpRequestServlet extends HttpServlet {

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

        HttpRequestData requestData = new HttpRequestData();

        requestData.setRequestRemoteComputer(request.getRemoteHost());
        requestData.setRequestRemoteAddress(request.getRemoteAddr());
        requestData.setRequestHttpMethod(request.getMethod());
        requestData.setRequestUri(request.getRequestURI());
        requestData.setRequestUrl(request.getRequestURL());
        requestData.setRequestProtocol(request.getProtocol());
        requestData.setServerName(request.getServerName());
        requestData.setServerPortNumber(request.getServerPort());
        requestData.setServerCurrentLocale(request.getLocale());
        requestData.setQueryString(request.getQueryString());
        requestData.setQueryParameterValue(request.getParameter("queryParameter"));
        requestData.setUserAgentValue(request.getHeader("User-Agent"));

        request.setAttribute("requestData", requestData);

        String url = "/httpRequestData.jsp";

        RequestDispatcher dispatcher
        = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
