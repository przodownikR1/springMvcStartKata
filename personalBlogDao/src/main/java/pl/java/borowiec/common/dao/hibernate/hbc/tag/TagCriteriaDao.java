package pl.java.borowiec.common.dao.hibernate.hbc.tag;

import java.util.List;

import org.hibernate.criterion.Expression;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import pl.java.borowiec.common.dao.hibernate.AbstractHibernateDao;
import pl.java.borowiec.common.dao.hibernate.TagDao;
import pl.java.borowiec.tag.Tag;
@Repository("tagCriteriaDao")
@Profile("hibernate")
public class TagCriteriaDao extends AbstractHibernateDao<Tag> implements TagDao{

	public TagCriteriaDao() {
		super(Tag.class);

	}

	@Override
	public List<Tag> getTagByName(String name) {
		return  getCurrentSession().createCriteria(Tag.class).add(Expression.eq("name", name)).list();
		
	}

	
}
