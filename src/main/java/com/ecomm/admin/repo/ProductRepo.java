package com.ecomm.admin.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomm.admin.pojo.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

}
