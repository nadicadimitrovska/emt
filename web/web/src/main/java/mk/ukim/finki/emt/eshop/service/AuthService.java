package mk.ukim.finki.emt.eshop.service;

import mk.ukim.finki.emt.eshop.model.User;

public interface AuthService {

    User login(String username, String password);
}
