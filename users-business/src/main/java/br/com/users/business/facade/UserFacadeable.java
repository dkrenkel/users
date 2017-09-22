/**
 * 
 */
package br.com.users.business.facade;

import java.util.List;

import br.com.users.business.dto.UserDTO;
import br.com.users.business.error.EntityNotFoundException;
import br.com.users.business.error.ExistingEntityException;

/**
 * Business Interface responsible for defining an abstract contract for business
 * operations
 * 
 * @author David Krenkel <david.melo1992@gmail.com>
 *
 */
public interface UserFacadeable {

	/**
	 * Saves a new user into the databse
	 * 
	 * @param userDTO
	 *            The user to be created
	 * @throws ExistingEntityException
	 *             When the given user already exsists
	 */
	public void saveUser(UserDTO user) throws ExistingEntityException;

	/**
	 * Saves a list of users into the databse
	 * 
	 * @param users
	 *            The list of users to be created
	 * @throws ExistingEntityException
	 *             When any of the given users already exsists
	 */
	public void saveUsers(List<UserDTO> users) throws ExistingEntityException;

	/**
	 * Updates an existing user
	 * 
	 * @param user
	 *            The user to be updated
	 * @throws EntityNotFoundException
	 *             When the given user can't be found
	 */
	public void updateUser(UserDTO user) throws EntityNotFoundException;

	/**
	 * Deletes an existing user from the database
	 * 
	 * @param email
	 *            The cpf belonging to the user to be deleted
	 * @throws EntityNotFoundException
	 *             When the given user can't be found
	 */
	public void deleteUser(String cpf) throws EntityNotFoundException;

	/**
	 * Finds user by their cpf
	 * 
	 * @param cpf
	 *            The cpf to be searched
	 * @return The user with the given cpf
	 * @throws EntityNotFoundException
	 *             When the given cpf can't be found
	 */
	public UserDTO findByCpf(String cpf) throws EntityNotFoundException;

}
