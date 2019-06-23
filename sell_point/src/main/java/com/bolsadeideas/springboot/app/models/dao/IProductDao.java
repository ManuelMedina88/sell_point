package com.bolsadeideas.springboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bolsadeideas.springboot.app.models.Entities.Product;

@Repository
public interface IProductDao extends CrudRepository<Product, Long>{

}
