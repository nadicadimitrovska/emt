package mk.ukim.finki.emt.eshop.repository;

import mk.ukim.finki.emt.eshop.model.Product;
import mk.ukim.finki.emt.eshop.model.views.ProductsPerCategoryView;
import mk.ukim.finki.emt.eshop.model.views.ProductsPerManufacturerView;
import mk.ukim.finki.emt.eshop.repository.views.ProductsPerManufacturerViewRepository;
import mk.ukim.finki.emt.eshop.service.CategoryService;
import mk.ukim.finki.emt.eshop.service.ManufacturerService;
import mk.ukim.finki.emt.eshop.service.ProductService;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductsPerManufacturerViewRepositoryTest {

    @Autowired
    private ProductsPerManufacturerViewRepository productsPerManufacturerViewRepository;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ManufacturerService manufacturerService;

    @Autowired
    private ProductService productService;

    @Test
    public void testProductsPerManufacturerViewRepositoryCreateNewProduct(){
        List<ProductsPerManufacturerView> list1=this.productsPerManufacturerViewRepository.findAll();

        Product product=new Product();
        product.setName("Ski Jacket 557");
        product.setManufacturer(this.manufacturerService.findAll().get(0));
        product.setCategory(this.categoryService.listCategories().get(0));
        this.productService.save(product.getName(),product.getPrice(),product.getQuantity(),product.getCategory().getId(),product.getManufacturer().getId());

        List<ProductsPerManufacturerView>list2=this.productsPerManufacturerViewRepository.findAll();

    }
}
