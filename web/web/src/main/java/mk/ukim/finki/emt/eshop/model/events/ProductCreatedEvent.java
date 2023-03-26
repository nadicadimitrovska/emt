package mk.ukim.finki.emt.eshop.model.events;

import lombok.Getter;
import mk.ukim.finki.emt.eshop.model.Product;
import org.springframework.context.ApplicationEvent;

import java.time.LocalDateTime;

@Getter
public class ProductCreatedEvent extends ApplicationEvent {

    private LocalDateTime when;



    public ProductCreatedEvent(Product source) {
        super(source);
        this.when=LocalDateTime.now();
    }

    public ProductCreatedEvent(Product source,LocalDateTime when) {
        super(source);
        this.when=when;
    }
}
