package br.com.mercadolivre.java_spring.parte_02.pratica_integradora_02.serializer;

import br.com.mercadolivre.java_spring.parte_02.pratica_integradora_02.model.Person;
import br.com.mercadolivre.java_spring.parte_02.pratica_integradora_02.model.Sport;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Data
@AllArgsConstructor
public class AthleteDTO {
    private String athleteName, athleteLastName, athleteSport;

    public AthleteDTO(Person person, Sport sport){
        this.athleteName = person.getNome();
        this.athleteLastName = person.getSobrenome();
        this.athleteSport = sport.getNome();
    }
}
