package br.com.mercadolivre.java_spring.parte_03_pratica_integradora_01.service;

import br.com.mercadolivre.java_spring.parte_03_pratica_integradora_01.model.Personagem;
import br.com.mercadolivre.java_spring.parte_03_pratica_integradora_01.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
