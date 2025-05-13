package com.users.api.Dto;

import org.jetbrains.annotations.NotNull;

public record UserRequestDto(@NotNull String name, @NotNull String email) {
}
