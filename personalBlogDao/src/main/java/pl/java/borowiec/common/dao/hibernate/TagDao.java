package pl.java.borowiec.common.dao.hibernate;

import java.util.List;

import pl.java.borowiec.tag.Tag;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogDao
 *         Creating time : 06-04-2013 16:51:53
 */
public interface TagDao {

	void save(Tag tag);

	void remove(Tag tag);

	Tag findById(Long id);

	List<Tag> getTagByName(String name);

	List<Tag> getAll();

	long countAll();
}
