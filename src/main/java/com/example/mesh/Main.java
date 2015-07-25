package com.example.mesh;

import java.io.IOException;
import java.net.URI;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class Main {

    public static final String BASE_URI = "http://0.0.0.0:6374/";

    public static HttpServer startServer() {
        final ResourceConfig rc = new ResourceConfig()
                .packages(Main.class.getPackage().getName())
                .register(ObjectMapperProvider.class)
                .register(JacksonFeature.class);

        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    public static void main(final String[] args) throws IOException {
        final HttpServer server = startServer();
        System.out.println("Listening on " + BASE_URI);
        System.out.println("Press Enter to exit");
        System.in.read();
        server.shutdownNow();
    }
}
