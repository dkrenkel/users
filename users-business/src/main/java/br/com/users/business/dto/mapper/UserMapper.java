/**
 * 
 */
package br.com.users.business.dto.mapper;

import org.springframework.stereotype.Component;

import br.com.users.business.dto.UserDTO;
import br.com.users.model.User;

/**
 * @author David Krenkel <david.melo1992@gmail.com>
 *
 */
@Component
public class UserMapper {

	public User map(UserDTO userDTO) {
		if (userDTO == null) {
			return null;
		}
		User user = new User();
		user.setCpf(userDTO.getCpf());
		user.setEmail(userDTO.getEmail());
		user.setName(userDTO.getName());
		user.setPassword(userDTO.getPassword());
		return user;
	}
	
	public UserDTO map(User user) {
		if (user == null) {
			return null;
		}
		UserDTO userDTO = new UserDTO();
		userDTO.setCpf(user.getCpf());
		userDTO.setEmail(user.getEmail());
		userDTO.setName(user.getName());
		userDTO.setPassword(user.getPassword());
		return userDTO;
	}

}
