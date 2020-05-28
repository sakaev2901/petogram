package ru.itis.repositories.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.models.User;
import ru.itis.repositories.UsersRepository;

import java.sql.PreparedStatement;
import java.util.List;

public class UserRepositoryJdbcTemplateImpl implements UsersRepository {

    private static final String SAVE = "INSERT INTO users(name, username, password, mail, enabled) VALUES (?, ?, ?, ?, ?)";
    private static final String FIND_BY_USERNAME = "SELECT * FROM users where username = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<User> userRowMapper = (row, rowNum) ->
            User.builder()
                    .name(row.getString("name"))
                    .mail(row.getString("mail"))
                    .enabled(row.getBoolean("enabled"))
                    .username(row.getString("username"))
                    .id(row.getLong("id"))
                    .build();


    @Override
    public void save(User model) {
        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(SAVE);
            statement.setString(1, model.getName());
            statement.setString(2, model.getUsername());
            statement.setString(3, model.getPassword());
            statement.setString(4, model.getMail());
            statement.setBoolean(5, model.getEnabled());
            return statement;
        });
    }

    @Override
    public User findByUsername(String username) {
        User user = jdbcTemplate.queryForObject(FIND_BY_USERNAME, new Object[]{username}, userRowMapper);
        return user;
    }

    @Override
    public void update(User user, User following) {

    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void saveFollowing(User following) {

    }
}
