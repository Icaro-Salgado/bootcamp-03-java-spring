package br.com.mercadolivre.java_spring.parte_02.pratica_integradora_02.controller;

import br.com.mercadolivre.java_spring.parte_02.pratica_integradora_02.serializer.AthleteDTO;
import br.com.mercadolivre.java_spring.parte_02.pratica_integradora_02.model.Sport;
import br.com.mercadolivre.java_spring.parte_02.pratica_integradora_02.service.AthletesService;
import br.com.mercadolivre.java_spring.parte_02.pratica_integradora_02.service.SportsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class SportsController {
    private static final SportsService sportsService = new SportsService();
    private static final AthletesService athleteService = new AthletesService();

    @GetMapping("/findSports")
    public ArrayList<Sport> findSports() {
        return sportsService.list();
    }

    @GetMapping("findSports/{name}")
    public ResponseEntity<Sport> findSportByName(@PathVariable(name="name") String name) throws NoSuchElementException{
        Optional<Sport> foundSport = sportsService.find(name);

        if (foundSport.isPresent()) {
            return new ResponseEntity<>(foundSport.get(), HttpStatus.OK);
        } else {
            throw new NoSuchElementException("Não encontrado");
        }
    }

    @GetMapping("/findSportsPersons")
    public List<AthleteDTO> findSportsPersons() {
        return athleteService.list();
    }

}
