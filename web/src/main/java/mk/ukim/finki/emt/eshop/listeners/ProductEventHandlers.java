package mk.ukim.finki.emt.eshop.listeners;

import mk.ukim.finki.emt.eshop.model.events.ProductCreatedEvent;
import mk.ukim.finki.emt.eshop.service.ProductService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ProductEventHandlers {

    private final ProductService productService;

    public ProductEventHandlers(ProductService productService) {
        this.productService = productService;
    }

    @EventListener
    public void onProductCreated(ProductCreatedEvent event){
        this.productService.refreshMaterializedView();
    }
}
