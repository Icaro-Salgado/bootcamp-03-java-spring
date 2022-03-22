package br.com.mercadolivre.java_spring.parte_03.pratica_integradora_02.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ingredient {

    private String name;
    private Integer calories;
}
