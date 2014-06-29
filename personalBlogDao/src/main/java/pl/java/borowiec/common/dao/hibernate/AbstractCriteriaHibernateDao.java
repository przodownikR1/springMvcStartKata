package pl.java.borowiec.common.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.base.Preconditions;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogDao
 *         Creating time : 06-04-2013 16:52:02
 */
public abstract class AbstractCriteriaHibernateDao<T extends Serializable> {
	private final Class<T> clazz;
	@Autowired
	SessionFactory sessionFactory;

	public AbstractCriteriaHibernateDao(final Class<T> clazzToSet) {
		this.clazz = clazzToSet;
	}

	public T findById(final Long id) {
		Preconditions.checkArgument(id != null);
		return (T) this.getCurrentSession().get(this.clazz, id);
	}

	public List<T> getAll() {
		return this.getCurrentSession().createQuery("FROM " + this.clazz.getName()).list();
	}

	public void save(final T entity) {
		Preconditions.checkNotNull(entity);
		this.getCurrentSession().persist(entity);
	}

	public T update(final T entity) {
		Preconditions.checkNotNull(entity);
		return (T) this.getCurrentSession().merge(entity);
	}

	public void remove(final T entity) {
		Preconditions.checkNotNull(entity);
		this.getCurrentSession().delete(entity);
	}

	public void removeById(final Long entityId) {
		final T entity = this.findById(entityId);
		Preconditions.checkState(entity != null);
		this.remove(entity);
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected final Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public long countAll() {
		return (Long) sessionFactory.getCurrentSession().createQuery("Select count(*) FROM " + this.clazz.getName()).uniqueResult();
	}
}
