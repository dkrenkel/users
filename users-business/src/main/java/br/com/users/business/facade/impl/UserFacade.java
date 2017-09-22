/**
 * 
 */
package br.com.users.business.facade.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public void saveUser(UserDTO userDTO) throws ExistingEntityException {
		User user = this.userRepository.findByCpf(userDTO.getCpf());
		if (user != null) {
			throw new ExistingEntityException("Entity already exists");
		}
		this.userRepository.save(this.userMapper.map(userDTO));
	}
	
	@Override
	@Transactional
	public void saveUsers(List<UserDTO> usersDTO) throws ExistingEntityException {
		for (UserDTO userDTO: usersDTO) {
			User user = this.userRepository.findByCpf(userDTO.getCpf());
			if (user != null) {
				throw new ExistingEntityException("Entity already exists");
			}
			this.userRepository.save(this.userMapper.map(userDTO));
		}
	}

	@Override
	public void updateUser(UserDTO userDTO) throws EntityNotFoundException {
		User user = this.userRepository.findByCpf(userDTO.getCpf());
		if (user == null) {
			throw new EntityNotFoundException("Entity not found");
		}
		Long id = user.getId();
		user = this.userMapper.map(userDTO);
		user.setId(id);
		this.userRepository.save(user);
	}

	@Override
	public void deleteUser(String cpf) throws EntityNotFoundException {
		User user = this.userRepository.findByCpf(cpf);
		if (user == null) {
			throw new EntityNotFoundException("Entity not found");
		}
		this.userRepository.delete(user);
	}

	@Override
	public UserDTO findByCpf(String cpf) throws EntityNotFoundException {
		User user = this.userRepository.findByCpf(cpf);
		if (user == null) {
			throw new EntityNotFoundException("Entity not foud");
		}
		return this.userMapper.map(this.userRepository.findByCpf(cpf));
	}

}
