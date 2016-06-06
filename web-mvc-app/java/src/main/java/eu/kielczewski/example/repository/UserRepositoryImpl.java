package eu.kielczewski.example.repository;

import eu.kielczewski.example.domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author elvis
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 6/3/16 5:38 PM
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

	@Inject
	private JdbcTemplate jdbcTemplate;

	@Override
	public User findOne(String id) {
		return jdbcTemplate.query("SELECT * FROM user WHERE id=?", new Object[]{id}, new ResultSetExtractor<User>() {
			@Override
			public User extractData(final ResultSet rs) throws SQLException, DataAccessException {
				final User user = new User(rs.getString("id"), rs.getString("password"));
				return user;
			}
		});
	}

	@Override
	public User save(User user) {
		final List<Object[]> objects = new ArrayList<>();
		objects.add(new Object[]{Long.toString(System.nanoTime()), user.getPassword()});
		jdbcTemplate.batchUpdate("INSERT INTO user(id, password) VALUES (?,?)", objects);
		return user;
	}

	@Override
	public List<User> findAll() {
		return jdbcTemplate.query("SELECT * FROM user", new RowMapper<User>() {
			@Override
			public User mapRow(final ResultSet rs, int rowNum) throws SQLException, DataAccessException {
				final User user = new User(rs.getString("id"), rs.getString("password"));
				return user;
			}
		});
	}
}
