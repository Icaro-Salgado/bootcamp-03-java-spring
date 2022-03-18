package br.com.mercadolivre.java_spring.parte_02.pratica_integradora_02.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sport {
    private Integer id;
    private String nome;
    private Integer nivel;
}
