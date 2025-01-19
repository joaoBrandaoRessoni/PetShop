/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.Controller;

import com.mycompany.petshop.Connection.DataBase;
import com.mycompany.petshop.View.Login;

/**
 *
 * @author joao_
 */
public class InitializeController {
    public static void main(String args[]) {
        String criado = DataBase.startDatabase("usuario", "CREATE TABLE usuario ("
                + "id int primary key auto_increment, "
                + "usuario varchar(100), "
                + "senha varchar(100))");
        System.out.println(criado);
        
        criado = DataBase.startDatabase("animal", "CREATE TABLE animal ("
                + "id int primary key auto_increment, "
                + "nome varchar(100), "
                + "raca varchar(100), "
                + "cor varchar(100), "
                + "tipo varchar(100), "
                + "id_usuario int)");
        System.out.println(criado);
        
        criado = DataBase.startDatabase("agendamento", "CREATE TABLE agendamento ("
                + "id int primary key auto_increment, "
                + "data date, "
                + "procedimento varchar(100), "
                + "id_pet int)");
        System.out.println(criado);
        
        new Login().setVisible(true);
    }
}
