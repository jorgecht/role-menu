package com.ingytal.roles.appmenu.service;

import java.util.List;

import com.ingytal.roles.appmenu.repository.entity.RoleEntity;
import com.ingytal.roles.appmenu.repository.entity.UserEntity;


public interface UserService {
	

	public List<UserEntity> listAllUser();
	public UserEntity getUser(Long id);
	
	public UserEntity createUser(UserEntity product);
	public UserEntity updateUser(UserEntity product);
	public UserEntity deleteUser(Long id);
	
	public List<UserEntity> findByRole(RoleEntity category);


}
