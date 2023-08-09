package com.springframework.play.services;

import com.springframework.play.dto.ProductDTO;
import com.springframework.play.exception.ObjectAlreadyExistsException;
import com.springframework.play.model.Brand;
import com.springframework.play.model.Product;
import com.springframework.play.repository.BrandRepository;
import com.springframework.play.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BrandRepository brandRepository;

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Product saveProduct(ProductDTO productDTO) throws ObjectAlreadyExistsException {
        Brand brand = brandRepository.findBrandByBrandId(productDTO.getBrandId());

        Optional<Product> product = Optional.ofNullable(productRepository.findProductByBarCode(productDTO.getBarCode()));

        if (product.isPresent()) {
            throw new ObjectAlreadyExistsException("Código de barras já cadastrado para outro produto!");
        }

        Product newProduct = Product.builder()
                .barCode(productDTO.getBarCode())
                .name(productDTO.getName())
                .price(productDTO.getPrice())
                .brand(brand)
                .build();

        return productRepository.save(newProduct);
    }

    public void updateProduct(ProductDTO productDTO, Long productId) {
        Product product = productRepository.findProductByProductId(productId);

        product.setBarCode(product.getBarCode());
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());

        if (!productDTO.getBrandId().equals(product.getBrand().getBrandId())) {
            Brand brand = brandRepository.findBrandByBrandId(productDTO.getBrandId());
            product.setBrand(brand);
        }

        productRepository.save(product);
    }

    public void deleteProduct(Long productId) {
        Product product = productRepository.findProductByProductId(productId);
        productRepository.delete(product);
    }

}
