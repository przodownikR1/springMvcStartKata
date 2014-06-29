package pl.java.borowiec.common.dao.jpa.performance;

import java.util.List;

/**
 * @author Sławomir Borowiec 
 * Module name : personalBlogDao
 * Creating time :  09-04-2013 00:37:23
 
 * @param <T>
 */
public interface GenericDao<T> {

	T findById(final Long id);

	List<T> getAll();

	void save(final T entity);

	T update(final T entity);

	void remove(final T entity);

	void removeById(final Long entityId);

	long countAll();

}
