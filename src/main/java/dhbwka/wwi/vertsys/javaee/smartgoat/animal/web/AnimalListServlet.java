/**
 * Error parsing included template file:///C:/Users/Nasi/Documents/DHBW/Kurse_19_SS/Verteilte%20Systeme/SmartGoat/Smartgoat/licenseheader.txt
 * Found unexpected directive: </#if> on line 7, column 1
 * Check whether you have a well-formed if-else block.
 * package dhbwka.wwi.vertsys.javaee.smartgoat.animal.web;
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nasi
 */


@WebServlet(name = "AnimalListServlet", urlPatterns = {"/AnimalListServlet"})
public class AnimalListServlet extends HttpServlet {
    
    //@EJB
    //AnimalBean animalBean;
    
    /**
     * Liste aller Tiere anzeigen.
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //request.setAttribute("tiere", this.animalBean.findAll());
        //request.getRequestDispatcher("/WEB-INF/list.jsp").forward(request, response);
    }
}