package br.com.mercadolivre.java_spring.parte_03.pratica_integradora_02.repository;

import br.com.mercadolivre.java_spring.parte_03.pratica_integradora_02.model.Dish;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class DishRepository implements ApplicationRepository<Dish> {

    private final ArrayList<Dish> dishes = new ArrayList<>();

    @Override
    public List<Dish> list() {
        return dishes;
    }

    @Override
    public Optional<Dish> find(UUID id) {
        return dishes.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    @Override
    public UUID add(Dish toAdd) {
        if (toAdd.getId() == null) {
            toAdd.setId(UUID.randomUUID());
        }

        dishes.add(toAdd);
        return toAdd.getId();
    }

    @Override
    public List<UUID> add(List<Dish> listToAdd) {
        List<UUID> newIDS = new ArrayList<>();

        for (Dish dish: listToAdd) {
            newIDS.add(this.add(dish));
        }

        return newIDS;
    }
}
