/**
 * 
 */
package br.com.users.api.controller;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.users.business.dto.UserDTO;
import br.com.users.business.facade.UserFacadeable;

/**
 * @author David Krenkel <david.melo1992@gmail.com>
 *
 */
@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserFacadeable userFacade;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody UserDTO user, HttpServletRequest request) {
		this.userFacade.saveUser(user);
		URI location = ServletUriComponentsBuilder
						.fromCurrentRequest().path("/"+user.getCpf())
						.buildAndExpand(user.getCpf()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@RequestMapping(value = "test", method = RequestMethod.POST)
	public ResponseEntity<?> test() {
		UserDTO user = new UserDTO();
		user.setCpf("00000000000");
		user.setEmail("dfdffgs@kjdfgh.com");
		user.setName("John Jr Neto");
		user.setPassword("dsjfad");
		this.userFacade.saveUser(user);
		URI location = ServletUriComponentsBuilder
						.fromCurrentRequest().path("/"+user.getCpf())
						.buildAndExpand(user.getCpf()).toUri();
		return ResponseEntity.created(location).build();
	}
}
