package com.ravi.poc.webflux.repository;

import com.ravi.poc.webflux.entity.Product;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

public interface ProductRepository extends ReactiveCassandraRepository<Product, String> {
}
