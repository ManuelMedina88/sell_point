package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.app.models.Entities.Product;
import com.bolsadeideas.springboot.app.models.dao.IProductDao;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductDao productDao;
	
	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return (List<Product>)productDao.findAll();
	}

	@Override
	public void save(Product product) {
		// TODO Auto-generated method stub
		
			productDao.save(product);

	}

	@Override
	public Product findById(Long id) {
		// TODO Auto-generated method stub
		return productDao.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		productDao.deleteById(id);

	}

}
