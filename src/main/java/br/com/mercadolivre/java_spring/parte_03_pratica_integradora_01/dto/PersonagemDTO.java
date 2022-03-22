package br.com.mercadolivre.java_spring.parte_03_pratica_integradora_01.dto;

import br.com.mercadolivre.java_spring.parte_03_pratica_integradora_01.model.Personagem;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@JsonIgnoreProperties(value = {"skin_color"})
public class PersonagemDTO {
    private String name, hair_color, gender, homeworld, species;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String skin_color, eye_color, birth_year;

    // This will be translated to int later, just to avoid String inputs
    private String height, mass;


    private int safeConverStringToInt(String toConvert) {
        try {
            return Integer.valueOf(toConvert);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public Personagem convert() {

        return Personagem
                .builder()
                .name(this.name)
                .hairColor(this.hair_color)
                .skinColor(this.skin_color)
                .eyeColor(this.eye_color)
                .birthYear(this.birth_year)
                .gender(this.gender)
                .homeworld(this.homeworld)
                .species(this.species)
                .height(this.safeConverStringToInt(this.height))
                .mass(this.safeConverStringToInt(this.mass))
                .build();
    }

    public PersonagemDTO convert(Personagem personagem) {
        this.name = personagem.getName();
        this.hair_color = personagem.getHairColor();
        this.skin_color = personagem.getSkinColor();
        this.eye_color = personagem.getEyeColor();
        this.birth_year = personagem.getBirthYear();
        this.gender = personagem.getGender();
        this.homeworld = personagem.getHomeworld();
        this.species = personagem.getSpecies();

        return this;
    }

    public static List<PersonagemDTO> convertToDTOList(List<Personagem> personagens) {
        return personagens.stream().map(p -> new PersonagemDTO().convert(p)).collect(Collectors.toList());
    }

    public static List<Personagem> convertToObjectList(List<PersonagemDTO> personagensDTO) {
        return personagensDTO.stream().map(p -> p.convert()).collect(Collectors.toList());
    }
}
