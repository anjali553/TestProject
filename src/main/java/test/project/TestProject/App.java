package test.project.TestProject;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;

import test.project.TestProject.configuration.JpaConfiguration;


/**
 * Hello world!
 *
 */
@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages={"test.project.TestProject"})
public class App {
 
	  private static final Logger log = LoggerFactory.getLogger(App.class);

	    @Inject
	    private Environment env;
	
    public static void main(String[] args) {
        //SpringApplication.run(SpringBootCRUDApp.class, args);
    	SpringApplication app = new SpringApplication(App.class);
       
        Environment env = app.run(args).getEnvironment();
        try {
			log.info("Access URLs:\n----------------------------------------------------------\n\t" +
			    "Local: \t\thttp://127.0.0.1:{}\n\t" +
			    "External: \thttp://{}:{}\n----------------------------------------------------------",
			    env.getProperty("server.port"),
			    InetAddress.getLocalHost().getHostAddress(),
			    env.getProperty("server.port"));
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }

}



/*
 * Command to kill port
 * netstat -ano
 * taskkill -pid 431 /f*/
