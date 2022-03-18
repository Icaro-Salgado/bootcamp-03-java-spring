package br.com.mercadolivre.java_spring.parte_01.pratica_integradora_02.util.morsecode_decodifier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MorseCodeDecodifier {

    private final static HashMap<String, String> morseMapper = new HashMap<>();

    static {
        morseMapper.put(".-", "A");
        morseMapper.put("-...", "B");
        morseMapper.put("-.-.", "C");
        morseMapper.put("-..", "D");
        morseMapper.put(".", "E");
        morseMapper.put("..-.", "F");
        morseMapper.put("--.", "G");
        morseMapper.put("....", "H");
        morseMapper.put("..", "I");
        morseMapper.put(".---", "J");
        morseMapper.put("-.-", "K");
        morseMapper.put(".-..", "L");
        morseMapper.put("--", "M");
        morseMapper.put("-.", "N");
        morseMapper.put("--.--", "Ñ");
        morseMapper.put("---", "O");
        morseMapper.put(".--.", "P");
        morseMapper.put("--.-", "Q");
        morseMapper.put(".-.", "R");
        morseMapper.put("...", "S");
        morseMapper.put("-", "T");
        morseMapper.put("..-", "U");
        morseMapper.put("...-", "V");
        morseMapper.put(".--", "W");
        morseMapper.put("-..-", "X");
        morseMapper.put("-.--", "Y");
        morseMapper.put("--..", "Z");
        morseMapper.put("-----", "0");
        morseMapper.put(".----", "1");
        morseMapper.put("..---", "2");
        morseMapper.put("...--", "3");
        morseMapper.put("....-", "4");
        morseMapper.put(".....", "5");
        morseMapper.put("-....", "6");
        morseMapper.put("--...", "7");
        morseMapper.put("---..", "8");
        morseMapper.put("----.", "9");
        morseMapper.put(".-.-.-", ".");
        morseMapper.put("--..--", ",");
        morseMapper.put("---...", ":");
        morseMapper.put("..--..", "?");
        morseMapper.put(".----.", "'");
        morseMapper.put("-....-", "-");
        morseMapper.put("-..-.", "/");
        morseMapper.put(".-..-.", "\"");
        morseMapper.put(".--.-.", "@");
        morseMapper.put("-...-", "=");
        morseMapper.put("−.−.−−", "!");
    }

    public static String decode(String message) {
        // Cada palavra é splitada por três espaços
        String regex = "\\s{3}";
        List<String> morseWords = Arrays.asList(message.split(regex));

        return decodeMorseSentence(morseWords);
    }

    public static String decodeMorseSentence(List<String> morseWords) {
        ArrayList<String> decodedSentence = morseWords.stream()
                .map(MorseCodeDecodifier::translate)
                .collect(Collectors.toCollection(ArrayList::new));

        // Junta cada palavra da frase
        return String.join(" ", decodedSentence);
    }

    public static String translate(String morseWord) {
        // Separa as letras com espaço unico
        List<String> morseCharacters = Arrays.asList(morseWord.split("\\s+"));

        // Mapeia as letras pra letras normais em um ArrayList
        ArrayList<String> normalCharacters = morseCharacters.stream()
                .map(morseMapper::get)
                .collect(Collectors.toCollection(ArrayList::new));

        // Retorna a palavra
        return String.join("", normalCharacters);
    }
}
