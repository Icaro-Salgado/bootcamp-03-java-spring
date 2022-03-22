package br.com.mercadolivre.java_spring.parte_03.pratica_integradora_02.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Dish {
    private UUID id;
    private String name;
    private Double weight;
    private List<Ingredient> ingredients;
}
