package com.ingytal.roles.appmenu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ingytal.roles.appmenu.repository.entity.RoleEntity;
import com.ingytal.roles.appmenu.repository.entity.UserEntity;
import com.ingytal.roles.appmenu.service.UserService;

import lombok.Builder;


@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping(value= "/user")
public class UserController {
	
	@Autowired
	public UserService userService;
	
	@GetMapping
	public ResponseEntity<List<UserEntity>> listUser(@RequestParam(name = "role",required = false) Long roleid){
		List<UserEntity> users = new ArrayList<UserEntity>();

		if(roleid == null) {
			users = userService.listAllUser();
			if (users.isEmpty())
			{
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.ok(users);
		
		} else 
		{
			users = userService.findByRole(RoleEntity.builder().id(roleid).build());
			if (users.isEmpty())
			{
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.ok(users);
		}
		
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserEntity> getUser(@PathVariable("id") Long id){
		
		UserEntity user = userService.getUser(id);
		if(user == null) {
			
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(user);
		
		
	}
	
	@PostMapping
	public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user){
		
		if (user == null) {
			
			return ResponseEntity.noContent().build();
		}
		UserEntity userCreate = userService.createUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(userCreate);
		
		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<UserEntity> updateUser(@PathVariable Long id, @RequestBody UserEntity user){
		user.setId(id);
		UserEntity userupd = userService.updateUser(user);
		if(userupd == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(userupd);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<UserEntity> deleteUser(@PathVariable Long id){
		
		UserEntity userdel = userService.deleteUser(id);
		if(userdel == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(userdel);
		
	}

}
