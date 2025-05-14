package com.users.api.Entity;

import java.util.UUID;

import com.users.api.Dto.UserRequestDto;
import org.jetbrains.annotations.NotNull;

public class User {
    private final UUID id;
    private final String name;
    private final String email;

    public User(UUID id, @NotNull String name, @NotNull String email) {
        this.id = (id != null) ? id : UUID.randomUUID();
        this.name = name;
        this.email = email;
    }

    public UUID getId() { return id; }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

}
