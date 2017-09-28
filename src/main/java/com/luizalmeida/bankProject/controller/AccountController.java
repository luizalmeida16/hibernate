package com.luizalmeida.bankProject.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.luizalmeida.bankProject.dao.AccountDAO;
import com.luizalmeida.bankProject.model.Account;

@Path("account")
public class AccountController {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String get(){
		Account account = new AccountDAO().get(1);
		
		return account.toJson();
	}
	
}
