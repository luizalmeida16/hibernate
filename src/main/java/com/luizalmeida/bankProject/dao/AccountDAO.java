package com.luizalmeida.bankProject.dao;

import javax.persistence.EntityManager;

import com.luizalmeida.bankProject.model.Account;
import com.luizalmeida.bankProject.util.JPAUtil;

public class AccountDAO {
	private EntityManager em;
	
	public AccountDAO() {
		this.em = new JPAUtil().getEntityManager();
	}

	public Account create(Integer number, Double balance){
		Account account = new Account();
		
		account.setBalance(balance);
		account.setNumber(number);
        em.getTransaction().begin();
        em.persist(account);
        em.getTransaction().commit();
        em.close();
        
        return account;
	}
	
	public Account get(Long id){
		em.getTransaction().begin();
		Account account = em.find(Account.class, id);
		em.getTransaction().commit();
        em.close();
        
		return account;
	}
	
	public String delete(Long id) {
		em.getTransaction().begin();
		Account account = em.find(Account.class, id);
		em.remove(account);
		
		em.getTransaction().commit();
        em.close();
        String status = "deleted";
        
		return status;
	}

}
