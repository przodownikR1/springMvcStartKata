package pl.java.borowiec.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerTest {

	private static final Logger logger = LoggerFactory.getLogger(LoggerTest.class);
    @Test
	public void loggerTest(){
		logger.info("logger test");
	}
	
}
