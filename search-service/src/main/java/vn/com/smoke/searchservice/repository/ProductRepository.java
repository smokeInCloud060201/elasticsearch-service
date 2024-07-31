package vn.com.smoke.searchservice.repository;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import vn.com.smoke.searchservice.entities.Product;

import java.util.List;

@Repository
public interface ProductRepository extends ElasticsearchRepository<Product, String> {
    @Query("{\"multi_match\": {\"query\": \"?0\", \"fields\": [\"name\", \"description\"]}}")
    List<Product> searchByNameOrDescription(String query);
}
