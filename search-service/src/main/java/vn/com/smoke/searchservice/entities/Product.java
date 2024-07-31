package vn.com.smoke.searchservice.entities;

import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "product")
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    private String id;

    private String name;

    private String description;

    private double price;

}
