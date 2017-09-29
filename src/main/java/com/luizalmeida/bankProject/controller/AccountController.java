package com.luizalmeida.bankProject.controller;

import java.net.URI;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.Uri;

import com.google.gson.Gson;
import com.luizalmeida.bankProject.dao.AccountDAO;
import com.luizalmeida.bankProject.model.Account;

@Path("accounts")
public class AccountController {
	
	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String get(@PathParam("id") long id){
		Account account = new AccountDAO().get(id);
		
		return account.toJson();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(String content) {
		Account data = new Gson().fromJson(content, Account.class);
		AccountDAO accountDAO = new AccountDAO();
		data = accountDAO.create(data.getNumber(), data.getBalance());
		System.out.println("Access the create");
		URI uri = URI.create("/accounts/" + data.getId());
		return Response.created(uri).build();
	}
	
	@GET
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public String delete(@QueryParam("id") long id){
		String status = new AccountDAO().delete(id);
		
		return status;
	}
	
	
	
}
