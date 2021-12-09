package pl.patryklubik.cqrs.commands;

import pl.patryklubik.cqrs.model.Item;


/**
 * Create by Patryk Łubik on 09.12.2021.
 */

public interface CommandsJdbcManager {

    Item save(Item item);
}
