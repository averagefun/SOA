package ru.ifmo.core;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoordinatesDTO {

    @Min(-491)
    @NotNull
    private Integer x;

    @NotNull
    private Double y;
}
