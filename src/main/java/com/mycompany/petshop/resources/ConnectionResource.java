/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.resources;
import java.util.ArrayList;

/**
 *
 * @author joao_
 */
public class ConnectionResource<T> {
    public String error;
    public ArrayList<T> dados;
    public boolean estado;

    public ConnectionResource(String error, ArrayList<T> dados, boolean estado) {
        this.error = error;
        this.dados = dados;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Error: " + this.error + "\n" +
                "Dados: \n" + this.dados.toString() + "\n" +
                "Estado :" + this.estado;
    }
    
    
}
