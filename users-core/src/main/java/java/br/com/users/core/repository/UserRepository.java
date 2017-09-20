/**
 * 
 */
package java.br.com.users.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.users.model.User;

/**
 * @author David Krenkel <david.melo1992@gmail.com>
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {

	User findByCpf(String cpf);
	
}
