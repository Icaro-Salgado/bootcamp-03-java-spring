package br.com.mercadolivre.java_spring.parte_02.pratica_integradora_02.repo;

import java.util.ArrayList;
import java.util.Optional;

public interface Repo <T>{
    void salvar(T obj);
    ArrayList<T> get();
    Optional<T> get(Integer id);
}
