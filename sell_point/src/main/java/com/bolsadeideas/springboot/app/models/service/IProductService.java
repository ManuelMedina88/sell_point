package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import com.bolsadeideas.springboot.app.models.Entities.Product;

public interface IProductService {

	public abstract List<Product> findAll();
	
	public abstract void save(Product product);
	
	public abstract Product findById(Long id);
	
	public abstract void deleteById(Long id);
}
