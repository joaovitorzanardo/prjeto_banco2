package com.springframework.play.repository;

import com.springframework.play.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    public Product findProductByProductId(Long productId);

    public Product findProductByBarCode(String barCode);

}
