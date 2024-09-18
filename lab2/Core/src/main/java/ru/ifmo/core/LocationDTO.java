package ru.ifmo.core;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationDTO {

    private Integer id;

    @NotNull
    private Integer x;

    @NotNull
    private Double y;

    @NotNull
    private Double z;

    @Size(max = 729)
    private String name;
}