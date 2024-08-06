package com.study.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

@Service
public class LoggingRunner implements ApplicationRunner{
	
																//여기에 쓰는 클래스는 로그를 보고 싶은 클래스를 적는다.
//	private static final Logger logger = LoggerFactory.getLogger(LoggingRunner.class);  
//	원래는 위에처럼 쓰는건데 생략해도 쓸 수 있게 얘가 알아서 인식한다.
	
	Logger LOGGER = LoggerFactory.getLogger(LoggingRunner.class);
	
	@Override
	public void run(ApplicationArguments args) throws Exception {

		LOGGER.trace("Trace 레벨 로그");
		LOGGER.debug("Debug 레벨 로그");
		LOGGER.info("Info 레벨 로그");
		LOGGER.warn("Warn 레벨 로그");
		LOGGER.error("Error 레벨 로그");
	}

}
