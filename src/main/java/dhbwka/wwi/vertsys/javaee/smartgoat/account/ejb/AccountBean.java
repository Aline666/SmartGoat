/**
 * Error parsing included template file:///C:/Users/Nasi/Documents/DHBW/Kurse_19_SS/Verteilte%20Systeme/SmartGoat/Smartgoat/licenseheader.txt
 * Found unexpected directive: </#if> on line 7, column 1
 * Check whether you have a well-formed if-else block.
 * package dhbwka.wwi.vertsys.javaee.smartgoat.account.ejb;
 */

package dhbwka.wwi.vertsys.javaee.smartgoat.account.ejb;

import dhbwka.wwi.vertsys.javaee.smartgoat.common.ejb.EntityBean;
import dhbwka.wwi.vertsys.javaee.smartgoat.tasks.jpa.Category;
import dhbwka.wwi.vertsys.javaee.smartgoat.tasks.jpa.Task;
import dhbwka.wwi.vertsys.javaee.smartgoat.tasks.jpa.TaskStatus;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


@Stateless
@RolesAllowed({"app-user", "admin"})
public class AccountBean extends EntityBean<Task, Long> {
     public AccountBean() {
        super(Task.class);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
