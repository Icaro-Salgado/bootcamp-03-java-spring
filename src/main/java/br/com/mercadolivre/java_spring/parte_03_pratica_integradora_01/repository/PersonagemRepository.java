package br.com.mercadolivre.java_spring.parte_03_pratica_integradora_01.repository;

import br.com.mercadolivre.java_spring.parte_03_pratica_integradora_01.model.Personagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonagemRepository implements ApplicationRepository<Personagem> {

    private ArrayList<Personagem> personagens = new ArrayList<>();

    @Override
    public ArrayList<Personagem> read() {
        return personagens;
    }

    @Override
    public Optional<Personagem> find(int id) {
        return personagens.stream().filter(p -> p.getId() == id).findFirst();
    }

    @Override
    public void add(Personagem toAdd) {
        personagens.add(toAdd);
    }

    @Override
    public void add(List<Personagem> listToAdd) {
        listToAdd.forEach(personagens::add);
    }
}
