package dhbwka.wwi.vertsys.javaee.smartgoat.account.profil;


import dhbwka.wwi.vertsys.javaee.smartgoat.common.ejb.UserBean;
import dhbwka.wwi.vertsys.javaee.smartgoat.common.ejb.ValidationBean;
import dhbwka.wwi.vertsys.javaee.smartgoat.common.jpa.User;
import dhbwka.wwi.vertsys.javaee.smartgoat.common.web.FormValues;
import dhbwka.wwi.vertsys.javaee.smartgoat.common.web.WebUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet(urlPatterns = {"/app/profil/edit/pw/"})
public class ProfilEditPasswort extends HttpServlet {

    @EJB
    ValidationBean validationBean;
    
    @EJB
    UserBean userBean;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Anfrage an die JSP weiterleiten
        request.getRequestDispatcher("/WEB-INF/benutzerkonto/benutzerkonto_edit_Pw.jsp").forward(request, response);
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
    private void saveChanges(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String pwOld = request.getParameter("pw_old");
        String pwNew1 = request.getParameter("pw_new1");
        String pwNew2 = request.getParameter("pw_new2");
        
       // User user = userBean.getCurrentUser();
        
        
        
        // Eingaben prüfen
        User user = userBean.getCurrentUser();
        List<String> errors = new ArrayList<String>();
        
        if(!user.checkPassword(pwOld)){
            errors.add("Passwort ist falsch!");
        }
        
        user.setPassword(pwNew1);
        validationBean.validate(user.getPassword(), errors);
        
        if (pwNew1 != null && pwNew2 != null && !pwNew1.equals(pwNew2)) {
            errors.add("Passwörter stimmen nicht überein!");
        }
        
        
        
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