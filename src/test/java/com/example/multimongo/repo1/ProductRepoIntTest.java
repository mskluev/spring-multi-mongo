package com.example.multimongo.repo1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.multimongo.MultiMongoApplication;
import com.example.multimongo.domain.Product;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MultiMongoApplication.class)
public class ProductRepoIntTest {

    @Autowired
    private ProductRepository productRepo;

    private Product product;

    @Before
    public void init() {
        productRepo.deleteAll();
        product = new Product(1, "product 1");
    }

    @Test
    public void assertThatProductIsSaved() {
        productRepo.save(product);
        List<Product> prods = productRepo.findAll();
        assertThat(prods.size()).isEqualTo(1);
        Product p = prods.get(0);
        assertThat(p.getName()).isEqualTo("product 1");
        assertThat(p.getId()).isNotNull();
    }


}
