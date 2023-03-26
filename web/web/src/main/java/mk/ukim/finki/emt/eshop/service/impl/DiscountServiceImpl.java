package mk.ukim.finki.emt.eshop.service.impl;

import mk.ukim.finki.emt.eshop.model.Discount;
import mk.ukim.finki.emt.eshop.model.User;
import mk.ukim.finki.emt.eshop.model.dto.DiscountDto;
import mk.ukim.finki.emt.eshop.model.exceptions.DiscountNotFoundException;
import mk.ukim.finki.emt.eshop.model.exceptions.UserNotFoundException;
import mk.ukim.finki.emt.eshop.repository.DiscountRepository;
import mk.ukim.finki.emt.eshop.repository.UserRepository;
import mk.ukim.finki.emt.eshop.service.DiscountService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class DiscountServiceImpl implements DiscountService {

    private final DiscountRepository discountRepository;
    private final UserRepository userRepository;

    public DiscountServiceImpl(DiscountRepository discountRepository, UserRepository userRepository) {
        this.discountRepository = discountRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Discount> findAll() {
        return this.discountRepository.findAll();
    }

    @Override
    public Page<Discount> findAllWithPagination(Pageable pageable) {
        return this.discountRepository.findAll(pageable);
    }


    @Override
    public Optional<Discount> findById(Long id) {
        return this.discountRepository.findById(id);
    }

    @Override
    public Optional<Discount> save(DiscountDto discountDto) {
        return Optional.of(this.discountRepository.save(new Discount(discountDto.getValidUntil())));
    }

    @Override
    public Optional<Discount> edit(Long id, DiscountDto discountDto) {
        Discount discount=this.discountRepository.findById(id).orElseThrow(()->new DiscountNotFoundException(id));
        discount.setValidUntil(discountDto.getValidUntil());
        return Optional.of(this.discountRepository.save(discount));
    }

    @Override
    public void deleteById(Long id) {
        this.discountRepository.deleteById(id);
    }

    @Override
    public Optional<Discount> assignDiscount(String username, Long discountId) {
        User user=this.userRepository.findByUsername(username).orElseThrow(()->new UserNotFoundException(username));
        Discount discount=this.discountRepository.findById(discountId).orElseThrow(()->new DiscountNotFoundException(discountId));

        discount.getUsers().add(user);
        return Optional.of(this.discountRepository.save(discount));
    }
}
