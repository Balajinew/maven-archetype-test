package ${package}.service;



import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ${package}.model.Product;
import ${package}.repositorys.ProductRepository;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductServiceImplTest {

	@Mock
	private ProductRepository repository;

	@Autowired
	private ProductService service;
	@Test
	public void testCreateProduct_success() throws Exception {
		 Product product = new Product();
			product.setProduct_name("samsung");
			product.setProduct_price("300");
			        
			String productData = service.createProduct(product);
			
	        assertThat(productData).isEqualTo("Success");


	}

	@Test
	public void testCreateProduct_failure() throws Exception {
		 Product product = new Product();
			product.setProduct_name("samsung");
			        
			String productData = service.createProduct(product);
			
			assertThat(productData).isEqualTo("Failure");

	}
	
	@Test
	public void testCreateProduct_failure_withemptyname() throws Exception {
		 Product product = new Product();
			product.setProduct_price("200");
			        
			String productData = service.createProduct(product);
			
			assertThat(productData).isEqualTo("Failure");

	}
	
	@Test
	public void testgetProduct_success() throws Exception {
		
			Product productData =  service.getProduct();
			
	        assertThat(productData).isNotNull();


	}

}