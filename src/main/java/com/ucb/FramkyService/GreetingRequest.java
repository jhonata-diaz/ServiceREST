package com.ucb.FramkyService;


public class GreetingRequest {

    private String nombre;


    public GreetingRequest() {
    }

    public GreetingRequest(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
