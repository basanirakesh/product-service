package com.ing.product.repository.test;

import com.ing.product.ProductServiceApplication;
import com.ing.product.model.CustomerProductMapping;
import com.ing.product.repository.CustomerProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest(classes = {ProductServiceApplication.class})
public class CustomerProductRepositoryTest {

    @Autowired
    private CustomerProductRepository customerProductRepository;

    @Test
    public void testFindCustomerProductMappingsById() {
        List<CustomerProductMapping> customerProductRepositoryList = customerProductRepository.findCustomerProductMappingsById(1l, 1l);
        Assert.assertEquals(customerProductRepositoryList.size(), 1);
    }
}
