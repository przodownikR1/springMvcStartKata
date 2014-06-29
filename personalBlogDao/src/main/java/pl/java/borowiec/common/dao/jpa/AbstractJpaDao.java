package pl.java.borowiec.common.dao.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.google.common.base.Preconditions;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogDao
 *         Creating time : 06-04-2013 16:51:49
 * @param <T>
 */
public class AbstractJpaDao<T extends Serializable> {

	private final Class<T> clazz;

	@PersistenceContext
	protected EntityManager em;

	public AbstractJpaDao(final Class<T> clazzToSet) {
		this.clazz = clazzToSet;
	}

	public T findById(final Long id) {
		Preconditions.checkArgument(id != null);
		return em.find(clazz, id);
	}

	public List<T> getAll() {
		return em.createQuery("FROM " + this.clazz.getName(), clazz).getResultList();
	}

	public void save(final T entity) {
		Preconditions.checkNotNull(entity);
		em.persist(entity);
	}

	public T update(final T entity) {
		Preconditions.checkNotNull(entity);
		return em.merge(entity);
	}

	public void remove(final T entity) {
		Preconditions.checkNotNull(entity);
		em.remove(entity);
	}

	public void removeById(final Long entityId) {
		final T entity = this.findById(entityId);
		Preconditions.checkState(entity != null);
		this.remove(entity);
	}

	public long countAll() {
		return em.createQuery("Select count(*) FROM " + this.clazz.getName(), Long.class).getSingleResult();
	}

}
