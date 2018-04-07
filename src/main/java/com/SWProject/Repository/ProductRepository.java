package com.SWProject.Repository;

import org.springframework.data.repository.CrudRepository;

import com.SWProject.Entities.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>  {

}
