package br.com.mercadolivre.java_spring.parte_03.pratica_integradora_01.service;

import br.com.mercadolivre.java_spring.parte_03.pratica_integradora_01.model.Personagem;
import br.com.mercadolivre.java_spring.parte_03.pratica_integradora_01.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonagemService {

    private final ApplicationRepository<Personagem> repo;

    public PersonagemService(ApplicationRepository<Personagem> repo) {
        this.repo = repo;
    }

    public void add(List<Personagem> personagensToAdd) {
        personagensToAdd.forEach(repo::add);
    }

    public void add(Personagem personagemToAdd) {
        repo.add(personagemToAdd);
    }

    public List<Personagem> list() {
        return repo.read();
    }

    public Personagem find(int id) {
        return repo.find(id).orElse(new Personagem());
    }

    public List<Personagem> findByParcialName(String parcialName) {
        return repo.read().stream()
                .filter(p -> p.getName().toUpperCase().contains(parcialName.toUpperCase()))
                .collect(Collectors.toList());
    }
}
