package com.ingytal.roles.appmenu.service;

import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.ingytal.roles.appmenu.repository.entity.RoleEntity;
import com.ingytal.roles.appmenu.repository.entity.UserEntity;

public interface RoleService {

	public List<RoleEntity> listAllRole();
	public RoleEntity getRole(Long id);
	
	public RoleEntity createRole(RoleEntity product);
	public RoleEntity updateRole(RoleEntity product);
	public RoleEntity deleteRole(Long id);
	
	public List<RoleEntity> findByUser(UserEntity user);
	
	
}
