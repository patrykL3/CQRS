package pl.patryklubik.cqrs.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import pl.patryklubik.cqrs.model.Item;

import java.util.UUID;


/**
 * Create by Patryk Łubik on 09.12.2021.
 */

@Component
public class CommandsJdbcManagerImpl implements CommandsJdbcManager {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CommandsJdbcManagerImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Item save(Item item) {
        UUID id = UUID.randomUUID();

        jdbcTemplate.update(
                "INSERT INTO items VALUES (?, ?)", id.toString(), item.getName());

        return new Item(id, item.getName());
    }
}
