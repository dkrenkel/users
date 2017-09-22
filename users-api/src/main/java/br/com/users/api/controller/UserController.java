/**
 * 
 */
package br.com.users.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.users.business.dto.UserDTO;
import br.com.users.business.error.EntityNotFoundException;
import br.com.users.business.error.ExistingEntityException;
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

	/**
	 * Creates a set of users
	 * 
	 * @param user
	 * @param request
	 * @return the created users
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<?> createUsers(@RequestBody List<UserDTO> users) {
		try {
			this.userFacade.saveUsers(users);
		} catch (ExistingEntityException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		return new ResponseEntity<List<UserDTO>>(users, HttpStatus.CREATED);
	}

	/**
	 * Updates a given user
	 * 
	 * @param user
	 *            the user to be updated
	 * @return HTTP status code resulting from the operation
	 */
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@RequestBody UserDTO user) {
		try {
			this.userFacade.updateUser(user);
		} catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok().build();
	}

	/**
	 * Deletes the user with the given cpf
	 * 
	 * @param cpf
	 * @return HTTP status code resulting from the operation
	 */
	@RequestMapping(value = "/{cpf}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable String cpf) {
		try {
			this.userFacade.deleteUser(cpf);
		} catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok().build();
	}

	/**
	 * Searches for a user with the given cpf
	 * 
	 * @param cpf
	 * @return HTTP status code resulting from the operation
	 */
	@RequestMapping(value = "/{cpf}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> get(@PathVariable String cpf) {
		try {
			UserDTO userDTO = this.userFacade.findByCpf(cpf);
			return ResponseEntity.ok(userDTO);
		} catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
