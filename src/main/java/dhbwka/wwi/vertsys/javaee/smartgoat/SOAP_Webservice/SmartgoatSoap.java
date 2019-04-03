package dhbwka.wwi.vertsys.javaee.smartgoat.SOAP_Webservice;



import dhbwka.wwi.vertsys.javaee.smartgoat.common.ejb.UserBean;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@Stateless
@WebService(targetNamespace = "http://my.org/ns/")
public class SmartgoatSoap {

    @EJB
    private UserBean userBean;

    /**
     * Neuen Benutzer registrieren. Geht natürlich, ohne sich zuvor zu
     * authentifizieren. :-) Die Felder "username" und "password" werden
     * hierfür im SOAP-Body übertragen.
     */
    @WebMethod
    @WebResult(name = "status")
    public String signup(
            @WebParam(name = "username") String username,
            @WebParam(name = "password") String password,
            @WebParam(name = "firstname") String firstname,
            @WebParam(name = "lastname") String lastname,
            @WebParam(name = "email") String email
            )
            throws UserBean.UserAlreadyExistsException {

        this.userBean.signup(username, password,firstname,lastname, email);
        return "OK";
    }
    
    
    @WebMethod
    @WebResult(name = "status")
     public String validateUser(
             @WebParam(name = "username") String username,
             @WebParam(name = "password") String password
                )
             throws UserBean.InvalidCredentialsException, UserBean.AccessRestrictedException {
         this.userBean.validateUser(username, password);

        return "OK";
    }
    
    /**
     * Beispiel für eine geschützte Methode. Erfordert, dass der Client im
     * SOAP-Header die Felder "username" und "password" sendet.
     */
   /* @WebMethod
    @WebResult(name = "message")
    public String getSecretMessage(
            @WebParam(name = "username", header = true) String username,
            @WebParam(name = "password", header = true) String password)
            throws UserBean.InvalidCredentialsException,
                   UserBean.AccessRestrictedException {

        // Wirft eine Exception, wenn der Benutzer nicht berechtigt ist
        this.userBean.validateUser(username, password);

        // Der geschützte Code, den nicht jeder ausführen darf
        return "Streng geheim! For your eyes only!";

    }
    
    */
   
}

 