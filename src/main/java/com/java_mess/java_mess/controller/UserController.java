package com.java_mess.java_mess.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java_mess.java_mess.dto.user.CreateUserRequest;
import com.java_mess.java_mess.dto.user.CreateUserResponse;
import com.java_mess.java_mess.dto.user.GetUserResponse;
import com.java_mess.java_mess.model.User;
import com.java_mess.java_mess.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController extends BaseController {
	@Autowired
	private final UserService userService;

	@GetMapping("{id}/by-client-user-id")
	public ResponseEntity<GetUserResponse> getUser(@PathVariable String id) {
		User user = userService.getUserByClientId(this.getAuthenticatedApp(), id);
		return ResponseEntity.status(HttpStatus.OK).body(GetUserResponse.builder().user(user).build());
	}

	@PostMapping("/")
	public ResponseEntity<CreateUserResponse> createUser(@Valid @RequestBody CreateUserRequest request) {
		User user = userService.createUser(getAuthenticatedApp(), request);
		return ResponseEntity.status(HttpStatus.OK).body(CreateUserResponse.builder().user(user).build());
	}
}
