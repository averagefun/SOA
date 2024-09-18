package ru.ifmo.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class RouteDTO {

    private Integer id;

    @NotBlank
    @Size(min = 1)
    private String name;

    @NotNull
    private Coordinates coordinates;

    private LocalDateTime creationDate;

    private LocationDTO from;
    private LocationDTO to;

    @Min(2)
    @NotNull
    private Integer distance;
}