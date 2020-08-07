package java112.project4;


import java.io.*;
import java.util.*;

import java112.analyzer.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


/**
 * This servlet is used to upload the selected file, and download it to the
 * /tmp directory.
 *
 * @author Steve McNatt
 */
@WebServlet(
name = "analyzerGetInputServlet",
urlPatterns = {"/analyzer-get-input"}
) @MultipartConfig
public class AnalyzerGetInputServlet extends HttpServlet {

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
        System.out.println("In AnalyzerGetInputServlet");
        response.setContentType("text/html;charset=UTF-8");

        ServletContext context = getServletContext();

        Properties properties =
                    (Properties) context.getAttribute("project4AnalyzerProperties");

        // Create path components to save the file
        String outputPath = properties.getProperty("output.dir");
        Part filePart = request.getPart("inputFile");
        String fileName = getFileName(filePart);
        System.out.println("Output path: " + outputPath);
        System.out.println("Input file: " + fileName);

        OutputStream outFile = null;
        InputStream filecontent = null;

        try {
            outFile = new FileOutputStream(new File(outputPath + fileName));
            filecontent = filePart.getInputStream();

            int read = 0;
            final byte[] bytes = new byte [1024];

            while ((read = filecontent.read(bytes)) != -1) {
                outFile.write(bytes, 0, read);
            }
            System.out.println("New file " + fileName + " created at " + outputPath);

            AnalyzeFile analyzer = new AnalyzeFile();

            String[] arguments = new String [2];

            arguments[0] = outputPath + fileName;
            arguments[1] = "/project4_analyzer.properties";

            analyzer.runAnalysis(arguments);

            String outputFile = "file://" + properties.getProperty("output.dir")
                                    + properties.getProperty("output.file.summary");

            context.setAttribute("outputFile", outputFile);

            String url = "/java112/analyzerShowOutput.jsp";

            response.sendRedirect(url);
        } catch (FileNotFoundException fileNotFound) {
            System.out.println("File not specified, file not found, or file is protected");
            fileNotFound.printStackTrace();
        } finally {
            if (outFile != null) {
                outFile.close();
            }


            if (filecontent != null) {
                filecontent.close();
            }
        }
    }


    private String getFileName(final Part part) {

        String partHeader = part.getHeader("content-disposition");

        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}
