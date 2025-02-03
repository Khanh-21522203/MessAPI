package com.java_mess.java_mess.service;

import org.springframework.stereotype.Service;

import com.java_mess.java_mess.dto.user.CreateUserRequest;
import com.java_mess.java_mess.model.App;
import com.java_mess.java_mess.model.User;

@Service
public interface UserService {
  User createUser(App app, CreateUserRequest request);

  User getUserByClientId(App app, String clientUserId);
}

