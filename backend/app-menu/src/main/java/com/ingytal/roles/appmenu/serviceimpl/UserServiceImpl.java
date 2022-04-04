package com.ingytal.roles.appmenu.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ingytal.roles.appmenu.repository.UserRepository;
import com.ingytal.roles.appmenu.repository.entity.RoleEntity;
import com.ingytal.roles.appmenu.repository.entity.UserEntity;
import com.ingytal.roles.appmenu.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userrepository;

	@Override
	public List<UserEntity> listAllUser() {
		return userrepository.findAll();
		
	}

	@Override
	public UserEntity getUser(Long id) {
		return userrepository.findById(id).orElse(null);
	}

	@Override
	public UserEntity createUser(UserEntity user) {
		user.setStatus("created");
		user.setCreate_at(new Date());
		
		return userrepository.save(user);
	}

	@Override
	public UserEntity updateUser(UserEntity user) {
		UserEntity userupd = getUser(user.getId());
		if (userupd == null) {
			return null;
		}
		userupd.setFirstname(user.getFirstname());
		userupd.setLastname(user.getLastname());
		userupd.setDni(user.getDni());
		userupd.setStatus("updated");
		userupd.setRole(user.getRole());
		
		return userrepository.save(userupd);
	}

	@Override
	public UserEntity deleteUser(Long id) {
		UserEntity userdel = getUser(id);
		if (userdel == null) {
			return null;
		}
		userdel.setStatus("DELETED");

		return userrepository.save(userdel);
	}

	@Override
	public List<UserEntity> findByRole(RoleEntity role) {
		return userrepository.findByRole(role);
	}

}
