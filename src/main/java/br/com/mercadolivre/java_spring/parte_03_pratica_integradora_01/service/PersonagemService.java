package br.com.mercadolivre.java_spring.parte_03_pratica_integradora_01.service;

import br.com.mercadolivre.java_spring.parte_03_pratica_integradora_01.model.Personagem;
import br.com.mercadolivre.java_spring.parte_03_pratica_integradora_01.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonagemService {

    @Autowired
    private PersonagemRepository personagemRepository;

    public void add(List<Personagem> personagensToAdd) {
        personagensToAdd.forEach(personagemRepository::add);
    }

    public void add(Personagem personagemToAdd) {
        personagemRepository.add(personagemToAdd);
    }

    public List<Personagem> list() {
        return personagemRepository.read();
    }

    public Personagem find(int id) {
        return personagemRepository.find(id).orElse(new Personagem());
    }

    public List<Personagem> findByParcialName(String parcialName) {
        return personagemRepository.read().stream()
                .filter(p -> p.getName().toUpperCase().contains(parcialName.toUpperCase()))
                .collect(Collectors.toList());
    }
}
