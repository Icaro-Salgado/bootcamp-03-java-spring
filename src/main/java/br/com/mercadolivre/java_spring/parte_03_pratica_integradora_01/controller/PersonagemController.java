package br.com.mercadolivre.java_spring.parte_03_pratica_integradora_01.controller;

import br.com.mercadolivre.java_spring.parte_03_pratica_integradora_01.dto.PersonagemDTO;
import br.com.mercadolivre.java_spring.parte_03_pratica_integradora_01.model.Personagem;
import br.com.mercadolivre.java_spring.parte_03_pratica_integradora_01.service.PersonagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.websocket.server.PathParam;
import java.net.URI;
import java.util.List;

@RestController
public class PersonagemController {

    @Autowired
    PersonagemService personagemService;

    @GetMapping("/personagens")
    public ResponseEntity<List<PersonagemDTO>> listaPersongagens() {
        List<PersonagemDTO> result = PersonagemDTO.convertToDTOList(personagemService.list());

        return ResponseEntity.ok(result);
    }

    @GetMapping("/personagens/{id}")
    public ResponseEntity<PersonagemDTO> listaPersonagem(@PathVariable int id) {
        Personagem personagem = personagemService.find(id);
        return ResponseEntity.ok(new PersonagemDTO().convert(personagem));
    }

    @GetMapping("/personagens/find/{name}")
    public ResponseEntity<List<PersonagemDTO>> listaPersonagem(@PathVariable String name) {
        List<Personagem> personagem = personagemService.findByParcialName(name);
        System.out.println(personagem);
        return ResponseEntity.ok(PersonagemDTO.convertToDTOList(personagem));
    }

    @PostMapping("/from-list")
    public ResponseEntity<List<PersonagemDTO>> savePersonagens(@RequestBody List<PersonagemDTO> personagensToAdd) {
        List<Personagem> personagens = PersonagemDTO.convertToObjectList(personagensToAdd);
        personagemService.add(personagens);

        return ResponseEntity.status(HttpStatus.CREATED).body(personagensToAdd);
    }

    @PostMapping("/personagens")
    public ResponseEntity<PersonagemDTO> savePersonagem(@RequestBody PersonagemDTO personagemToAdd, UriComponentsBuilder uriBuilder) {
        Personagem personagem = personagemToAdd.convert();
        personagemService.add(personagem);

        URI uri = uriBuilder
                .path("personagens/{id}")
                .buildAndExpand(personagem.getId())
                .toUri();

        PersonagemDTO serialized = personagemToAdd.convert(personagem);

        return ResponseEntity.created(uri).body(serialized);
    }
}
