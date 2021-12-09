package pl.patryklubik.cqrs.queries;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pl.patryklubik.cqrs.model.Item;

import java.util.Optional;
import java.util.UUID;


/**
 * Create by Patryk Łubik on 09.12.2021.
 */

@RestController
@RequestMapping("/item")
public class QueriesController {

    private final QueriesJdbcManager jdbcManager;

    public QueriesController(QueriesJdbcManager jdbcManager) {
        this.jdbcManager = jdbcManager;
    }


    @GetMapping(path = "{id}")
    ResponseEntity<Optional<Item>> getItemById(@PathVariable("id") UUID id) {

        return ResponseEntity.ok(jdbcManager.findById(id));
    }
}
