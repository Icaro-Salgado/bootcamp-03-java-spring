package br.com.mercadolivre.java_spring.parte_02.pratica_integradora_01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@RestController
public class IdadeController {

    @GetMapping("/{dia}/{mes}/{ano}")
    public long calculaIdade(@PathVariable(name = "dia") int day,
                             @PathVariable(name = "mes") int month,
                             @PathVariable(name = "ano") int year) {

        return ChronoUnit.YEARS.between(LocalDate.of(year, month, day), LocalDate.now());
    }
}
