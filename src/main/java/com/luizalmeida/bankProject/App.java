package com.luizalmeida.bankProject;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.luizalmeida.bankProject.model.Account;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        Account account = new Account();
        
        account.setNumber(1010);
        account.setBalance(1000.00);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bankProject");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        em.persist(account);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
}
