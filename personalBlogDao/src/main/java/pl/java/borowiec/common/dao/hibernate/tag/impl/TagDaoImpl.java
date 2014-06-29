package pl.java.borowiec.common.dao.hibernate.tag.impl;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import pl.java.borowiec.common.dao.hibernate.AbstractHibernateDao;
import pl.java.borowiec.common.dao.hibernate.TagDao;
import pl.java.borowiec.tag.Tag;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogDao
 *         Creating time : 04-04-2013 23:55:13
 */
@Repository("tagDao")
@Profile("hibernate")
public class TagDaoImpl extends AbstractHibernateDao<Tag> implements TagDao {

	public TagDaoImpl() {
		super(Tag.class);
	}

	@Override
	public List<Tag> getTagByName(String name) {
		return getCurrentSession().createQuery("From Tag where name = :name").setParameter("name", name).list();

	}

}
