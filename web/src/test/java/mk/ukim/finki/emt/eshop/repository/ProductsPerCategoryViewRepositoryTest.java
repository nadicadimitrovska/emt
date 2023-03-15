package mk.ukim.finki.emt.eshop.repository;


import mk.ukim.finki.emt.eshop.model.views.ProductsPerCategoryView;
import mk.ukim.finki.emt.eshop.repository.views.ProductsPerCategoryViewRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductsPerCategoryViewRepositoryTest {

    @Autowired
    private ProductsPerCategoryViewRepository productsPerCategoryViewRepository;

    @Test
    public void testFindAll(){
        List<ProductsPerCategoryView>list=this.productsPerCategoryViewRepository.findAll();
        Assert.assertEquals(1,list.size());
    }

}
