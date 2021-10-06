package ${package}.repositorys;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import ${package}.model.Product;

@Component
public interface ProductRepository extends CrudRepository<Product, Integer>{
	


}
