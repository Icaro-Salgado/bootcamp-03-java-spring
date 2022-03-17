package br.com.mercadolivre.java_spring.parte_01.pratica_integradora_01.controller;

import br.com.mercadolivre.java_spring.parte_01.pratica_integradora_01.util.IntegerToRoman;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class NumeroRomanoControler {

    @GetMapping("/decimal-to-roman")
    @ResponseBody
    public String pegaLivrosDoHiro(@RequestParam Integer valor) {
        return IntegerToRoman.prettyPrint(valor);
    }
}
