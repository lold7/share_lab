package se331.lab6.security.user;

public interface UserDao {
    User findByUsername(String username);

    User save(User user);
}