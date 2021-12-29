package com.example.BuscaCEP.controller;


import com.example.BuscaCEP.facade.BuscaCepFacade;
import com.example.BuscaCEP.model.Endereco;
import com.example.BuscaCEP.ws.BuscaCepWs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultaCep")
public class BuscaCepController {

    @Autowired
    private BuscaCepFacade buscaCepFacade;

    @GetMapping(value = "/{cep}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Endereco> getCep(@PathVariable String cep) {
        Endereco endereco = BuscaCepWs.getCep(cep);
        return ResponseEntity.ok(endereco);
    }

}
