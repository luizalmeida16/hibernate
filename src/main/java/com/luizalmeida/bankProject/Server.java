package com.luizalmeida.bankProject;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * Hello world!
 *
 */
public class Server 
{
    public static void main( String[] args ) throws IOException
    {
        //System.in.read();
        //server.shutdownNow();
    	Server.startServer("http://localhost:8080");
    }
    
    public static HttpServer startServer(String url) {
    	ResourceConfig config = new ResourceConfig().packages("com.luizalmeida.bankProject");
        URI uri = URI.create(url);
        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri, config);
        System.out.println("Server running at: " + url);
        
        return server;
    }
    
}
