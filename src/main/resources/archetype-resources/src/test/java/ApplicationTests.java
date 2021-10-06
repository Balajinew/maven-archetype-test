package ${package};

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)

class ApplicationTests {

	@Test
	void contextLoads() {
	}
	
	 @Test
	    public void test()
	    {
	        Application.main(new String[]{
	                "--spring.main.web-environment=false",
	             
	        });
	    }

}
