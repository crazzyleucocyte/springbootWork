package com.study.springboot.multi;

import org.springframework.stereotype.Component;

@Component("printera")
public class PrinterA implements Printer {

	@Override
	public void print(String msg) {
		System.out.println("PrinterA : "+msg);
		
	}

}
