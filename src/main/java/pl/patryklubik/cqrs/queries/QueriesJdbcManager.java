package pl.patryklubik.cqrs.queries;

import pl.patryklubik.cqrs.model.Item;

import java.util.Optional;
import java.util.UUID;


/**
 * Create by Patryk Łubik on 09.12.2021.
 */
public interface QueriesJdbcManager {

    Optional<Item> findById(UUID id);
}
