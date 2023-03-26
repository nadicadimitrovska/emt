package mk.ukim.finki.emt.eshop.model.views;

import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@Subselect("SELECT * FROM public.products_per_category")
@Immutable
public class ProductsPerCategoryView {

    @Id
    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "num_products")
    private Integer numProducts;
}
