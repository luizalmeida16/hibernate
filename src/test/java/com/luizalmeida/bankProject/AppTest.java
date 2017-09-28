package com.luizalmeida.bankProject;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.luizalmeida.bankProject.model.Account;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */

public class AppTest 
    extends TestCase
{
	private HttpServer server;
	
	@Before
	public void startServer(){
		server = Server.startServer("http://localhost:8080");
	}
	
	@Test
	public void testGetAccount() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080");
		String content = target.path("/account").request().get(String.class);
		Account account = new Gson().fromJson(content, Account.class);
		Assert.assertEquals(1000.0, account.getBalance());
	}
	
	@After
	public void after(){
		server.shutdownNow();
	}
	
}
