package pl.java.borowiec.jdbc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import pl.java.borowiec.jdbc.dao.UserJdbcRepository;
import pl.java.borowiec.user.User;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogDao
 *         Creating time : 06-04-2013 13:41:05
 */
@Repository("userJdbcRepository")
@Profile("jdbc")
public class UserJdbcRepositoryImpl implements UserJdbcRepository {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	private SimpleJdbcInsert insertUser;

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public UserJdbcRepositoryImpl(DataSource dataSource, NamedParameterJdbcTemplate namedParameterJdbcTemplate, JdbcTemplate jdbcTemplate) {
		super();
		this.insertUser = new SimpleJdbcInsert(dataSource).withTableName("User").usingGeneratedKeyColumns("id");
		this.jdbcTemplate = jdbcTemplate;
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public User findById(long id) throws DataAccessException {
		Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        User user = this.namedParameterJdbcTemplate.queryForObject(
                "SELECT id, login, firstName,lastName,password,active,email,sex,birthDate,photo,phoneNumber FROM User WHERE id=:id",
                params,
                new ParameterizedRowMapper<User>(){
					@Override
					public User mapRow(ResultSet rs, int rowNum) throws SQLException {
					      User user = new User();
					      user.setId(rs.getLong("id"));
					      user.setActive(rs.getBoolean("active"));
					      user.setBirthDate(rs.getDate("birthDate"));
					      user.setEmail(rs.getString("email"));
					      user.setLogin(rs.getString("login"));
					      user.setFirstName(rs.getString("firstName"));
					      user.setLastName(rs.getString("lastName"));
					      user.setPhoto(rs.getBytes("photo"));
					      user.setPhoneNumber(rs.getString("phoneNumber"));
					      
					   
					      		
						return user;
					}
                	
                });
		return user;
	}

	@Override
	public void save(User user) throws DataAccessException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> getAllUser() throws DataAccessException {
		List<User> users = new ArrayList<>();
		users.addAll(this.jdbcTemplate.query(
				"SELECT id, login, firstName,lastName,password,active,email,sex,birthDate,photo,phoneNumber FROM User ORDER BY login",
				ParameterizedBeanPropertyRowMapper.newInstance(User.class)));
		return users;
	}

	@Override
	public User findByLogin(String login) throws DataAccessException {
		Map<String, Object> params = new HashMap<>();
        params.put("login", login);
        User user = this.namedParameterJdbcTemplate.queryForObject(
                "SELECT id, login, firstName,lastName,password,active,email,sex,birthDate,photo,phoneNumber FROM User WHERE login=:login",
                params,
                new ParameterizedRowMapper<User>(){
					@Override
					public User mapRow(ResultSet rs, int rowNum) throws SQLException {
					      User user = new User();
					      user.setId(rs.getLong("id"));
					      user.setActive(rs.getBoolean("active"));
					      user.setBirthDate(rs.getDate("birthDate"));
					      user.setEmail(rs.getString("email"));
					      user.setLogin(rs.getString("login"));
					      user.setFirstName(rs.getString("firstName"));
					      user.setLastName(rs.getString("lastName"));
					      user.setPhoto(rs.getBytes("photo"));
					      user.setPhoneNumber(rs.getString("phoneNumber"));
					      
					   
					      		
						return user;
					}
                	
                });
		return user;
	}

	@Override
	public int remove(User user) {
		return this.jdbcTemplate.update("DELETE FROM User WHERE id=?", user.getId());
	}

	@Override
	public List<User> findByLastName(String lastName) throws DataAccessException {
		Map<String, Object> params = new HashMap<>();
		params.put("lastName", lastName + "%");
		List<User> users = this.namedParameterJdbcTemplate.query(
				"SELECT id, login, firstName,lastName,password,active,email,sex,birthDate,photo,phoneNumber FROM User WHERE lastName like :lastName", params,
				ParameterizedBeanPropertyRowMapper.newInstance(User.class));

		return users;

	}
	@Override
	public int countAll() {
		String sql = "SELECT COUNT(*) FROM User";
		int count = jdbcTemplate.queryForInt(sql);
		return count;
		}
}
