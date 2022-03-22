package br.com.mercadolivre.java_spring.parte_03.pratica_integradora_02.service;

import br.com.mercadolivre.java_spring.parte_03.pratica_integradora_02.model.Ingredient;
import br.com.mercadolivre.java_spring.parte_03.pratica_integradora_02.repository.ApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class IngredientsService {

    private final ApplicationRepository<Ingredient> repository;

    public IngredientsService(ApplicationRepository<Ingredient> repository) {
        this.repository = repository;
    }

    public UUID addIngredient(Ingredient toAdd) {
        return repository.add(toAdd);
    }

    public List<UUID> addIngredient(List<Ingredient> toAdd) {
        return repository.add(toAdd);
    }

    public List<Ingredient> list() {
        return repository.list();
    }

    public Ingredient find(UUID id) {
        return repository.find(id).orElse(new Ingredient());
    }
}
