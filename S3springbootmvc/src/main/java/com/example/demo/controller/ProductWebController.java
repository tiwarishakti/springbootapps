package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Product;
import com.example.demo.exceptions.ProductNotFoundException;
import com.example.demo.repository.ProductRepository;

@Controller
@RequestMapping("/products")
public class ProductWebController {

	@Autowired
	ProductRepository repo;
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String showAddProductPage(ModelMap model) {
		model.addAttribute("products", repo.findAll());
		return "addproduct";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String createProduct(@ModelAttribute("product") Product product, ModelMap model) {
		Product savedProduct = repo.save(product);
		model.addAttribute("products", repo.findAll());
		return "addproduct";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	@ResponseBody
	public String getOneProduct(@PathVariable("id") int id) {
		Optional<Product> optProduct = repo.findById(id);
		if (optProduct.isEmpty()) {
			throw new ProductNotFoundException(id);
		}
		return optProduct.get().toString();
	}
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String showUpdateProductPage() {
		return "updateproduct";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String updateProduct(@ModelAttribute("product") Product uiProduct, ModelMap model) {
		Optional<Product> optProduct = repo.findById(uiProduct.getId());
		if (optProduct.isEmpty()) {
			throw new ProductNotFoundException(uiProduct.getId());
		}
		Product dbProduct = optProduct.get();
		dbProduct.setName(uiProduct.getName());
		dbProduct.setDescription(uiProduct.getDescription());
		dbProduct.setPrice(uiProduct.getPrice());
		repo.save(dbProduct);
		model.addAttribute("products", repo.findAll());
		return "addproduct";
	}
	
}
