package isep.web.sakila.webapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SakilaBusinessWebapiApplication.class)
public class SakilaBusinessWebapiApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println("TEST COUCOU");
	}

}
