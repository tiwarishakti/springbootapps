package com.example.ecommwebapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.ecommwebapp.entity.ShoppingCart;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Integer>{

}