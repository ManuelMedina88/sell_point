package com.bolsadeideas.springboot.app.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bolsadeideas.springboot.app.models.Entities.Product;
import com.bolsadeideas.springboot.app.models.service.IProductService;

@Controller
@RequestMapping("/product")
@SessionAttributes("product")
public class ProductController {

	@Autowired
	private IProductService productService;
	
	@GetMapping("/list")
	public String list(Model model) {
		
		List<Product> products = productService.findAll();
		model.addAttribute("title", "List of products register");
		model.addAttribute("products", products);
		return "list";
	}
	
	@GetMapping("/form/{id}")
	public String editar(@PathVariable Long id, Model model) {
		
		Product product = productService.findById(id);
		model.addAttribute("title","Editing Products");
		model.addAttribute("product", product);
		return "/form";
	}
	
	@GetMapping("/form")
	public String create(Model model) {
		
		Product product = new Product();
		model.addAttribute("title","Register Products");
		model.addAttribute("product", product);
		return "/form";
	}
	
	@PostMapping("/form")
	public String save(@Valid @ModelAttribute(name="product")Product product,BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			
			model.addAttribute("titulo", "Registering Products");
			return "/form";
			
		}
		
		productService.save(product);
		
		return "redirect:/product/list";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id, Model model) {
		
		productService.deleteById(id);
		
		return "redirect:/product/list";
	}
}
