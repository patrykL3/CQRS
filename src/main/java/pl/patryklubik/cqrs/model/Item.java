package pl.patryklubik.cqrs.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;
import java.util.UUID;


/**
 * Create by Patryk Łubik on 09.12.2021.
 */
public class Item {

    private final UUID id;

    @NotBlank
    private final String name;

    public Item(@JsonProperty("id") UUID id, @JsonProperty("name")String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
