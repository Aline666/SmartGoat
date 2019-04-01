package dhbwka.wwi.vertsys.javaee.smartgoat.SOAP_Webservice;


import dhbwka.wwi.vertsys.javaee.smartgoat.common.jpa.User;
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
        if (em.find(User.class, username) != null) {
            throw new UserAlreadyExistsException("Der Benutzername existiert bereits.");
        }

        // Neuen Benutzer erzeugen
        User user = new User(username, password);

        for (String group : groups) {
            user.addToGroup(group);
        }

        em.persist(user);
    }

    /**
     * Anmeldedaten eines Benutzers sowie Benutzergruppenzuordnung und Zugehörigkeit
     * zu einer der übergebenen Benutzergruppen prüfen.
     */
    public User validateUser(String username, String password, String... groups)
            throws InvalidCredentialsException, AccessRestrictedException {

        // Benutzer suchen und Passwort prüfen
        User user = em.find(User.class, username);
        boolean authorize = false;

        if (user == null || !user.checkPassword(password)) {
            throw new InvalidCredentialsException("Benutzername oder Passwort falsch.");
        }

        // Zugeordnete Benutzergruppen prüfen, mindestens eine muss vorhanden sein
           for (String group : groups) {
            if (user.getGroups().contains(group)) {
                authorize = true;
                break;
            }
        }

        if (!authorize) {
            throw new AccessRestrictedException("Sie sind hierfür nicht berechtigt.");
        }

        // Alles okay!
        return user;
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

        private InvalidCredentialsException(String message) {
            super(message);
        }
       
    }

    /**
     * Fehler: Benutzer besitzt nicht die erforderliche Benutzergruppe.
     */
    public class AccessRestrictedException extends Exception {

        private AccessRestrictedException(String message) {
            super(message);
        }
       
    }
    //</editor-fold>

}