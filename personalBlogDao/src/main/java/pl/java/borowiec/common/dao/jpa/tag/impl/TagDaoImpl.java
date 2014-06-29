package pl.java.borowiec.common.dao.jpa.tag.impl;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import pl.java.borowiec.common.dao.jpa.AbstractJpaDao;
import pl.java.borowiec.common.dao.jpa.TagDao;
import pl.java.borowiec.tag.Tag;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogDao
 *         Creating time : 04-04-2013 23:55:13
 */
@Repository("tagDao")
@Profile("jpa")
public class TagDaoImpl extends AbstractJpaDao<Tag> implements TagDao {

	

	public TagDaoImpl() {
		super(Tag.class);

	}
	

	public TagDaoImpl(Class<Tag> clazzToSet) {
		super(clazzToSet);
		// TODO Auto-generated constructor stub
	}


	@Override
	public List<Tag> getTagByName(String name) {
		return em.createQuery("From Tag tag WHERE tag.name = :name ",Tag.class).setParameter("name", name).getResultList();
	}

	}
