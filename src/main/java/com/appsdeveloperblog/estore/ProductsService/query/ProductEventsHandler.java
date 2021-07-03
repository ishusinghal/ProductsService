package com.appsdeveloperblog.estore.ProductsService.query;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.appsdeveloperblog.estore.ProductsService.command.core.data.ProductEntity;
import com.appsdeveloperblog.estore.ProductsService.command.core.data.ProductsRepository;
import com.appsdeveloperblog.estore.ProductsService.command.core.events.ProductCreatedEvent;

@Component
public class ProductEventsHandler {

	private final ProductsRepository productRepository;

	public ProductEventsHandler(ProductsRepository productRepository) {
		this.productRepository = productRepository;
	}

	@EventHandler
	public void on(ProductCreatedEvent event) {
		ProductEntity productEntity = new ProductEntity();
		BeanUtils.copyProperties(event, productEntity);

		productRepository.save(productEntity);
	}

}
