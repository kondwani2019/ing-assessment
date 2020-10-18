package com.ing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The job of this app is to Read from a Database and publish to the Notification Engine
 * @author kondwani
 *
 */
@SpringBootApplication(scanBasePackages={"com.ing"})
public class IngUserManagementApplication {
    public static void main( String[] args ) {
    	SpringApplication.run(IngUserManagementApplication.class, args);
    }
}
