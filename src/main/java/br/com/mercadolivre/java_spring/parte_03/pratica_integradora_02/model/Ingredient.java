package br.com.mercadolivre.java_spring.parte_03.pratica_integradora_02.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {
    private UUID id;
    private String name;
    private Integer calories;
}
