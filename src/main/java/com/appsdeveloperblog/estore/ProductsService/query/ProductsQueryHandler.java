package com.appsdeveloperblog.estore.ProductsService.query;

import java.util.ArrayList;
import java.util.List;

import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.appsdeveloperblog.estore.ProductsService.command.core.data.ProductEntity;
import com.appsdeveloperblog.estore.ProductsService.command.core.data.ProductsRepository;
import com.appsdeveloperblog.estore.ProductsService.query.rest.ProductRestModel;

@Component
public class ProductsQueryHandler {
	
	
		private final ProductsRepository productsRepository;

		public ProductsQueryHandler(ProductsRepository productsRepository) {
			this.productsRepository = productsRepository;
		}
		
		@QueryHandler
		public List<ProductRestModel> findProducts(FindProductsQuery query){
			List<ProductRestModel> productRest  = new ArrayList<>();

			List<ProductEntity> storedProducts = productsRepository.findAll();
			
			for(ProductEntity ent: storedProducts) {
				ProductRestModel productRestModel =  new ProductRestModel();
				BeanUtils.copyProperties(ent, productRestModel);
				productRest.add(productRestModel);
			}
			
			return productRest;
		}
		
			

}
