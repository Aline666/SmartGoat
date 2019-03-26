
package dhbwka.wwi.vertsys.javaee.smartgoat.account.ejb;

import dhbwka.wwi.vertsys.javaee.smartgoat.account.jpa.Account;
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
public class AccountBean extends EntityBean<Account, Long> {
     public AccountBean() {
        super(Account.class);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
