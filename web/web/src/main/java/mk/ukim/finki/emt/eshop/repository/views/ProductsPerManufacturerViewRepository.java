package mk.ukim.finki.emt.eshop.repository.views;

import mk.ukim.finki.emt.eshop.model.views.ProductsPerManufacturerView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProductsPerManufacturerViewRepository
        extends JpaRepository<ProductsPerManufacturerView,Long> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "REFRESH MATERIALIZED VIEW public.products_per_manufacturer",nativeQuery = true)
    void refreshMaterializedView();
}
