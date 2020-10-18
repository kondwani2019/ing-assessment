package com.ing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.ing.security.IsUser;

import com.ing.model.dto.UserDto;
import com.ing.service.IUserService;

@RestController
@RequestMapping("users")
@IsUser
public class UserManagementController {

	@Autowired
	private IUserService userService;
	
	@GetMapping(path = "/details/{id}", produces = "application/json")
	@ResponseBody
    public UserDto getDetails(@PathVariable Long id) {
        return userService.getDetails(id);
    }
	
	@GetMapping(path = "/get-all", produces = "application/json")
	@ResponseBody
    public List<UserDto> getAll() {
        return userService.getAll();
    }
	
	@PostMapping(path="/save/", produces = "application/json", consumes = "application/json")
	public ResponseEntity<String> save(@RequestBody UserDto user) {
		userService.save(user);
		return ResponseEntity.ok("Successful");
	}
	
	@PostMapping(path="/update/", produces = "application/json", consumes = "application/json")
	public ResponseEntity<String> update(@RequestBody UserDto user) {
		userService.update(user);
		return ResponseEntity.ok("Successful");
	}
}
