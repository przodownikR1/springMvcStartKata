package pl.java.borowiec.jdbc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import pl.java.borowiec.jdbc.dao.TagJdbcRepository;
import pl.java.borowiec.tag.Tag;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogDao
 *         Creating time : 06-04-2013 13:47:35
 */
@Repository("tagJdbcRepository")
@Profile("jdbc")
public class TagJdbcRepositoryImpl implements TagJdbcRepository {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	private SimpleJdbcInsert insertTag;

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public TagJdbcRepositoryImpl(DataSource dataSource, NamedParameterJdbcTemplate namedParameterJdbcTemplate, JdbcTemplate jdbcTemplate) {
		super();
		this.insertTag = new SimpleJdbcInsert(dataSource).withTableName("Tag").usingGeneratedKeyColumns("id");
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Tag findTagByName(String name) {
		 final List<Tag> tags = this.jdbcTemplate.query(
	                "SELECT id, name, date_added , date_modyfication  FROM Tag WHERE name=?", new ParameterizedRowMapper<Tag>() {
	                    @Override
	                    public Tag mapRow(ResultSet rs, int row) throws SQLException {
	                        Tag tag = new Tag();
	                        tag.setId(rs.getLong("id"));
	                        tag.setName(rs.getString("name"));
	                        tag.setDateAdded(rs.getDate("date_added"));
	                        tag.setDateModyfication(rs.getDate("date_modyfication"));
	                        return tag;
	                    }
	                },name);
		 if(!tags.isEmpty()){
		        return tags.get(0);
			  }
			  return null;
	}

	@Override
	public Tag getTagById(long id) {
		  final List<Tag> tags = this.jdbcTemplate.query(
	                "SELECT id, name, date_added , date_modyfication  FROM Tag WHERE id=?", new ParameterizedRowMapper<Tag>() {
	                    @Override
	                    public Tag mapRow(ResultSet rs, int row) throws SQLException {
	                        Tag tag = new Tag();
	                        tag.setId(rs.getLong("id"));
	                        tag.setName(rs.getString("name"));
	                        tag.setDateAdded(rs.getDate("date_added"));
	                        tag.setDateModyfication(rs.getDate("date_modyfication"));
	                        return tag;
	                    }
	                },id);
		  if(!tags.isEmpty()){
	        return tags.get(0);
		  }
		  return null;
		
	}

	private MapSqlParameterSource createTagParameterSource(Tag tag) {
		return new MapSqlParameterSource().addValue("id", tag.getId()).addValue("name", tag.getName()).addValue("date_added", tag.getDateAdded());

	}

	@Override
	public long save(Tag tag) {
		BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(tag);
		if (tag.getId() == null) {
			Number newKey = this.insertTag.executeAndReturnKey(createTagParameterSource(tag));
			tag.setId(new Long(newKey.intValue()));
			return tag.getId();
		} 	
	        return new Long(this.namedParameterJdbcTemplate.update("UPDATE tag SET name=:name  WHERE id=:id",parameterSource));
			//throw new UnsupportedOperationException("Tag update not supported");
	}

	@Override
	public int update(Tag tag) {
		BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(tag);
		 return this.namedParameterJdbcTemplate.update("UPDATE tag SET name=:name  WHERE id=:id",parameterSource);
	}

	@Override
	public int remove(Tag tag) {
		return this.jdbcTemplate.update("DELETE FROM Tag WHERE id=?", tag.getId());

	}

	@Override
	public List<Tag> getAllTag() {
		 final List<Tag> tags = this.jdbcTemplate.query(
	                "SELECT id, name, date_added , date_modyfication  FROM Tag ", new ParameterizedRowMapper<Tag>() {
	                    @Override
	                    public Tag mapRow(ResultSet rs, int row) throws SQLException {
	                        Tag tag = new Tag();
	                        tag.setId(rs.getLong("id"));
	                        tag.setName(rs.getString("name"));
	                        tag.setDateAdded(rs.getDate("date_added"));
	                        tag.setDateModyfication(rs.getDate("date_modyfication"));
	                        return tag;
	                    }
	                });
		 return tags;
	}
	@Override
	public int countAll(){
		String sql = "SELECT COUNT(*) FROM Tag";
		int count = jdbcTemplate.queryForInt(sql);
		return count;
	}
}
