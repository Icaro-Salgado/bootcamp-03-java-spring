package br.com.mercadolivre.java_spring.parte_03.pratica_integradora_02.repository;

import br.com.mercadolivre.java_spring.parte_03.pratica_integradora_02.model.Ingredient;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class IngredientRepository implements ApplicationRepository<Ingredient> {

    private ArrayList<Ingredient> ingredients = new ArrayList<>();

    @Override
    public List<Ingredient> list() {
        return ingredients;
    }

    @Override
    public Optional<Ingredient> find(UUID id) {
        return ingredients.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    @Override
    public UUID add(Ingredient toAdd) {
        if (toAdd.getId() == null)
            toAdd.setId(UUID.randomUUID());

        ingredients.add(toAdd);
        return toAdd.getId();
    }

    @Override
    public List<UUID> add(List<Ingredient> listToAdd) {
        List<UUID> newIDS = new ArrayList<>();

        for (Ingredient ingredient: listToAdd) {
            newIDS.add(this.add(ingredient));
        }

        return newIDS;
    }
}
