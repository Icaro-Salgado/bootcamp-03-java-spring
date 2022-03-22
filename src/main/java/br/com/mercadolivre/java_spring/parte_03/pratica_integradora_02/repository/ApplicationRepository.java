package br.com.mercadolivre.java_spring.parte_03.pratica_integradora_02.repository;

import br.com.mercadolivre.java_spring.parte_03.pratica_integradora_02.model.Ingredient;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ApplicationRepository<T> {
    List<T> list();
    Optional<T> find(UUID id);
    UUID add(T toAdd);
    List<UUID> add(List<T> listToAdd);
}
