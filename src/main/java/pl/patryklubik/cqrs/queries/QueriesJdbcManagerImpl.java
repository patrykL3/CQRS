package pl.patryklubik.cqrs.queries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import pl.patryklubik.cqrs.model.Item;

import java.util.Optional;
import java.util.UUID;


/**
 * Create by Patryk Łubik on 09.12.2021.
 */

@Component
public class QueriesJdbcManagerImpl implements QueriesJdbcManager {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public QueriesJdbcManagerImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<Item> findById(UUID id) {
        final String sql = "SELECT id, name FROM items WHERE id =?";
        Item item = jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                (resultSet, i) -> {
                    UUID dataId = UUID.fromString(resultSet.getString("id"));
                    String name = resultSet.getString("name");
                    return new Item(dataId, name);
                });
        return Optional.ofNullable(item);
    }
}
