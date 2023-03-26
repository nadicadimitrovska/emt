package mk.ukim.finki.emt.eshop.web.rest;

import mk.ukim.finki.emt.eshop.model.Discount;
import mk.ukim.finki.emt.eshop.model.dto.DiscountDto;
import mk.ukim.finki.emt.eshop.service.DiscountService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;
import java.util.List;

@RestController
@RequestMapping("/api/discounts")
public class DiscountRestController {

    private final DiscountService discountService;

    public DiscountRestController(DiscountService discountService) {
        this.discountService = discountService;
    }

    @GetMapping
    public List<Discount>findAll(){
        return this.discountService.findAll();
    }

    @GetMapping("/pagination")
    public List<Discount> findAllWithPagination(Pageable pageable) {
        return this.discountService.findAllWithPagination(pageable).getContent();
    }


    /*
        http://localhost:9091/api/discounts/3 -- path variable
        http://localhost:9091/api/discounts?id=3 -- query param
     */

    @GetMapping("/{id}")
    public ResponseEntity<Discount> findById(@PathVariable Long id){
        return this.discountService.findById(id).map(discount -> ResponseEntity.ok().body(discount)).orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Discount> save(@RequestBody DiscountDto discountDto){
        return this.discountService.save(discountDto).map(discount -> ResponseEntity.ok().body(discount)).orElseGet(()->ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Discount> edit(@PathVariable Long id, @RequestBody DiscountDto discountDto){
        return this.discountService.edit(id,discountDto).map(discount -> ResponseEntity.ok().body(discount)).orElseGet(()->ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        this.discountService.deleteById(id);
        if (this.discountService.findById(id).isEmpty())
            return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/assign/{id}")
    public ResponseEntity<Discount> assignDiscount(@PathVariable Long id, @RequestBody String username){
        return this.discountService.assignDiscount(username,id).map(discount -> ResponseEntity.ok().body(discount)).orElseGet(()->ResponseEntity.badRequest().build());
    }
}
