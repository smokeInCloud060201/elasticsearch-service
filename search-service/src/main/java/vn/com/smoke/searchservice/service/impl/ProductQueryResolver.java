package vn.com.smoke.searchservice.service.impl;

import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import vn.com.smoke.searchservice.entities.Product;
import vn.com.smoke.searchservice.repository.ProductRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductQueryResolver implements GraphQLQueryResolver  {

    private final ProductRepository productRepository;


    public List<Product> searchProducts(String query) {
        return productRepository.searchByNameOrDescription(query);
    }
}
