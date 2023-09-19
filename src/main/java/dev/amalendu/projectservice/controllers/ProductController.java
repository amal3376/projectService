package dev.amalendu.projectservice.controllers;

import ch.qos.logback.core.net.SyslogOutputStream;
import dev.amalendu.projectservice.dtos.ExceptionDto;
import dev.amalendu.projectservice.dtos.GenericProductDto;
import dev.amalendu.projectservice.exceptions.NotFoundException;
import dev.amalendu.projectservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {


    //Injection types :- Field Injection, Constructor Injection, Setter Injection

    /**
     * field injection is implemented by using autowired annotation to the field.
     * constructor injection is implemented by the injecting the dependency of the field by constructor.
     * setter injection is implemented by using the autowired annotation to the setter method where dependency of the field injected.
     **/
    private ProductService productService;

    public ProductController(@Qualifier("FakeStoreProductService") ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public List<GenericProductDto> getAllProducts(){
        return productService.getAllProducts();
    }

    //localhost:8080/products/123
    @GetMapping("{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) throws NotFoundException{
        return productService.getProductById(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<GenericProductDto> deleteProductById(@PathVariable("id") Long id){
        ResponseEntity<GenericProductDto> response = new ResponseEntity<>(
                productService.deleteProduct(id),
                HttpStatus.OK
        );
        return response;
    }

    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto product){
        System.out.println(product.getTitle());
        return productService.createProduct(product);
    }

    @PutMapping("{id}")
    public GenericProductDto updateProductById(@RequestBody GenericProductDto product, @PathVariable("id") Long id){
        return productService.updateProduct(product, id);
    }
}
