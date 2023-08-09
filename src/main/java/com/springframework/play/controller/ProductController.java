package com.springframework.play.controller;

import com.springframework.play.dto.ProductDTO;
import com.springframework.play.exception.ObjectAlreadyExistsException;
import com.springframework.play.model.Brand;
import com.springframework.play.model.Product;
import com.springframework.play.services.BrandService;
import com.springframework.play.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private BrandService brandService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView showProductsPage() {
        ModelAndView model = new ModelAndView("products");

        List<Product> products = productService.findAllProducts();
        List<Brand> brands = brandService.findAllBrands();

        model.addObject("products", products);
        model.addObject("brands", brands);

        return model;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView saveProduct(@Valid ProductDTO productDTO, BindingResult bindingResult) {

        ModelAndView model = new ModelAndView("products");

        if (!bindingResult.hasErrors()) {
            try {
                Product savedProduct = productService.saveProduct(productDTO);
                model.addObject("savedProduct", savedProduct);
                cleanFields(productDTO);
            } catch (ObjectAlreadyExistsException ex) {
                ObjectError error = new ObjectError("err", ex.getMessage());
                bindingResult.addError(error);
            }

        }

        List<Product> products = productService.findAllProducts();
        List<Brand> brands = brandService.findAllBrands();

        model.addObject("products", products);
        model.addObject("brands", brands);

        return model;
    }

    public void cleanFields(ProductDTO productDTO) {
        productDTO.setBarCode("");
        productDTO.setName("");
        productDTO.setBrandId(null);
        productDTO.setPrice(null);
    }

    @ExceptionHandler(SQLException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleException(Exception exception) {
        return "error";
    }

    @ModelAttribute(value = "productDTO")
    public ProductDTO getProductDTO() {
        return new ProductDTO();
    }

}
