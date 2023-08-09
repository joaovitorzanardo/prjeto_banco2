package com.springframework.play.repository;

import com.springframework.play.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

    public Brand findBrandByBrandId(Long brandId);

    public Brand findBrandByName(String name);

}
