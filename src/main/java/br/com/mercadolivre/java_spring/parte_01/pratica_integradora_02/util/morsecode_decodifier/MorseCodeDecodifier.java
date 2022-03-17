package br.com.mercadolivre.java_spring.parte_01.pratica_integradora_02.util.morsecode_decodifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MorseCodeDecodifier {

    public static String decode(String message) {
        // Cada palavra é splitada por três espaços
        String regex = "\\s{3}";

        List<String> morseWords = Arrays.asList(message.split(regex));

        return decodeMorseSentence(morseWords);
    }

    private static String decodeMorseSentence(List<String> morseWords) {

        ArrayList<String> decodedSentence = morseWords.stream()
                .map(MorseWordTranslator::translate)
                .collect(Collectors.toCollection(ArrayList::new));

        // Junta cada palavra da frase
        return String.join(" ", decodedSentence);
    }
}
