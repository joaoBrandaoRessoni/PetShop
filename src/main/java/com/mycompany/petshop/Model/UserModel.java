/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petshop.Model;

/**
 *
 * @author joao_
 */
public class UserModel<T> extends Model<T> {
    public int id;
    public String usuario;
    public String senha;
    
    public UserModel(){}
    
    public UserModel(int id, String usuario, String senha){
        this.id = id;
        this.usuario = usuario;
        this.senha = senha;
    }
}
