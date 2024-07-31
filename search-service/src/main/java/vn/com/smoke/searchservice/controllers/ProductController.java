package vn.com.smoke.searchservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.com.smoke.searchservice.entities.Product;
import vn.com.smoke.searchservice.repository.ProductRepository;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository productRepository;


    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam String query) {
        return productRepository.searchByNameOrDescription(query);
    }
}
