package br.com.mercadolivre.java_spring.parte_01.pratica_integradora_02.controller;

import br.com.mercadolivre.java_spring.parte_01.pratica_integradora_02.util.morsecode_decodifier.MorseCodeDecodifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MorseTranslatorController {

    @GetMapping("/decode")
    @ResponseBody
    public String decode(@RequestParam String message){

        return MorseCodeDecodifier.decode(message);
    }
}