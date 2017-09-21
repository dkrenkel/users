/**
 * 
 */
package br.com.users.core.service;

import java.io.Serializable;

import javax.persistence.EntityExistsException;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.users.model.BaseEntity;

/**
 * @author David Krenkel <david.melo1992@gmail.com>
 *
 */
public abstract class AbstractService<T extends BaseEntity<I>, I extends Serializable> {

	public abstract JpaRepository<T, I> getRepository();

	@Transactional
	public T create(T entity) {
		if (entity.getId() != null && getRepository().exists(entity.getId()))
			throw new EntityExistsException();
		getRepository().save(entity);
		return entity;
	}
}
