package com.example.BuscaCEP.facade;

import com.example.BuscaCEP.model.Endereco;
import com.example.BuscaCEP.ws.BuscaCepWs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscaCepFacade {

    @Autowired
    BuscaCepWs buscaCepWs;

    public Endereco getCep() {
        return this.buscaCepWs.getCep("cep");
    }
}
