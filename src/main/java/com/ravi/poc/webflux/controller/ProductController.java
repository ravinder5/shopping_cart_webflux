package com.ravi.poc.webflux.controller;

import com.ravi.poc.webflux.entity.Product;
import com.ravi.poc.webflux.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping(value = "/{id}")
    public Mono<?> getProduct(@PathVariable String id) {
        return productRepository.findById(id);
    }

    @GetMapping()
    public Flux<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @PostMapping()
    public Mono<Product> addProduct(@RequestBody Product newProduct){
        Product product = new Product(newProduct.getProduct_id(), newProduct.getProduct_name(), newProduct.getProduct_price());
        return productRepository.save(product);
    }

    @PutMapping(value = "/{id}")
    public Mono<Product> updateProduct(@RequestBody Product newProduct, @PathVariable String id){
//        Mono<Product> optionalProduct = productRepository.findById(id);
        // ToDo: Implement logic to check if the product is present.
        Product product = new Product(newProduct.getProduct_id(), newProduct.getProduct_name(), newProduct.getProduct_price());
        return productRepository.save(product);
//    }
    }

    @DeleteMapping(value = "/{id}")
    public Mono<Void> deleteProduct(@PathVariable String id){
        return productRepository.deleteById(id);
    }

}
