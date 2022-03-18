package br.com.mercadolivre.java_spring.parte_02.pratica_integradora_02.repo;

import br.com.mercadolivre.java_spring.parte_02.pratica_integradora_02.model.Person;

import java.util.ArrayList;
import java.util.Optional;

public class PersonRepo implements Repo<Person>{

    private static ArrayList<Person> people = new ArrayList<>();

    static {
        people.add(new Person(1, "Icaro", "Salgado", 23));
        people.add(new Person(2, "Anderson", "Silva", 25));
        people.add(new Person(3, "Gabriel", "Barbosa", 23));
        people.add(new Person(4, "Lebron", "James", 27));
    }

    @Override
    public void salvar(Person obj) {
        people.add(obj);
    }

    @Override
    public ArrayList get() {
        return people;
    }

    @Override
    public Optional<Person> get(Integer id) {
        return people.stream().filter(person -> person.getId().equals(id)).findFirst();
    }
}
