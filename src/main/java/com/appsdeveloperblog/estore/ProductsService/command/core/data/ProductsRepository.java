package com.appsdeveloperblog.estore.ProductsService.command.core.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<ProductEntity, String> {

	ProductEntity findByProductId(String productId);

	ProductEntity findByProductIdOrTitle(String productId, String title);

}
