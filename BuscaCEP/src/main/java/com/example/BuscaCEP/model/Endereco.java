package com.example.BuscaCEP.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Endereco {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String IBGE;
    private String Gia;

    public Endereco(String string, String cep,
                    String logradouro,
                    String complemento,
                    String bairro,
                    String localidade,
                    String uf,
                    String IBGE,
                    String Gia) {

        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.IBGE = IBGE;
        this.Gia = Gia;
    }

    @Override
    public String toString() {
        return "Endereço{" +
                "cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", localidade='" + localidade + '\'' +
                ", uf='" + uf + '\'' +
                ", IBGE='" + IBGE + '\'' +
                ", gia='" + Gia + '\'' +
                '}';
    }
}
