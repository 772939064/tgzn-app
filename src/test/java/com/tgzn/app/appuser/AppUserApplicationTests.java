package com.tgzn.app.appuser;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class AppUserApplicationTests {

	@Test
	public void contextLoads() {
		DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE_TIME;
		LocalDateTime ldt = LocalDateTime.now();

		String strDate = ldt.format(dtf);
		System.out.println(strDate);

		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
		String strDate2 = dtf2.format(ldt);
		System.out.println(strDate2);

	}

}
