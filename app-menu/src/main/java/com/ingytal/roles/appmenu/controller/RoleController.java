package com.ingytal.roles.appmenu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ingytal.roles.appmenu.repository.entity.RoleEntity;
import com.ingytal.roles.appmenu.repository.entity.UserEntity;
import com.ingytal.roles.appmenu.repository.entity.RoleEntity;
import com.ingytal.roles.appmenu.service.RoleService;


@RestController
@RequestMapping(value= "/role")
public class RoleController {
	
	@Autowired
	public RoleService RoleService;
	
	@GetMapping
	public ResponseEntity<List<RoleEntity>> listRole(@RequestParam(name = "role",required = false) Long userid){
		List<RoleEntity> roles = new ArrayList<RoleEntity>();

		if(userid == null) {
			roles = RoleService.listAllRole();
			if (roles.isEmpty())
			{
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.ok(roles);
		
		} else 
		{
			roles = RoleService.findByUser(UserEntity.builder().id(userid).build());
			if (roles.isEmpty())
			{
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.ok(roles);
		}
		
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<RoleEntity> getRole(@PathVariable("id") Long id){
		
		RoleEntity role = RoleService.getRole(id);
		if(role == null) {
			
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(role);
		
		
	}
	
	@PostMapping
	public ResponseEntity<RoleEntity> createProduct(@RequestBody RoleEntity role){
		
		if (role == null) {
			
			return ResponseEntity.noContent().build();
		}
		RoleEntity RoleCreate = RoleService.createRole(role);
		return ResponseEntity.status(HttpStatus.CREATED).body(RoleCreate);
		
		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<RoleEntity> createProduct(@PathVariable Long id, @RequestBody RoleEntity role){
		role.setId(id);
		RoleEntity roleupd = RoleService.updateRole(role);
		if(roleupd == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(roleupd);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<RoleEntity> deleteProduct(@PathVariable Long id){
		
		RoleEntity roledel = RoleService.deleteRole(id);
		if(roledel == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(roledel);
		
	}

}
