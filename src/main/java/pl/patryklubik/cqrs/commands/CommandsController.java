package pl.patryklubik.cqrs.commands;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.patryklubik.cqrs.model.Item;

import javax.validation.Valid;


/**
 * Create by Patryk Łubik on 09.12.2021.
 */

@RestController
@RequestMapping("/item")
public class CommandsController {

    private final CommandsJdbcManager jdbcManager;

    public CommandsController(CommandsJdbcManager jdbcManager) {
        this.jdbcManager = jdbcManager;
    }

    @PostMapping
    ResponseEntity<Item> save(@Valid  @RequestBody Item item) {
        return ResponseEntity.ok(jdbcManager.save(item));
    }
}
