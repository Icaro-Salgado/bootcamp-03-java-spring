package br.com.mercadolivre.java_spring.parte_03.pratica_integradora_01.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Personagem {

    private String name, hairColor, skinColor, eyeColor, birthYear, gender, homeworld, species;
    private int height, mass;
    private int id;
}
