package dhbwka.wwi.vertsys.javaee.smartgoat.SOAP_Webservice;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



@Stateless
public class UserSoap {

    @PersistenceContext
    protected EntityManager em;

    /**
     * Registrieren eines neuen Benutzers
     */
    public void signup(String username, String password, String... groups)
            throws UserAlreadyExistsException {

        // Sicherstellen, dass es den Benutzer noch nicht gibt
        if (em.find(SOAP.class, username) != null) {
            throw new UserAlreadyExistsException("Der Benutzername existiert bereits.");
        }

        // Neuen Benutzer erzeugen
        SOAP soap = new SOAP(username, password);

        for (String group : groups) {
            soap.addToGroup(group);
        }

        em.persist(soap);
    }

    /**
     * Anmeldedaten eines Benutzers sowie Benutzergruppenzuordnung und Zugehörigkeit
     * zu einer der übergebenen Benutzergruppen prüfen.
     */
    public SOAP validateUser(String username, String password, String... groups)
            throws InvalidCredentialsException, AccessRestrictedException {

        // Benutzer suchen und Passwort prüfen
        SOAP soap = em.find(SOAP.class, username);
        boolean authorize = false;

        if (soap == null || !soap.checkPassword(password)) {
            throw new InvalidCredentialsException("Benutzername oder Passwort falsch.");
        }

        // Zugeordnete Benutzergruppen prüfen, mindestens eine muss vorhanden sein
        for (String group : groups) {
            if (soap.groups.contains(group)) {
                authorize = true;
                break;
            }
        }

        if (!authorize) {
            throw new AccessRestrictedException("Sie sind hierfür nicht berechtigt.");
        }

        // Alles okay!
        return soap;
    }

    //<editor-fold defaultstate="collapsed" desc="Exceptions">
    /**
     * Fehler: Der Benutzername ist bereits vergeben.
     */
    public class UserAlreadyExistsException extends Exception {

        public UserAlreadyExistsException(String message) {
            super(message);
        }
    }

    /**
     * Fehler: Anmeldedaten des Benutzers stimmen nicht
     */
    public class InvalidCredentialsException extends Exception {

        private InvalidCredentialsException(String benutzername_oder_Passwort_falsch) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
       
    }

    /**
     * Fehler: Benutzer besitzt nicht die erforderliche Benutzergruppe.
     */
    public class AccessRestrictedException extends Exception {

        private AccessRestrictedException(String sie_sind_hierfür_nicht_berechtigt) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
       
    }
    //</editor-fold>

}