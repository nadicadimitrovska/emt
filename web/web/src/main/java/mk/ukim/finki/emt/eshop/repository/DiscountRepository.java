package mk.ukim.finki.emt.eshop.repository;

import mk.ukim.finki.emt.eshop.model.Discount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends JpaRepository<Discount,Long> {

    Page<Discount>findAll(Pageable pageable);
}
