package ${package}.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ${package}.model.Product;
import ${package}.repositorys.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	Logger logger = LogManager.getLogger(ProductServiceImpl.class);

	@Autowired
	ProductRepository repository;

	@Override
	public String createProduct(Product product) {
		logger.info("CreateProduct Service Implementation");
		if (product.getProduct_name() != null && product.getProduct_price() != null) {
			logger.debug("Service ready to persist data in repository");

			repository.save(product);
			return "Success";
		}

		else {
			logger.info("CreateProduct Service persistence failed");

			return "Failure";
		}
	}

	@Override
	public Product getProduct() {
		logger.info("getProduct Service Implementation");

		List<Product> productList = (List<Product>) repository.findAll();

		Product result = productList.get(0);
		return result;
	}
}
