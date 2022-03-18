package br.com.mercadolivre.java_spring.parte_02.pratica_integradora_02.repo;

import br.com.mercadolivre.java_spring.parte_02.pratica_integradora_02.model.Sport;

import java.util.ArrayList;
import java.util.Optional;

public class SportsRepo implements Repo<Sport> {
    private static ArrayList<Sport> sports = new ArrayList<>();

    // Para ja iniciar com os esportes carregados
    static {
        sports.add(new Sport(1, "Futebol", 7));
        sports.add(new Sport(2,"MMA", 10));
        sports.add(new Sport(3, "Golf", 5));
        sports.add(new Sport(4, "Volei", 8));
        sports.add(new Sport(5, "Futsal", 6));
        sports.add(new Sport(6, "Capoeira", 10));
    }

    @Override
    public void salvar(Sport obj) {
        sports.add(obj);
    }

    @Override
    public ArrayList<Sport> get() {
        return sports;
    }

    @Override
    public Optional<Sport> get(Integer id) {
        return sports.stream().filter(sport -> sport.getId().equals(id)).findFirst();
    }
}
