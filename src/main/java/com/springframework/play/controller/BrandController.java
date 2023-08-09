package com.springframework.play.controller;

import com.springframework.play.dto.BrandDTO;
import com.springframework.play.exception.ObjectAlreadyExistsException;
import com.springframework.play.model.Brand;
import com.springframework.play.services.BrandService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    BrandService brandService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView showBrandsPage() {
        ModelAndView model = new ModelAndView("brands");

        List<Brand> brands = brandService.findAllBrands();

        model.addObject("brands", brands);

        return model;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView saveBrand(@Valid BrandDTO brandDTO, BindingResult bindingResult) {

        ModelAndView model = new ModelAndView("brands");

        if (!bindingResult.hasErrors()) {
            try {
                Brand savedBrand = brandService.saveBrand(brandDTO);
                model.addObject("savedBrand", savedBrand);
                cleanFields(brandDTO);
            } catch (ObjectAlreadyExistsException ex) {
                ObjectError error = new ObjectError("err", ex.getMessage());
                bindingResult.addError(error);
            }
        }

        List<Brand> brands = brandService.findAllBrands();

        model.addObject("brands", brands);

        return model;
    }

    public void cleanFields(BrandDTO brandDTO) {
        brandDTO.setName("");
    }

    @ModelAttribute(value = "brandDTO")
    public BrandDTO getBrandDTO() {
        return new BrandDTO();
    }


}
