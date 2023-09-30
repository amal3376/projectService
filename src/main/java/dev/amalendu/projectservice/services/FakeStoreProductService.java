package dev.amalendu.projectservice.services;

import dev.amalendu.projectservice.dtos.GenericProductDto;
import dev.amalendu.projectservice.exceptions.NotFoundException;
import dev.amalendu.projectservice.thirdpartyclients.productsservice.fakestore.FakeStoreProductDto;
import dev.amalendu.projectservice.thirdpartyclients.productsservice.fakestore.FakeStoreProductServiceClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Primary
@Service("FakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    private FakeStoreProductServiceClient fakeStoreProductServiceClient;

    private GenericProductDto convertFakestoreProductInToGenericProduct(FakeStoreProductDto fakeStoreProductDto){
        GenericProductDto product = new GenericProductDto();
        product.setId(fakeStoreProductDto.getId());
        product.setImage(fakeStoreProductDto.getImage());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setCategory(fakeStoreProductDto.getCategory());
        return product;
    }

    //https://fakestoreapi.com/products
    public FakeStoreProductService(FakeStoreProductServiceClient fakeStoreProductServiceClient){
        this.fakeStoreProductServiceClient = fakeStoreProductServiceClient;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto product){
        return convertFakestoreProductInToGenericProduct(fakeStoreProductServiceClient.createProduct(product));
    }

    @Override
    public GenericProductDto updateProduct(GenericProductDto product, Long id) {
        return  convertFakestoreProductInToGenericProduct(fakeStoreProductServiceClient.updateProduct(product, id));
    }

    @Override
    public GenericProductDto getProductById(Long id) throws NotFoundException {
        return convertFakestoreProductInToGenericProduct(fakeStoreProductServiceClient.getProductById(id));
    }

    @Override
    public List<GenericProductDto> getAllProducts(){
        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto: fakeStoreProductServiceClient.getAllProducts()){
            genericProductDtos.add(convertFakestoreProductInToGenericProduct(fakeStoreProductDto));
        }
        return genericProductDtos;
    }

    @Override
    public GenericProductDto deleteProduct(Long id) {
        return convertFakestoreProductInToGenericProduct(fakeStoreProductServiceClient.deleteProduct(id));
    }
}
