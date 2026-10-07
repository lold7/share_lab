package se331.lab6.security.user;

import jakarta.transaction.Transactional;

public interface UserService {
    User save(User user);

    @Transactional
    User findByUsername(String username);
}