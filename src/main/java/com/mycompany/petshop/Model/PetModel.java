/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.Model;

/**
 *
 * @author android
 */
public class PetModel<T> extends Model<T> {
    public int id;
    public String nome = null;
    public String raca = null;
    public String cor = null;
    public String tipo = null;
    
    public PetModel (){}

    public PetModel(String nome, String raca, String cor, String tipo) {
        this.nome = nome;
        this.raca = raca;
        this.cor = cor;
        this.tipo = tipo;
    }
    
    @Override
    public String toString() {
        return "ID: " + this.id +
                "\nNome: " + this.nome +
                "\nTipo: " + this.tipo +
                "\nRaca: " + this.raca +
                "\nCor: " + this.cor;
    }
}
