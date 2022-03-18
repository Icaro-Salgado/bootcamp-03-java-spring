package br.com.mercadolivre.java_spring.parte_02.pratica_integradora_02.service;

import br.com.mercadolivre.java_spring.parte_02.pratica_integradora_02.model.Person;
import br.com.mercadolivre.java_spring.parte_02.pratica_integradora_02.model.Sport;
import br.com.mercadolivre.java_spring.parte_02.pratica_integradora_02.repo.PersonRepo;
import br.com.mercadolivre.java_spring.parte_02.pratica_integradora_02.repo.SportsRepo;
import br.com.mercadolivre.java_spring.parte_02.pratica_integradora_02.serializer.AthleteDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class AthletesService {

    private static ArrayList<AthleteDTO> athletes = new ArrayList<>();
    private static PersonRepo personRepo = new PersonRepo();
    private static SportsRepo sportsRepo = new SportsRepo();

    static {
        athletes.add(new AthleteDTO(personRepo.get(1).get(), sportsRepo.get(1).get()));
        athletes.add(new AthleteDTO(personRepo.get(2).get(), sportsRepo.get(2).get()));
        athletes.add(new AthleteDTO(personRepo.get(3).get(), sportsRepo.get(3).get()));
        athletes.add(new AthleteDTO(personRepo.get(4).get(), sportsRepo.get(4).get()));
    }

    public List<AthleteDTO> list() {
        return athletes;
    }
}
