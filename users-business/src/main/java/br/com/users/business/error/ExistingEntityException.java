/**
 * 
 */
package br.com.users.business.error;

/**
 * @author David Krenkel <david.melo1992@gmail.com>
 *
 */
public class ExistingEntityException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public ExistingEntityException(String msg) {
		super(msg);
	}
	
	public ExistingEntityException() {
		super();
	}

}
