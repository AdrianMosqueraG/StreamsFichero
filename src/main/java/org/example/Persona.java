package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {

    private Optional<String> nombre;
    private Optional<String> poblacion;
    private Optional<Integer> edad;
}
