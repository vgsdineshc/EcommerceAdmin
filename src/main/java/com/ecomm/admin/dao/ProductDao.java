package com.ecomm.admin.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomm.admin.pojo.Product;
import com.ecomm.admin.repo.ProductRepo;

@Service
public class ProductDao {

	@Autowired
	private ProductRepo productRepo;

	public List<Product> getListofProduct() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}

	public void saveProduct(Product product) {
		productRepo.save(product);
	}

	public void deleteProduct(Integer proId) {
		productRepo.deleteById(proId);
	}

	public Product getProduct(Integer proId) {

		Product product = productRepo.findById(proId).orElse(null);
		return product;
	}

	public void updateProduct(Product product) {
		Product product1 = productRepo.findById(product.getPid()).orElse(null);
		product1.setPname(product.getPname());
		product1.setCatagery(product.getCatagery());
		product1.setPrice(product.getPrice());
		productRepo.save(product1);
	}
	
}
