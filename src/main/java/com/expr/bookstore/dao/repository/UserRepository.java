package com.expr.bookstore.dao.repository;

import com.expr.bookstore.dao.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findUserByUsername(String username);

    Optional<User> findUserByPhone(String phone);

}