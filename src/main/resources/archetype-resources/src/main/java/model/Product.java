package ${package}.model;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;


@Component
@Table(name="product")
@Entity
public class Product {
	
@Id
@GeneratedValue
	private int id;
	
	private String product_name;
	
	@NotNull
	private String product_price;

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_price() {
		return product_price;
	}

	public void setProduct_price(String product_price) {
		this.product_price = product_price;
	}

	
}
