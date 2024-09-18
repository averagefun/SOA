package ru.ifmo.core;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "routes")
@Data
@NoArgsConstructor
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(min = 1)
    @Column(nullable = false)
    private String name;

    @NotNull
    @Embedded
    private Coordinates coordinates;

    @NotNull
    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "from_location_id", nullable = false)
    private Location from;

    @ManyToOne
    @JoinColumn(name = "to_location_id", nullable = false)
    private Location to;

    @Min(2)
    @NotNull
    @Column(nullable = false)
    private Integer distance;
}
