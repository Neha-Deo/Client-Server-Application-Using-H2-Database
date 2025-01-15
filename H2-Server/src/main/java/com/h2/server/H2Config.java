package com.h2.server;

import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

@Configuration
public class H2Config {

    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server getH2Server() throws SQLException {
        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9090");
    }

    /*
    A Spring Bean that configures and manages an H2 database server instance.

    @Bean annotation indicates that Mark this method as a Spring Bean.

    initMethod = "start":
        When the Spring context initializes the bean, it calls the start() method of the
        Server object to start the H2 database server.

    destroyMethod = "stop":
        When the Spring context shuts down, it calls the stop() method to properly close the H2 server.

    Server.createTcpServer():
        The returned object is of type Server which is managed by the Spring IoC container.
        Creates server instance that listens for TCP connections.
            -tcp: Enables TCP-based access
            -tcpAllowOthers: Allows remote connections to the H2 database server
            -tcpPort, 9090: Specifies the port number for the H2 database server to listen on.

    throws SQLException:
        This indicates that the method may throw an SQLException during the creation of the H2 server instance.
    */
}
