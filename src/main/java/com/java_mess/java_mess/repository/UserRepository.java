package com.java_mess.java_mess.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java_mess.java_mess.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, String> {
  Optional<User> findByAppIdAndClientUserId(String appId, String clientUserId);
}
