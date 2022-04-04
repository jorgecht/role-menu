package com.ingytal.roles.appmenu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ingytal.roles.appmenu.repository.entity.RoleEntity;
import com.ingytal.roles.appmenu.repository.entity.UserEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
	
	public List<RoleEntity> findByUser(UserEntity user);
	
}
