package br.com.mercadolivre.java_spring.parte_03.pratica_integradora_02.controller;

import br.com.mercadolivre.java_spring.parte_03.pratica_integradora_02.model.Ingredient;
import br.com.mercadolivre.java_spring.parte_03.pratica_integradora_02.service.IngredientsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.UUID;

@RestController
public class IngredientController {

    private final IngredientsService ingredientsService;

    public IngredientController(IngredientsService ingredientsService) {
        this.ingredientsService = ingredientsService;
    }

    @GetMapping("/ingredients/")
    public ResponseEntity<List<Ingredient>> listAll() {
        return ResponseEntity.ok(ingredientsService.list());
    }

    @GetMapping("/ingredients/{id}")
    public ResponseEntity<Ingredient> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(ingredientsService.find(id));
    }
}
