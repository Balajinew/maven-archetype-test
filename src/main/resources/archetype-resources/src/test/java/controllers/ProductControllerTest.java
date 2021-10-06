package ${package}.controllers;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ${package}.model.Product;
import ${package}.model.Response;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {

	@Autowired
	private ProductController controller;
	
	
	@Test
	public void testCreateProduct_success() throws Exception {
		 Product product = new Product();
			product.setProduct_name("samsung");
			product.setProduct_price("300");
			        
			Response response = controller.createProduct(product);
			
	        assertThat(response.getResponse()).isEqualTo("Success");


	}
	
	@Test
	public void testgetProduct_success() throws Exception {
		
			Product productData =  controller.getProduct();
			
	        assertThat(productData).isNotNull();


	}
}
