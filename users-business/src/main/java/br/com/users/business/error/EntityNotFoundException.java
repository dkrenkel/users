/**
 * 
 */
package br.com.users.business.error;

/**
 * @author David Krenkel <david.melo1992@gmail.com>
 *
 */
public class EntityNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public EntityNotFoundException(String msg) {
		super(msg);
	}
	
	public EntityNotFoundException() {
		super();
	}

}
