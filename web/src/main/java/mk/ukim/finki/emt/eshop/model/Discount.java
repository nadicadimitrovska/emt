package mk.ukim.finki.emt.eshop.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateCreated;

    private LocalDate validUntil;

    @OneToMany(mappedBy = "discount")
    private List<User> user;

    public Discount() {
    }
}
