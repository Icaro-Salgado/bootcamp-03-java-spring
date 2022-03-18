package br.com.mercadolivre.java_spring.parte_02.pratica_integradora_02.service;

import br.com.mercadolivre.java_spring.parte_02.pratica_integradora_02.model.Sport;
import br.com.mercadolivre.java_spring.parte_02.pratica_integradora_02.repo.SportsRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class SportsService {

    private static SportsRepo sports = new SportsRepo();

    public ArrayList<Sport> list() {
        return sports.get();
    }

    public Optional<Sport> find(String name) {
        return sports.get().stream()
                .filter(sport -> sport.getNome().equals(name)).findFirst();
    }
}
