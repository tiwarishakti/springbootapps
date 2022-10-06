package com.example.ecommwebapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.example.ecommwebapp.dto.Product;
import com.example.ecommwebapp.entity.ShoppingCart;
import com.example.ecommwebapp.repository.ShoppingCartRepository;

@Controller
@RequestMapping("/cart")
public class ShoppingCartController {

	@Autowired
	private ShoppingCartRepository repo;
	
	private RestTemplate restTemplate = new RestTemplate();
	
	@RequestMapping(value="/showcart", method=RequestMethod.GET)
	public String showAddCartPage(ModelMap model) {
		model.addAttribute("cartproducts", repo.findAll());
		List<Product> products = (List<Product>) restTemplate.getForObject("http://localhost:8081/products", List.class);
		model.addAttribute("products", products);
		return "showAddCart";
	}
	
	@RequestMapping(value="/addtocart", method=RequestMethod.POST)
	public String addToCart(@ModelAttribute("shoppingCart") ShoppingCart cart, ModelMap model) {
		repo.save(cart);
		List<Product> products = (List<Product>) restTemplate.getForObject("http://localhost:8081/products", List.class);
		model.addAttribute("products", products);
		return "showAddCart";

	}
	
}