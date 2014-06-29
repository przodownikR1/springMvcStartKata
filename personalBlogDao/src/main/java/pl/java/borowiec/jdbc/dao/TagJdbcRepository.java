package pl.java.borowiec.jdbc.dao;

import java.util.List;

import pl.java.borowiec.tag.Tag;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogDao
 *         Creating time : 06-04-2013 13:45:52
 */
public interface TagJdbcRepository {
	Tag findTagByName(String name);

	Tag getTagById(long id);

	long save(Tag tag);

	int update(Tag tag);

	int remove(Tag tag);

	List<Tag> getAllTag();

	int countAll();
}
