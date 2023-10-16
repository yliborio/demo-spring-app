package com.yliborio.demospring;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class DemoSpringApplicationTests {

	@Test
	void contextLoads() {
	}


	@Test
	public void appStarts() {
		DemoSpringApplication.main(new String[] {});
	}

}
