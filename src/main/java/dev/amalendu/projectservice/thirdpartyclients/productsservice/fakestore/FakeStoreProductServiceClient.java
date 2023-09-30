package dev.amalendu.projectservice.thirdpartyclients.productsservice.fakestore;

import dev.amalendu.projectservice.dtos.GenericProductDto;
import dev.amalendu.projectservice.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Wrapper over Fakestore API
 * **/



@Service
public class FakeStoreProductServiceClient {


    private RestTemplateBuilder restTemplateBuilder;

    @Value("${fakestore.api.url}")
    private String fakeStoreApiUrl;

    @Value("${fakestore.api.paths.product}")
    private String fakeStoreProductApiPath;

    private String specificProductRequestUrl = fakeStoreApiUrl +fakeStoreProductApiPath +"/{id}";
    private String productRequestsBaseUrl = fakeStoreApiUrl +fakeStoreProductApiPath;

    public FakeStoreProductServiceClient(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }

//    @Override
    public FakeStoreProductDto createProduct(GenericProductDto product){
        RestTemplate restTemplate= restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.postForEntity(
                productRequestsBaseUrl, product,FakeStoreProductDto.class
        );

        return response.getBody();
    }

//    @Override
    public FakeStoreProductDto updateProduct(GenericProductDto product, Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(product);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor =
                restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> response =
                restTemplate.execute(
                        specificProductRequestUrl, HttpMethod.PUT, requestCallback, responseExtractor, id
                );
        FakeStoreProductDto fakeStoreProductDto = response.getBody();
        return  fakeStoreProductDto;
//        return  null;
    }

//    @Override
    public FakeStoreProductDto getProductById(Long id) throws NotFoundException {
        RestTemplate restTemplate= restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response =
                restTemplate.getForEntity(specificProductRequestUrl, FakeStoreProductDto.class, id);
        FakeStoreProductDto fakeStoreProductDto = response.getBody();

        if (fakeStoreProductDto==  null){
            throw new NotFoundException("Productn with id: "+id+" doesn't exixt. ");
        }

        return fakeStoreProductDto; //+id;
//        return null;
    }

//    @Override
    public List<FakeStoreProductDto> getAllProducts(){
        RestTemplate restTemplate= restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response =
                restTemplate.getForEntity(productRequestsBaseUrl, FakeStoreProductDto[].class);
        List<GenericProductDto> answer = new ArrayList<>();
        return Arrays.stream(response.getBody()).toList();
    }

//    @Override
    public FakeStoreProductDto deleteProduct(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor =
                restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> response =
                restTemplate.execute(specificProductRequestUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);

        return response.getBody();
    }
}
