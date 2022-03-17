package br.com.mercadolivre.java_spring.parte_01.pratica_integradora_02.util.morsecode_decodifier;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MorseSentenceTranslator {

    public static String decodeMorseSentence(List<String> morseWords) {
        ArrayList<String> decodedSentence = morseWords.stream()
                .map(MorseWordTranslator::translate)
                .collect(Collectors.toCollection(ArrayList::new));

        // Junta cada palavra da frase
        return String.join(" ", decodedSentence);
    }
}
