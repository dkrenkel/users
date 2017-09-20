/**
 * 
 */
package br.com.users.api.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.users.business.dto.UserDTO;
import br.com.users.business.facade.UserFacadeable;

/**
 * @author David Krenkel <david.melo1992@gmail.com>
 *
 */
@RestController
@RequestMapping
public class UserController {

	@Autowired
	private UserFacadeable userFacade;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity createUser(@RequestBody UserDTO user, HttpServletRequest request) {
//		request.set
		return null;
	}
}
