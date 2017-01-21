package biz.letsweb.diary;

import biz.letsweb.diary.config.Configuration;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App {
    
    public static final Logger LOGGER = LoggerFactory.getLogger(App.class);
    
    public static void main(String[] args) throws ConfigurationException, InterruptedException {
        LOGGER.info("Logging hello world.");
        LOGGER.info("Configuration xml color: {}", Configuration.COLOR);
        LOGGER.info("Configuration xml color: {}", Configuration.TIME);
        System.out.println("Main Finished");
        Thread.sleep(40000);
    }
}
