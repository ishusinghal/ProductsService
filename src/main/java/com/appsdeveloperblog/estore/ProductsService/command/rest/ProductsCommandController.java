package com.appsdeveloperblog.estore.ProductsService.command.rest;

import java.util.UUID;

import javax.validation.Valid;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appsdeveloperblog.estore.ProductsService.command.CreateProductCommand;

@RestController
@RequestMapping("/products")
public class ProductsCommandController {

	private final Environment env;
	private final CommandGateway commandGateway;
	
	@Autowired
	public ProductsCommandController(Environment env, CommandGateway commandGateway) {
		this.env = env;
		this.commandGateway = commandGateway;
	}

//	@GetMapping
//	public String getProducts() {
//		return "HTTP GET HANDLED" + env.getProperty("local.server.port");
//	}

	@PostMapping
	public String createProduct(@Valid @RequestBody CreateProductRestModel createProductRestModel) {
		CreateProductCommand createProductCommand = CreateProductCommand.builder().price(createProductRestModel.getPrice()).quantity(createProductRestModel.getQuantity())
		.title(createProductRestModel.getTitle()).productId(UUID.randomUUID().toString()).build();
		
		String returnValue;
		  try {
			returnValue = commandGateway.sendAndWait(createProductCommand);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			returnValue = e.getLocalizedMessage();
		}
		
		return returnValue;
	}

//	@PutMapping
//	public String updateProduct() {
//		return "HTTP PUT HANDLED";
//	}
//
//	@DeleteMapping
//	public void deleteProduct() {
//		System.out.println("deleted");
//	}

}
