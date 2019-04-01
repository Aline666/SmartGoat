/**
 * Servlet für die Benutzerdaten bearbeiten
 */

import dhbwka.wwi.vertsys.javaee.smartgoat.common.ejb.UserBean;
import dhbwka.wwi.vertsys.javaee.smartgoat.common.ejb.ValidationBean;
import dhbwka.wwi.vertsys.javaee.smartgoat.common.jpa.User;
import dhbwka.wwi.vertsys.javaee.smartgoat.common.web.FormValues;
import dhbwka.wwi.vertsys.javaee.smartgoat.common.web.WebUtils;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = {"/app/profil/edit/"})
public class ProfilDatenBearbeiten extends HttpServlet {

    @EJB
    ValidationBean validationBean;
    
    @EJB
    UserBean userBean;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        User user = userBean.getCurrentUser();
        request.setAttribute("user", user);
        
        // Anfrage an die JSP weiterleiten
        request.getRequestDispatcher("/WEB-INF/benutzerkonto/benutzerkonto_edit.jsp").forward(request, response);
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Angeforderte Aktion ausführen
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "save":
                saveChanges(request, response);
                break;
        }
    }
    
    /**
     * Updatet den aktuellen User mit dem übermittelten Werten.
     * @param request
     * @param response
     * @throws IOException 
     */
    private void saveChanges(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        
        String benutzerkontoFirstname = request.getParameter("profil_vorname");
        String benutzerkontoLastname = request.getParameter("profil_nachname");
        String benutzerkontoEmail = request.getParameter("profil_email");
        
        User user = userBean.getCurrentUser();
        
        user.setFirstname(benutzerkontoFirstname);
        user.setLastname(benutzerkontoLastname);
        user.setEmail(benutzerkontoEmail);
        
        // Eingaben prüfen
        List<String> errors = this.validationBean.validate(user);
       // this.validationBean.validate(user.getPassword(), errors);
        
        
        if (errors.isEmpty()) {
            userBean.update(user);
            response.sendRedirect(WebUtils.appUrl(request, "/app/profil/"));
        }else{
            // Fehler: Formuler erneut anzeigen
            FormValues formValues = new FormValues();
            formValues.setValues(request.getParameterMap());
            formValues.setErrors(errors);
            
            HttpSession session = request.getSession();
            session.setAttribute("profil_form", formValues);
            
            response.sendRedirect(request.getRequestURI());
        }
        
    }
    
}