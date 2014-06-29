package pl.java.borowiec.common.dao.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.google.common.base.Preconditions;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogDao
 *         Creating time : 06-04-2013 16:53:35
 */
public abstract class AbstractCriteriaJpaDao<T extends Serializable> {
	@PersistenceContext
	protected EntityManager em;

	private final Class<T> clazz;

	public AbstractCriteriaJpaDao(final Class<T> clazzToSet) {
		this.clazz = clazzToSet;
	}

	public T findById(final Long id) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<T> c = cb.createQuery(clazz);
		Root<T> root = c.from(clazz);
		c.select(root).where(cb.equal(root.get("id").as(Long.class), id));
		TypedQuery<T> q = em.createQuery(c);
		return q.getSingleResult();
	}

	public List<T> getAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<T> c = cb.createQuery(clazz);
		Root<T> root = c.from(clazz);
		c.select(root);
		TypedQuery<T> q = em.createQuery(c);
		return q.getResultList();
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
		CriteriaBuilder qb = em.getCriteriaBuilder();
		CriteriaQuery<Long> cq = qb.createQuery(Long.class);
		cq.select(qb.count(cq.from(clazz)));
		return em.createQuery(cq).getSingleResult();
	}

}
