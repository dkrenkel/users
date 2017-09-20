/**
 * 
 */
package br.com.users.business.facade;

import br.com.users.business.dto.UserDTO;

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
	 * @param user
	 *            The user to be created
	 */
	public void saveUser(UserDTO user);

	/**
	 * Updates an existing user
	 * 
	 * @param user
	 *            The user to be updated
	 */
	public void updateUser(UserDTO user);

	/**
	 * Deletes an existing user from the database 
	 * @param email The cpf belonging to the user to be deleted
	 */
	public void deleteUser(String cpf);
	
	/**
	 * Finds user by their cpf
	 * @param cpf The cpf to be searched
	 * @return The user with the given cpf
	 */
	public UserDTO findByCpf(String cpf);

}
