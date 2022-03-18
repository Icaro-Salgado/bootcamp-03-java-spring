package br.com.mercadolivre.java_spring.parte_02.pratica_integradora_02.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private Integer id;
    private String nome, sobrenome;
    private Integer idade;
}
