package com.baking.bff.config;

public class ExceptionConfig extends Exception {

    public String nome;

    public ExceptionConfig(String message, String nome) {
        super(message);
        this.nome = nome;
    }
}
