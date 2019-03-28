/**
package dhbwka.wwi.vertsys.javaee.smartgoat.account.ejb;

import dhbwka.wwi.vertsys.javaee.smartgoat.account.jpa.Account;
import dhbwka.wwi.vertsys.javaee.smartgoat.common.ejb.EntityBean;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

    @PersistenceContext
    protected EntityManager em;
    
    /**
     * @return Liste mit allen Nutzereinträgen
     */
   /** public List<Account> findAllEntries() {
        return em.createQuery("SELECT e FROM Account e ")
                .getResultList();
    }

    /*public void createNewEntry(String name) {
        Account entry = new Account(name);
        em.persist(entry);
        return em.merge(entry);
    }*/
/*
}
*/