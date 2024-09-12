package de.ricardo.javarickandmorthyapi;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Character {
    private int id;
    private String name;
    private String species;
    private String status;
}
