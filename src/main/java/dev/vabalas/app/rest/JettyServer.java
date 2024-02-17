package dev.vabalas.app.rest;

import dev.vabalas.salescase.rest.CaseResource;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JettyServer {

    public static void start() {
        try {
            final var resourceConfig = new ResourceConfig(CaseResource.class);
            final var server = JettyHttpContainerFactory.createServer(URI.create("http://localhost:8080/"), resourceConfig);

            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                try {
                    System.out.println("Shutting down the application...");
                    server.stop();
                    System.out.println("Done, exit.");
                } catch (Exception e) {
                    Logger.getLogger(JettyServer.class.getName()).log(Level.SEVERE, null, e);
                }
            }));

            System.out.println("Application started");

            // block and wait shut down signal, like CTRL+C
            Thread.currentThread().join();
        } catch (InterruptedException ex) {
            Logger.getLogger(JettyServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
