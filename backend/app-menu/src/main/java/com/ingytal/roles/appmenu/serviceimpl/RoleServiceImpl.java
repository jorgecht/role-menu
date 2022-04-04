package com.ingytal.roles.appmenu.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ingytal.roles.appmenu.repository.RoleRepository;
import com.ingytal.roles.appmenu.repository.entity.RoleEntity;
import com.ingytal.roles.appmenu.repository.entity.UserEntity;
import com.ingytal.roles.appmenu.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository rolerepository;

	@Override
	public List<RoleEntity> listAllRole() {
		return rolerepository.findAll();
	
	}

	@Override
	public RoleEntity getRole(Long id) {
		return rolerepository.findById(id).orElse(null);
	}

	@Override
	public RoleEntity createRole(RoleEntity role) {
		role.setStatus("created");
		role.setCreate_at(new Date());
		return rolerepository.save(role);
	}

	@Override
	public RoleEntity updateRole(RoleEntity role) {
		RoleEntity roleupd = getRole(role.getId());
		if (roleupd == null) {
			return null;
		}
		roleupd.setName(role.getName());
		roleupd.setDescription(role.getDescription());
		roleupd.setStatus("updated");
		
		
		return rolerepository.save(roleupd);
	}

	@Override
	public RoleEntity deleteRole(Long id) {
		RoleEntity roledel = getRole(id);
		if (roledel == null) {
			return null;
		}
		roledel.setStatus("DELETED");

		return rolerepository.save(roledel);
	}

	@Override
	public List<RoleEntity> findByUser(UserEntity user) {
		return rolerepository.findByUser(user);
	}

}
