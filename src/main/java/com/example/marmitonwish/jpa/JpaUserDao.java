package com.example.marmitonwish.jpa;

import com.example.marmitonwish.jpa.entity.User;

import java.util.List;
import java.util.Optional;

public interface JpaUserDao {

    List<User> findAll();

    boolean addUser(User user);

    boolean deleteUser(long id);

    boolean updateUser(User user);

    Optional<User> getUserById(long id);

    Optional<User> getUserByEmail(String email);


}
