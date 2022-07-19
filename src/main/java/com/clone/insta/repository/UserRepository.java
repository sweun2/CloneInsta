package com.clone.insta.repository;

import com.clone.insta.domain.UserInfo;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    UserInfo save(UserInfo userInfo);

    Optional<UserInfo> findByName(String name);

    List<UserInfo> findAll();

    Optional<UserInfo> findById(Long id);
}
