package com.clone.insta.repository;

import com.clone.insta.domain.User;

import java.util.Optional;

public interface UserRepository {

    User save(User user);

    Optional<User> findByName(String name);
}
