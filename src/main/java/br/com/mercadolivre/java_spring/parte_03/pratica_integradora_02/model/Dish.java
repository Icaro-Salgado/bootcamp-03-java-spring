package br.com.mercadolivre.java_spring.parte_03.pratica_integradora_02.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Dish {

    private String name;
    private Double weight;
    private List<Ingredient> ingredients;

    public Dish() {
        this.ingredients = new ArrayList<Ingredient>();
    }

    public static Dish build() {
        return new Dish();
    }

    public Dish name(String name) {
        this.name = name;
        return this;
    }

    public Dish addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);

        return this;
    }
}
