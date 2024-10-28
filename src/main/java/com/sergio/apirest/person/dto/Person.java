package com.sergio.apirest.person.dto;

import lombok.Data;

@Data
public class Person {

    private int id;
    private int Cantidad;
    private String Descripcion;
    private double precioUnitario;
    private double Importe;

}
