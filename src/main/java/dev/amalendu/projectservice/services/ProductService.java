package dev.amalendu.projectservice.services;

import dev.amalendu.projectservice.dtos.GenericProductDto;
import dev.amalendu.projectservice.exceptions.NotFoundException;
import dev.amalendu.projectservice.models.Product;

import java.util.List;

public interface ProductService {

    GenericProductDto createProduct(GenericProductDto product);
    GenericProductDto updateProduct(GenericProductDto product, Long id);

    GenericProductDto getProductById(Long id) throws NotFoundException;

    List<GenericProductDto> getAllProducts();

    GenericProductDto deleteProduct(Long id);

}
