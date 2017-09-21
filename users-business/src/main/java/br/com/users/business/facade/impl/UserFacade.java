/**
 * 
 */
package br.com.users.business.facade.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.users.business.dto.UserDTO;
import br.com.users.business.dto.mapper.UserMapper;
import br.com.users.business.error.EntityNotFoundException;
import br.com.users.business.error.ExistingEntityException;
import br.com.users.business.facade.UserFacadeable;
import br.com.users.core.repository.UserRepository;
import br.com.users.model.User;

/**
 * @author David Krenkel <david.melo1992@gmail.com>
 *
 */
@Service
public class UserFacade implements UserFacadeable {

	@Resource
	private UserRepository userRepository;

	@Autowired
	private UserMapper userMapper;

	@Override
	public void saveUser(UserDTO userDTO) {
		User user = this.userRepository.findByCpf(userDTO.getCpf());
		if (user != null) {
			throw new ExistingEntityException("Entity already exists");
		}
		this.userRepository.save(this.userMapper.map(userDTO));
	}

	@Override
	public void updateUser(UserDTO userDTO) {
		User user = this.userRepository.findByCpf(userDTO.getCpf());
		if (user == null) {
			throw new EntityNotFoundException("Entity not found");
		}
		this.userRepository.save(this.userMapper.map(userDTO));
	}

	@Override
	public void deleteUser(String cpf) {
		User user = this.userRepository.findByCpf(cpf);
		if (user == null) {
			throw new EntityNotFoundException("Entity not found");
		}
		this.userRepository.delete(user);
	}

	@Override
	public UserDTO findByCpf(String cpf) {
		return this.userMapper.map(this.userRepository.findByCpf(cpf));
	}
}
