package ${package}.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import ${package}.model.Product;
import ${package}.model.Response;
import ${package}.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Product Controller")
@RestController
@RequestMapping("/api")
public class ProductController {
	Logger logger = LogManager.getLogger(ProductController.class);

	@Autowired
	private ProductService service;


	@RequestMapping(value = "/products/create", method = RequestMethod.POST)
	@ApiOperation(value = "Create Product", notes = "Create Product in DB", response = Response.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success|OK"),
			@ApiResponse(code = 401, message = "Not Authorized!"), @ApiResponse(code = 403, message = "Forbidden!"),
			@ApiResponse(code = 404, message = "Not Found!") })
	public Response createProduct(@RequestBody Product product) {
		logger.info("Request reached to CreateProduct Service");
		Response output = new Response();
		output.setResponse(service.createProduct(product));
		logger.info("CreateProduct Service End");
		return output;
	}

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	@ApiOperation(value = "Get Product", notes = "Get Products from DB", response = Product.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success|OK"),
			@ApiResponse(code = 401, message = "Not Authorized!"), @ApiResponse(code = 403, message = "Forbidden!"),
			@ApiResponse(code = 404, message = "Not Found!") })
	public Product getProduct() {
		logger.info("Request reached to getProduct Service");
		return service.getProduct();

	}

	

}
