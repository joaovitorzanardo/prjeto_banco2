package com.springframework.play.services;

import com.springframework.play.dto.BrandDTO;
import com.springframework.play.exception.ObjectAlreadyExistsException;
import com.springframework.play.model.Brand;
import com.springframework.play.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService {

    @Autowired
    BrandRepository brandRepository;

    public List<Brand> findAllBrands() {
        return brandRepository.findAll();
    }

    public Brand saveBrand(BrandDTO brandDTO) throws ObjectAlreadyExistsException{
        Optional<Brand> brand = Optional.ofNullable(brandRepository.findBrandByName(brandDTO.getName()));

        if (brand.isPresent()) {
            throw new ObjectAlreadyExistsException("Marca já cadastrada!");
        }

        Brand newbrand = Brand.builder()
                .name(brandDTO.getName())
                .build();

        return brandRepository.save(newbrand);
    }

}
