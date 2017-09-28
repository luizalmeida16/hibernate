package com.luizalmeida.bankProject.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.luizalmeida.bankProject.dao.AccountDAO;
import com.luizalmeida.bankProject.model.Account;

@Path("account")
public class AccountController {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String get(@QueryParam("id") long id){
		Account account = new AccountDAO().get(id);
		
		return account.toJson();
	}
	
	@GET
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	public String create(@QueryParam("number") int number, @QueryParam("balance") double balance) {
		AccountDAO account = new AccountDAO();
		Account res = account.create(number, balance);
		System.out.println("Access the create");
		
		return res.toJson();
	}
	
	@GET
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public String delete(@QueryParam("id") long id){
		String status = new AccountDAO().delete(id);
		
		return status;
	}
	
	
	
}
