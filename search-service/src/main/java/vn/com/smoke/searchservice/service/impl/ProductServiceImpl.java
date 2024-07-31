package vn.com.smoke.searchservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import vn.com.smoke.searchservice.entities.Product;
import vn.com.smoke.searchservice.repository.ProductRepository;
import vn.com.smoke.searchservice.service.ProductService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService, CommandLineRunner {

    private final ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        String uuid = UUID.randomUUID().toString();
        Product product = new Product();
        product.setId(uuid);
        product.setName("Product " + uuid);
        product.setDescription("Product description" + uuid);
        product.setPrice(2.00);
        productRepository.save(product);
        log.info("Saved product with id: {}", product.getId());
    }
}
