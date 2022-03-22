package br.com.mercadolivre.java_spring.parte_03.pratica_integradora_02.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@Repository
//public class PersonagemRepository implements ApplicationRepository<Personagem> {
//
//    private ArrayList<Personagem> personagens = new ArrayList<>();
//
//    @Override
//    public ArrayList<Personagem> read() {
//        return personagens;
//    }
//
//    @Override
//    public Optional<Personagem> find(int id) {
//        return personagens.stream().filter(p -> p.getId() == id).findFirst();
//    }
//
//    @Override
//    public void add(Personagem toAdd) {
//        personagens.add(toAdd);
//    }
//
//    @Override
//    public void add(List<Personagem> listToAdd) {
//        listToAdd.forEach(personagens::add);
//    }
//}
