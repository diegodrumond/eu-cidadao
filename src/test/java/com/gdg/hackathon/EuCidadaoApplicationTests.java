package com.gdg.hackathon;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gdg.hackathon.eucidadao.application.EuCidadaoApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = EuCidadaoApplication.class)
@WebAppConfiguration
public class EuCidadaoApplicationTests {

	@Test
	public void contextLoads() {
	}

}
