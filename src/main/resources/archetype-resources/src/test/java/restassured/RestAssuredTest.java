package ${package}.restassured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ${package}.model.Product;

import io.restassured.RestAssured;
import io.restassured.response.Response;




@Component
public class RestAssuredTest {
	
	 @BeforeClass
	    public static void before() throws Exception {
		 
	 }

@Test
public void givenUrl_whenSuccess_productCreation() throws JsonParseException, JsonMappingException, FileNotFoundException, IOException {
	ObjectMapper mapper = new ObjectMapper();
	RestAssured.baseURI  = "http://localhost:8080" + "/api/products/create";
	Product body = mapper.readValue(new FileInputStream("src/test/resources/product.json"),Product.class);
	  Response response =given().
	contentType("application/json").
	body(body).
when().
				post().then().
	extract().response();
response.then().statusCode(200).assertThat().body("response",
            equalTo("Success"));	
}
@Test
public void givenUrl_whenSuccess_productget() throws JsonParseException, JsonMappingException, FileNotFoundException, IOException {
	ObjectMapper mapper = new ObjectMapper();
	RestAssured.baseURI  = "http://localhost:8080" + "/api/products";
	Product body = mapper.readValue(new FileInputStream("src/test/resources/product.json"),Product.class);
	  Response response =given().
	contentType("application/json").
	body(body).
when().
				get().then().
	extract().response();
response.then().statusCode(200).assertThat().body("size()", greaterThan(0));
}
}
