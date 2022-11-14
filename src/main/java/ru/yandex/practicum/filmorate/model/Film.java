package ru.yandex.practicum.filmorate.model;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
public class Film {

    private long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Description is required")
    @Size(max=200, message="Description must be no longer than 200 characters")
    private String description;

    @Positive(message="Duration must be positive")
    private int duration;

    private MPA mpa;

    private Set<Genre> genres;

    private long likes_count;

    @NotNull
    private LocalDate releaseDate;

    private static final LocalDate CINEMA_BIRTHDAY = LocalDate.of(1895, 12, 28);

    @AssertTrue(message = "Release date should be later than 28.12.1895")
    private boolean isAfterCinemaBirthday() {
        return releaseDate.isAfter(CINEMA_BIRTHDAY);
    }

}
