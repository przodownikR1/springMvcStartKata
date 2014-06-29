package pl.java.borowiec.common.dao.jpa.criteria.tag;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import pl.java.borowiec.common.dao.jpa.AbstractCriteriaJpaDao;
import pl.java.borowiec.common.dao.jpa.TagDao;
import pl.java.borowiec.tag.Tag;
/**
 * @author Sławomir Borowiec 
 * Module name : personalBlogDao
 * Creating time :  06-04-2013 21:00:51
 
 */
@Repository("tagCriteriaDao")
@Profile("jpa")
public class TagCriteriaDaoImpl extends AbstractCriteriaJpaDao<Tag> implements TagDao{

	public TagCriteriaDaoImpl() {
		super(Tag.class);

	}
	

	public TagCriteriaDaoImpl(Class<Tag> clazzToSet) {
		super(clazzToSet);
		// TODO Auto-generated constructor stub
	}


	@Override
	public List<Tag> getTagByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}




	
}
